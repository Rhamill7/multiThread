import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * The Class MyThread.
 */
	class MyThread implements Runnable { //MyThread implements runnable interface
		
	/** The client sentence. */
 String clientSentence; 					//Creates a new string called clientSentence
		
 	/** The connection socket. */
 Socket connectionSocket; 				// Creates a new socket called connectionSocket 
		
		/**
		 * Instantiates a new my thread.
		 *
		 * @param s the s
		 */
		public MyThread(Socket s){ 		//Handles the current socket being passed in
			this.connectionSocket = s;
			}
		
	
		public void run() { //the run method
			System.out.println("A new thread is running ... " ); //prints when a new thread is running
			BufferedReader inFromClient;
			try {
				inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			//opens input through the connection
		
			
			clientSentence = inFromClient.readLine();   //reads the line from the client server          
			System.out.println("Your message: " + clientSentence + " was recieved successfully. ");           
			//Prints the client sentence to show the user it was recieved by the server successfully.
		
			Message message = new MessageImplementation(clientSentence); //Creates a new message object 
			message.setCounts(); //calls the set counts method from MessageImplementation
			  
			 ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
			 //opens a new object output stream to client 
		 	 
			 outToClient.writeObject(message); 
			 // Writes the character count and digit count out to the client as an Object through the ObjectOutPutStream. 
			 
			 /*Testing Prints*/
			 //System.out.println("Testing character count :" + message.getCharacterCount() );
			 //System.out.println("Testing digit count :" + message.getDigitCount() );
		
		 	connectionSocket.close(); //Closes the current open connection socket.
		 	
			 } catch (IOException e) {
				 e.printStackTrace();
			 		}
			}
	} 
