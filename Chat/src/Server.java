
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  public static void main(String[] args) throws IOException {
    
        ServerSocket serversocket= new ServerSocket(5678);
        Socket socket =serversocket.accept();//listen for client 
        
        Scanner fromconsole=new Scanner(System.in);//read from console
        Scanner fromclient =new Scanner(socket.getInputStream());//reseve from client
        PrintWriter fromserver = new PrintWriter(socket.getOutputStream());// send from server to client
        
        
        String inputfromserver,inputfromconsole ;
        while(true){
        inputfromserver= fromclient.nextLine();// read what the client has sent and put it in inputfromsrver
            System.out.println("client: "+inputfromserver);//print what the client said
            if (inputfromserver.equals("*exit*")){
            break; }
            System.out.print("server: ");
            
            inputfromconsole=fromconsole.nextLine();
            
            
            fromserver.println(inputfromconsole);
            fromserver.flush();
            if (inputfromconsole.equals("*exit*")){
                break;
            }
        }
}
  
}
