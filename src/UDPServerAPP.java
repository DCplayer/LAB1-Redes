import java.io.*;
import java.net.*;

public class UDPServerAPP {

    public UDPServerAPP(){
        super();
    }

    public void run(int port){
        try{
            DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] recieveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true){
                DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String( receivePacket.getData());
                System.out.println("Paquete Recibido:" + sentence);
                InetAddress IP = receivePacket.getAddress();
                int SendingPort = receivePacket.getPort();
                String CapsLock = sentence.toUpperCase();
                sendData = CapsLock.getBytes();
                DatagramPacket SendingPackage = new DatagramPacket(sendData, sendData.length, IP, SendingPort);
                serverSocket.send(SendingPackage);
            }

        }
        catch(Exception e){
            System.out.println("Something went wrong: UDPServerAPP");
        }
    }
}
