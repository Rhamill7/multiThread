
import java.io.*;
import java.net.*;


/* The Class implements Serializable.*/
public class Client implements Serializable { 
	
	/**
  * The main method.
  *
  * @param argv the arguments
  * @throws Exception the exception
  */
 public static void main(String argv[]) throws Exception //Main Method throws exception
		{
		try{	
			String sentence; //Makes a new local sentence of type string.
			Socket clientSocket = new Socket("127.0.0.1", 6100); 
			//makes a new client socket to the server 
	
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
			//Opens an input stream to take a sentence from the console that was typed in by the user
			
			sentence = inFromUser.readLine(); 
			//sentence to the line the was read from the buffered reader input stream.
			
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
			//Opens an output stream to server.
			
			outToServer.writeBytes(sentence + '\n'); 
			//writes the sentence to the server and goes to a new line
			
			outToServer.flush(); 
			//Flushes the output stream and forces any buffered output bytes to be written out.
			
			ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream()); //Gets data in from server
			//Opens a new Object input stream from the Server to receive objects.
			
			Message message = null; //Creates a new message that is null
			message = (Message) inFromServer.readObject(); //Sets message to the read in object
		
			/*Prints the character count and digit count of the object.*/
			System.out.println("The character count of your sentence is : " + message.getCharacterCount()); 
			System.out.println("The digit count of your sentence is : " + message.getDigitCount()); 
			
			clientSocket.close(); //close socket connection to server 

			
			} 
			/*Catches and prints exception*/
			catch (IOException ioe){
				System.err.println("Cannot connect to server.");
			}
	
		}
	}
