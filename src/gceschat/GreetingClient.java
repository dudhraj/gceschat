package gceschat;

//File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class GreetingClient
{
public static void main(String [] args)
{
   int serverName = 8888;
   int port = 8000;
   try
   {
      System.out.println("Connecting to " + serverName +
		 " on port " + port);
      Socket client = new Socket();
      System.out.println("Just connected to " 
		 + client.getRemoteSocketAddress());
      OutputStream outToServer = client.getOutputStream();
      DataOutputStream out = new DataOutputStream(outToServer);
      out.writeUTF("Hello from "
                   + client.getLocalSocketAddress());
      InputStream inFromServer = client.getInputStream();
      DataInputStream in =
                     new DataInputStream(inFromServer);
      System.out.println("Server says " + in.readUTF());
      client.close();
   }catch(IOException e)
   {
      e.printStackTrace();
   }
}
}