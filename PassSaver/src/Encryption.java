import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Encryption {
	
	private static final int OFFSET = 100;
	private String passEncStrF = "";
	private int key;
	
	public static String encrypt_2 (String pass) {
		
		String passEncStr = "";
		char [] passDecChar;
		char [] passEncChar;
		
		passDecChar = pass.toCharArray();		
		passEncChar = new char [passDecChar.length + OFFSET * 2];
		
		for (int i = 0; i < passEncChar.length; i++) {
			
			if (i < OFFSET || i > (passEncChar.length - OFFSET - 1)) {
				
				int aux_int = ThreadLocalRandom.current().nextInt(33, 127);
				char aux_char = (char) (aux_int - 1);
				
				passEncChar [i] = aux_char;
			}
			else {
				
				char aux = (char) (passDecChar [(passDecChar.length - 1) - (i - OFFSET)] - 1);
				
				if (aux < 33) {
					
					aux = 126;
				}
				
				passEncChar [i] = aux;
			}
		}
		
		//passEncStrF = String.copyValueOf(passEncChar);
		passEncStr = String.copyValueOf(passEncChar);
		
		return passEncStr;		
	}
	
	public String getEncPass () {
		
		return passEncStrF;
	}
	
	public static String decrypt_2 (String pass) {
		
		String passDecStr = "";
		char [] passDecChar;
		char [] passEncChar;
		
		passEncChar = pass.toCharArray();
		passDecChar = new char [passEncChar.length - OFFSET * 2];
		
		for (int i = 0; i < passEncChar.length; i++) {
			
			if (i < OFFSET || i > (passEncChar.length - OFFSET - 1)) {
				
			}
			else {
				
				char aux = (char) (passEncChar [(passEncChar.length - 1) - i] + 1);
				
				if (aux > 126) {
					
					aux = 33;
				}
				
				passDecChar [i - OFFSET] = aux;
			}
		}
		
		passDecStr = String.copyValueOf(passDecChar);
		
		return passDecStr;
	}
	
	public static boolean check (String pass) {
		
		char [] pass_char = pass.toCharArray();
		
		if (pass.length() == 0) {
			
			System.out.println("0 char password");
			return false;
		}
		
		for (char e:pass_char) {
			
			if (e < 33 || e > 126) {
				
				System.out.println("Invalid char in password");
				return false;
			}
		}
		
		return true;
	}
}
