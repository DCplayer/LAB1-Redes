import com.sun.corba.se.spi.servicecontext.SendingContextServiceContext;

import java.io.*;
import java.net.*;

public class UDPClientAPP {

    public UDPClientAPP(){
        super();
    }

    public void run(int port){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket ClientSocket = new DatagramSocket();
            InetAddress IP = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            String sentence = input.readLine();
            sendData = sentence.getBytes();
            DatagramPacket SendingPackage = new DatagramPacket(sendData, sendData.length, IP, port);
            ClientSocket.send(SendingPackage);
            DatagramPacket receivePackage = new DatagramPacket(receiveData, receiveData.length);
            ClientSocket.receive(receivePackage);
            String Xsentence = new String(receivePackage.getData());
            System.out.println("Server: " + Xsentence);
            ClientSocket.close();
        }
        catch(Exception e){
            System.out.println("Something went wrong: UDPClientApp");
        }
    }
}
