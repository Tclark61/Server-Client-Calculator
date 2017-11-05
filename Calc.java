/*
Programmer: Tyler Clark
CNT4704
10/20/2017

*/

import java.io.*;
import java.net.*;


class Calc{

	public static void main(String[] args) throws IOException {

		//Get the port from the file input
        int portNumber = Integer.parseInt(args[0]);
		
		
        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
			
			out.println("Welcome to Tyler's Calculator! Currently supporting:\nAddition, Subtraction, Multiplication, and Division.\nWhen you're done, please type '0/0' to end the program.");
        
            String inputLine, outputLine;
            
            // Initiate conversation with client
            CalcProtocol cProto = new CalcProtocol();

            while ((inputLine = in.readLine()) != null) {
				if(inputLine.equals("0/0")){
					break;
				}
                outputLine = (cProto.answer(inputLine));
				if (outputLine.equals(null))
                    break;
                out.println(outputLine);
            }
        } catch (IOException e) {
            System.out.println("The port number " + portNumber + " didn't work. :(");
            System.out.println(e.getMessage());
        }
    }
	
}