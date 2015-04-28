package threeT;
import java.sql.*;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.*;
import java.io.*;
import java.net.*;
import java.lang.*;

class DatabseSubscriber extends Thread implements MqttCallback{

MqttClient client = null;

 public final static int SOCKET_PORT = 2000;      
 public final static String SERVER = "192.160.0.100";
 FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
 String
       FILE_TO_RECEIVED = "C:\\Users\\Jadon\\Documents\\NetBeansProjects\\jsp\\MQTT-Prorocol-Implementation-in-java\\web\\p2photo.jpg";                                                   
 public final static int FILE_SIZE = 6022386;

public DatabseSubscriber() {
    System.out.println("In const");
    start();
}

public void run()
{
    System.out.println("In run");
    doDemo();
}

public static void main(String[] args){
	new DatabseSubscriber().doDemo();
}

public static void Databaseconnect(String topic, String p_id, double temp, double heart_b, String pphoto, String ecgphoto){
   String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   //if(topic == "region1"){
       String DB_URL = "jdbc:derby://localhost:1527/broker";
       //  Database credentials
       String USER = "root";
       String PASS = "vikramjadon95";
       Connection conn = null;
       Statement stmt = null;
       try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;
           System.out.println(topic+" "+temp+" "+heart_b+" "+pphoto+" "+ecgphoto);
           sql = "UPDATE "+topic+" SET temp = " + temp + ",heart_b = " + heart_b +",p_photo = '" +pphoto+ "',p_ecg = '" +ecgphoto+ "' WHERE p_id = \'" + p_id + "\'";
          stmt.executeUpdate(sql);
           sql = "INSERT INTO " + p_id + " VALUES(\'" +p_id+ "\'," + temp + "," + heart_b + ",\'" +pphoto+ "\',\'" +ecgphoto+ "\')";
           stmt.execute(sql);
           sql = "DELETE FROM \'" + p_id + "\' LIMIT 1";
           stmt.executeUpdate(sql);
           stmt.close();
           conn.close();
       } catch (SQLException se) {
           //Handle errors for JDBC
           se.printStackTrace();
       } catch (Exception e) {
           //Handle errors for Class.forName
           e.printStackTrace();
       } finally {
           //finally block used to close resources
           try {
               if (stmt != null) {
                   stmt.close();
               }
           } catch (SQLException se2) {
           }// nothing we can do
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException se) {
               se.printStackTrace();
           }//end finally try
       }//end try
       System.out.println("Goodbye!");
}

public void doDemo(){
    System.out.println("In doDemo");
    try{
        System.out.println("------sock");
        servsock = new ServerSocket(2500);
        System.out.println("------sock created");
    }
    catch(Exception ex)
    {
        System.out.println("Error in connecting to server : " + ex);
    }
        try {
            client = new MqttClient("tcp://192.168.0.103:1886", "SubscribePatient2");
            client.connect();
            client.setCallback(this);
            client.subscribe("#");
        }catch (MqttException e) {
            try{
                System.out.println("+++++++++++Error++++++++");
                client.disconnect();
                client = new MqttClient("tcp://localhost:1887", "SubscribePatient2");
                client.connect();
                client.setCallback(this);
                client.subscribe("#");
            }
            catch(Exception ex)
            {
                System.out.println("----------Error : " + ex);
            }
            
            System.out.println("----------Error-------------- : ");
            e.printStackTrace();
        }
}

@Override
public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub
    System.out.println("--------------connection lost------------");
    try{
        if (fos != null) fos.close();
            if (bos != null) bos.close();
            if (sock != null) sock.close();
            if (servsock != null) servsock.close();
    }
    catch(Exception ex)
    {
        System.out.println("-------------closed----------");
    }
}

@Override
public void messageArrived(String topic, MqttMessage message)throws Exception 
{
    Character mes[] = new Character[500] ;
    System.out.println("---------Message arived----------");
    if(!message.toString().equals("Patient's Details Sent!!"))
    {
        for(int i=0;i<((message).toString()).length();i++)
        {
            	mes[i]=((message).toString()).charAt(i);
	}
	String pid = "", tem = "", hr = "",pphoto = "", ecgphoto = "";
	int flag = 0;
	for(int i = 0; i < ((message).toString()).length();)
	{
		if(flag == 0){
			while(mes[i] != ' '){
				pid = pid + mes[i];
				i++;
			}
			i++;
			flag = 1;
		}
		else if(flag == 1)
		{
			while(mes[i] != ' '){
				tem += mes[i];
				i++;
			}
			i++;
			flag = 2;
		}
                else if(flag == 2)
		{
                    while(mes[i] != ' '){
			hr += mes[i];
			i++;
                    }
                    i++;
                    flag = 3;
		}
                else if(flag == 3)
		{
                    while(mes[i] != ' '){
			pphoto += mes[i];
			i++;
                    }
                    i++;
                    flag = 4;
		}
                else if(flag == 4){
                    ecgphoto += mes[i];
                    i++;
                }
	}
	double temp = Double.parseDouble(tem);
	double hb = Double.parseDouble(hr);
        System.out.println(message);
	System.out.println("message by " + topic + " is " + pid +" "+ temp +" "+ hb + " " +pphoto+" "+ecgphoto);
 
        Databaseconnect(topic,pid,temp,hb,pphoto,ecgphoto);
        String[] s = {pphoto, ecgphoto};
        
        int count = 2;
        for(int i = 0; i < count; i++){
            try
            {
                
                FILE_TO_RECEIVED = "C:/Users/Jadon/Documents/NetBeansProjects/jsp/MQTT-Prorocol-Implementation-in-java/web/"+s[i];
                //servsock = new ServerSocket(5000);
                System.out.println("-----------------------");
                sock = servsock.accept();
                System.out.println("-----------------------accepted");

                byte [] mybytearray  = new byte [FILE_SIZE];
                System.out.println("-----------------------mybytearray");
                InputStream is = sock.getInputStream();
                System.out.println("-----------------------inputstream");
                fos = new FileOutputStream(FILE_TO_RECEIVED);
                System.out.println("-----------------------fos");
                bos = new BufferedOutputStream(fos);
                System.out.println("-----------------------bos");
                bytesRead = is.read(mybytearray,0,mybytearray.length);
                System.out.println("-----------------------bytesread");
                current = bytesRead;
                System.out.println("-----------------------bytesread");

                do {
                    bytesRead =
                    is.read(mybytearray, current, (mybytearray.length-current));
                    if(bytesRead >= 0) current += bytesRead;
                } while(bytesRead > -1);
                System.out.println("-----------------------while");

                bos.write(mybytearray, 0 , current);
                System.out.println("-----------------------write");
                bos.flush();
                System.out.println("-----------------------flush");
                System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
                if (fos != null) fos.close();
                if (bos != null) bos.close();
                //if (sock != null) sock.close();
                //if (servsock != null) servsock.close();
            }
            catch(Exception ex)
            {
                System.out.println("Error in Receiving : " + ex);
                if (fos != null) fos.close();
                if (bos != null) bos.close();
                // if (sock != null) sock.close();
                if (servsock != null) servsock.close();
            }
            finally
            {
            }
        }
        
        MqttClient client1 = new MqttClient("tcp://192.168.0.103:1886", "PublishingPatientInfo");
	client1.connect();
	MqttMessage mesa = new MqttMessage();
        mesa.setPayload("Patient's Details Sent!!".getBytes());
        client1.publish(topic, mesa);
        client1.disconnect();
    }    
    
    
}
@Override
public void deliveryComplete(IMqttDeliveryToken token) {
    // TODO Auto-generated method stub

}
}