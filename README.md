# Server-Client-Calculator
Basic Calculator that utilizes server and client code

My code, split into three java files (Calc.java, CalcProtocol.java, and CalcClient.java), is used to create a calculator on the server side (Calc.java) that can be accessed by the client side (CalcClient.java). 
Calc.java is the server side program. It creates a server socket connected to a port, and prepares to connect to the client. It then references CalcProtocol.java, which is the actual calculator, and passes it the input from the client (received from CalcClient.java). Once it retrieves a print statement from CalcProtocol, it delivers it back to CalcClient, which prints the statement out for the client to see.

The server-side starts by simply accessing a private server and running Calc with a port as input, and the client side starts by accessing the same private server and running CalcClient with the IP address and port as input. The program will continue to work as a calculator until the user types 0/0. 
