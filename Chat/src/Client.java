
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("Localhost", 5678);// create the socket that we will send and recive from
            Scanner fromconsole = new Scanner(System.in);//read from the consol---->to then send it to server

            Scanner fromserver = new Scanner(socket.getInputStream());//read from server
            PrintWriter fromclient = new PrintWriter(socket.getOutputStream(), true);//write the client massgae    //flush to the other side as well

            String input, output;
            while (true) {
                System.out.print("client: ");
                input = fromconsole.nextLine();

                fromclient.println(input);//send the thing written in the conole to the server
                if (input.equals("*exit*")) {
                    break;
                }
                output = fromserver.nextLine();
                System.out.print("server: ");
                System.out.println(output);
                if (output.equals("*exit*")) {
                    break;
                }
            }
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
