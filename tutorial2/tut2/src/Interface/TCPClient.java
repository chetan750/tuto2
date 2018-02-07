package Interface;



import java.net.*;
import java.util.Vector;
import java.io.*;
public class TCPClient {
 public static void main(String[] args) throws Exception {
	


	
 try{
   Socket socket=new Socket("127.0.0.1",8888);
   DataInputStream inStream=new DataInputStream(socket.getInputStream());
   DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   String clientMessage="";
   double res;
   Vector<String> v = new Vector<String>();
   Vector<Double> r=new Vector<Double>();
	
		

	 while(true)
	 {
		   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		 System.out.println("Enter expression :");
	     
		 clientMessage=br.readLine();
	   if(!clientMessage.equals("quit")) {
	   
	    
	     v.add(clientMessage);
	     
	     outStream.writeUTF(clientMessage);
    	 outStream.flush();
	     res = inStream.readDouble();
	 
	     r.add(res);
	     System.out.println("Ans: "+res);
	   
	 } 
	 
	   
	   else {
		  
		   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		   System.out.println("\nHistory: |");
		   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		   for(int k=0;k<v.size();k++)
		   {
			   System.out.println("\n"+v.get(k)+" = "+r.get(k));
		   }		   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	  
	   break;}
	 }
 
   
  
   
  
  
   
 }catch(Exception e){
   System.out.println(e);
 }
 }
}