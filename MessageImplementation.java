/*Import the java io*/
import java.io.*;

/*Implements Serializable and message to allow a message object to be passed*/
public class MessageImplementation implements Serializable, Message{
	
	/**/
		public int characterCount = 0;
		public int digitCount = 0;
		public String words;  
		
		/*String is passed in to be changed to object*/
		public MessageImplementation(String s){
			this.words =s;
		}
	
	@Override
	public void setCounts() {
		char ch;
		int blanks =0;
		int other = 0;
		for(int i = 0; i < words.length(); i ++)
		{
			ch = words.charAt(i);

			if(Character.isLetter(ch)){
				characterCount ++;}
			
			else if(Character.isDigit(ch)){
				digitCount ++;}
		
			//Testing for detection of whitespace.
			
		/*	else if (Character.isWhitespace(ch)){
					blanks ++; 
					} 
			//Testing for other characters eg. '.' or '_'
			else {
					other++; 
			 	 }*/
		
		}
			/*Testing Prints*/
		/*	System.out.println("Charatcters : "	+ characterCount);
			System.out.println("Digits : "		+ digitCount);
			System.out.println("Spaces : "		+ blanks);
			System.out.println("Other characters : " + other);*/
		
	}
	
	
	/*getCharacterCount method returns characterCount*/
	@Override
	public int getCharacterCount() {
			return characterCount;
			}
	
	/*getDigitCount method returns digitCount*/
	@Override
	public int getDigitCount() {
			return digitCount;
			}

	}
