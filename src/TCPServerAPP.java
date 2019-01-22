import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerAPP {

    public TCPServerAPP(){
        super();
    }

    public void run(int port){
        try{
            ServerSocket DoubleS = new ServerSocket(port);
            Socket socket = DoubleS.accept();
            PrintStream Ps = new PrintStream(socket.getOutputStream());
            BufferedReader Bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String sentence ;

            while(true){
                System.out.println("Q-- para salir");
                sentence = Bf.readLine();
                System.out.println(sentence);
                Ps.println(sentence);
                if(sentence.equals("Q--")){
                    break;
                }
            }

            Ps.close();
            Bf.close();
            socket.close();
            DoubleS.close();
        }
        catch(Exception e){
            System.out.println("Something went wrong: TCPServerApp");
        }
    }
}
