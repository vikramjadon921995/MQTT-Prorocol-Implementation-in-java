package threeT;

import org.eclipse.paho.client.mqttv3.*;

public class DoctorPublish 
{
  private String reg, mes = "medicine 1";
  
  public DoctorPublish()
  {
      System.out.println("In PahoDemo()");
  }
    public void setReg(String s)
    {//setter
        System.out.println("in setReg : " + s); 
        //uid = encrypt(s); 
        reg = s.toLowerCase();
    }
    
    public String getReg()
    {//getter
        //return decrypt(uid);
        return reg;
    }
   
    public void setMes(String s)
    {//setter
        System.out.println("in setMes : " + s); 
        //pass= encrypt(s); 
        mes = s.toLowerCase();
    }
    
    public String getMes()
    {//getter
        //return decrypt(pass);
        return mes;
    }

  public boolean doDemo() {
    try {
         MqttClient client;
        System.out.println("In doDemo()");
      client = new MqttClient("tcp://192.168.0.103:1886", "DoctorPublish");
      client.connect();
      System.out.println("connected");
      System.out.println("message : " + mes);
      System.out.println("topic : " + reg);
      MqttMessage message = new MqttMessage();
      message.setPayload(mes.getBytes());
      client.publish(reg , message);
      client.disconnect();
    } catch (MqttException e) {
        System.out.println("Exception!!");
      e.printStackTrace();
      return false;
    }
    return true;
  }
}