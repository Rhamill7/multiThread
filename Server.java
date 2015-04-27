/*
 * Robbie Hamill CES 201213786 ACE2 v2.0 20/11/2014 
 */

/******************************************* REVISION HISTORY******************************************
 * 28/10/14-Began work on the ace by taking the client and server from class slides CS313_02.
 * 			Put both the server and client into their respective classes and began running the code to
 * 			figure out how each line worked in regards to the rest of the class. Successfully managed 
 * 			to run both server and client in order.
 * 
 * 04/10/14-Started editing the code to send a message entered into the console window. Successfully 
 * 			managed to send a message over an input stream using a buffered reader from client to server.
 * 			However sending back over an output stream proved difficult due to having only input streams. 
 * 			Added proper output streams and sent a message back from server to client. Modified the 
 * 			server to edit the message by capitalising it.  
 * 
 * 11/11/14-Added the message interface class from the book Operating Systems Concepts with Java 8th edition.
 *			Added a second class called message implementation to implement the message interface. 
 *			Implemented the setter and getter methods. Failed to use message object on first try due to
 *			not using an object reader and writer. Failed on second try for not implementing serializable.	
 * 			Succeeded on third try and successfully sent messages back and forth between  a single client 
 * 			and a single server.
 * 
 * 18/11/14-Researched multi threading using slides CS313_03 and decided to move most server code into a
 *  		new class called MyThread. Failed to run due to not implementing runnable in the new class.
 *  		Added in lines to create a new thread and run using the start() function.
 *  		Added lines for thread pooling. used a cached thread pool to run as many threads as needed.
 *  		Worked with manually entered clients.Added test prints throughout to ensure strings and 
 *  		objects were being passed correctly. Tested server with a loop for clients from 2 to over 9000.
 * 
 * 20/11/14-Tidied up code and added comments to provide clear meaning and instruction.
 *****************************************************************************************************/


import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 * The Class Server.
 */
public class Server  { 
	
/**
  * The main method that throws an IO exception.
  */
 public static void main(String args[]) throws Exception 
		{
	 	System.out.println("Server socket is now open.");
	 	
		ExecutorService pool = Executors.newCachedThreadPool();//create thread pool
		
		ServerSocket welcomeSocket = new ServerSocket(6100); //makes new server socket at port 6100
		
		/*While true will loop forever*/
	while(true) 
			{
				try {
						Socket connectionSocket = welcomeSocket.accept();
						//opens new socket connection
						
						/*Code for multi threading without threadpooling*/
//						Thread t = new Thread(new MyThread(connectionSocket)); //Creates new thread and passes in connectionSocket
//						t.start(); //Calls start method on the new thread t which executes the run method in "MyThread"
					
						/*run each task using a thread in pool, uncomment for loop test*/
//					for (int i = 0; i<9001; i++){
						pool.execute(new MyThread(connectionSocket));

//							}
						} 
						
				/*Catches and prints exception*/
				catch (IOException ioe){
					System.err.println(ioe);
					}
				}
			}
		}