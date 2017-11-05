/*
Programmer: Tyler Clark
CNT4704
10/20/2017

*/

import java.io.*;
import java.net.*;



public class CalcClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket calcSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(calcSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(calcSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
			
			for(int i = 0; i < 3; i++){
				System.out.println("Server: " + in.readLine());
			}
			
            //while ((fromServer = in.readLine()) != null) {
			while(true){              
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
				if(fromUser.equals("end"))
					break;
				
				fromServer = in.readLine();
				if (fromServer == null)
                   break;
                System.out.println("Server: " + fromServer);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}