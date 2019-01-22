import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientAPP {
    public TCPClientAPP(){
        super();
    }

    public void run(int port){
        try{
            Socket socket;
            PrintStream Ps;
            BufferedReader Bf;
            String host = "localhost";
            String respuesta;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            socket = new Socket(host,port);
            Ps = new PrintStream((socket.getOutputStream()));
            Bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                System.out.println("Q-- para salir");
                System.out.print("Mensaje a enviar: ");
                Ps.println(in.readLine());
                respuesta = Bf.readLine();
                if(respuesta.equals("Q--")){
                    break;
                }
            }

            Ps.close();
            Bf.close();
            socket.close();
        }
        catch(Exception e){
            System.out.println("Something went wrong: ");
        }
    }
}
