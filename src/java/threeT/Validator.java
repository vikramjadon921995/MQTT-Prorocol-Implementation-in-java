package threeT;
import java.lang.*;

//code it as a java bean
//rule 1 : It must have a public parameterless constructor
//rule 2 : It must have private member variables corresponding to the input
//rule 3 : The member variable must be carefully exposed using getter/setter methods as per design rules.
//rule 4 : Host/Access processing methods

public class Validator implements Runnable 
{
    private String uid, pass;

    public Validator()
    {
        System.out.println("in VALIDATOR()");
        //some code as per need
    }
    
    public void setUid(String s)
    {//setter
        System.out.println("in setUid : " + s); 
        //uid = encrypt(s); 
        uid = s.toLowerCase();
    }
    
    public String getUid()
    {//getter
        //return decrypt(uid);
        return uid;
    }
    
    public void setPass(String s)
    {//setter
        System.out.println("in setPass : " + s); 
        //pass= encrypt(s); 
        pass = s;
    }
    
    public String getPass()
    {//getter
        //return decrypt(pass);
        return pass;
    }

    public boolean validate()
    {
        System.out.println("In vali");
        //use the backend
       // Thread t = new Thread();
        //t.start();
        new DatabseSubscriber(); 
        DatabaseConnect smg = new DatabaseConnect();
        return pass.equals(smg.getPassword(uid));
    }
    public void run()
    {
        System.out.println("Ready for Subscribing!!");
        new DatabseSubscriber(); 
    }
}
