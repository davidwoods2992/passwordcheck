
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Password {
	
	/**
	 * A custom exception to implicate the requirement of making password.
	 *
	 */
	private static class PasswordNotCombinedException extends Exception {

		private String hint = null;
		
		public PasswordNotCombinedException() {
			super();
		}
		
		public PasswordNotCombinedException(String hint) {
			super(hint);
			this.hint = hint;
		}
		
		public String toString() {
			return this.hint;
		}
	}

	public static void main(String[] args) {
		System.out.print("Please enter a word: ");
		Scanner ss = new Scanner(System.in);
		String p = ss.nextLine();
		Password pp = new Password();
		ArrayList<String> senseword = new ArrayList<String>();
		senseword.add("abc");
		senseword.add("ccc");
		senseword.add("222222");
		try {
			pp.checkCombinedPassword(p, 3, senseword);
		} catch (PasswordNotCombinedException e) {
			System.out.println(e);
		}
	}
	
	private final static String[] EASY_WORDS = {"111111",
									"password",
									"123456"};
	
	
	/**
	 * Check all security level, like showed in the following, 
	 * and check specific chars that default at the beginning.
	 * return true if the password is satisfied by rules. or false.
	 * @param password: a password from calling method.
	 * @throws PasswordNotCombinedException.
	 */
	public void checkCombinedPassword(String password) throws PasswordNotCombinedException {
		//s1. Check easy rules. Once found the breach, and then throw the exception immediately.
		//s2. Traversing all the chars one by one in a loop.
		//s3. Check all the rules with API in the loop.
		//s4. Once found the breach of password, and then throw the custom Exception immediately after the loop.
		int strLength = password.length();
		
		if (strLength < 6) throw new PasswordNotCombinedException("The password too short!");

		checkWords(password); // This function can be only used in this class. Check the password with specific words in here. 

		mustOneNumberOneUpper(password); // This function can be only used in this class.
		
	}
	
	/**
	 * Check specific security level
	 * @param password: a password from calling method
	 * @param level: what kind of security level. 
	 * 		1. Must have at least one upper case letter and Must have at least one number
	 * 		2. Must be at least 6 characters
	 * 		3. Cannot be one of the specific words
	 * 			111111
	 *			password
	 *			123456
	 * @throws PasswordNotCombinedException
	 * 
	 */
	public void checkCombinedPassword(String password, int level) throws PasswordNotCombinedException {
		//s1. see what level do user needs.
		//s2. go to specific level and check the password with rules.
		int strLength = password.length();
		switch (level) {
		case 2:
			if (strLength < 6) throw new PasswordNotCombinedException("The password too short!");
			break;
		case 1:
			mustOneNumberOneUpper(password); // This function can be only used in this class.
			break;
		case 3:
			checkWords(password); // This function can be only used in this class. 
								  // Check the password with default specific words in here.
			break;
		default:
			throw new PasswordNotCombinedException("Sorry, the password is not proper!");
		}
	}
	
	/**
	 * Check specific security level
	 * @param password: a password from calling method
	 * @param level: what kind of security level. 
	 * 		1. Must have at least one upper case letter and Must have at least one number
	 * 		2. Must be at least 6 characters
	 * 		3. Cannot be one of the specific words
	 * 			111111
	 *			password
	 *			123456
	 * @param specStr exclude specific words
	 * @throws PasswordNotCombinedException
	 * 
	 */
	public void checkCombinedPassword(String password, int level, List<String> words) throws PasswordNotCombinedException {
		//s1. see what level do user needs.
		//s2. go to specific level and check the password with rules.
		int strLength = password.length();
		switch (level) {
		case 2:
			if (strLength < 6) throw new PasswordNotCombinedException("The password too short!");
			break;
		case 1:
			mustOneNumberOneUpper(password); // This function can be only used in this class.
			break;
		case 3:
			checkWords(password, words); // This function can be only used in this class. 
								  // Check the password with default specific words in here.
			break;
		default:
			throw new PasswordNotCombinedException("Sorry, the password is not proper!");
		}
	}
	
	
	/**
	 * Check specific security level
	 * @param password: a password from calling method
	 * @param level: what kind of security level. 
	 * 		1. Must have at least one upper case letter and must have at least one number
	 * 		2. Must be at least 6 characters
	 * 		3. Cannot be one of the specific words, like
	 * 			111111
	 *			password
	 *			123456
	 * @param specStr exclude specific words
	 * @throws PasswordNotCombinedException
	 * 
	 */
	public void checkCombinedPassword(String password, int level, String[] words) throws PasswordNotCombinedException {
		int strLength = password.length();
		switch (level) {
		case 2:
			if (strLength < 6) throw new PasswordNotCombinedException("The password too short!");
			break;
		case 1:
			mustOneNumberOneUpper(password); // This function can be only used in this class.
			break;
		case 3:
			checkWords(password, words); // This function can be only used in this class. 
								  // Check the password with default specific words in here.
			break;
		default:
			throw new PasswordNotCombinedException("Sorry, the password is not proper!");
		}
	}
	
	
	private void checkWords(String p) throws PasswordNotCombinedException {
		for (int i = 0; i < EASY_WORDS.length; i ++) {
			if (p.equalsIgnoreCase(EASY_WORDS[i])) 
				throw new PasswordNotCombinedException("The password cannot be some specific words, like 123456!");
		}
	}
	
	private void checkWords(String p, String[] wordsGroups) throws PasswordNotCombinedException {
		List<String> wordsList = Arrays.asList(wordsGroups);
		checkWords(p, wordsList);
	}
	
	private void checkWords(String p, List<String> wordsGroups) throws PasswordNotCombinedException {
		Iterator<String> it = wordsGroups.iterator();
		while (it.hasNext()) {
			if (p.equalsIgnoreCase(it.next())) {
				throw new PasswordNotCombinedException("The password cannot be some specific words, like 123456!");
			}
		}
	}
	
	
	private void mustOneNumberOneUpper(String p) throws PasswordNotCombinedException {
		int hasUpperCases = 0;
		int hasNumbers = 0;
		for (int idx = 0; idx < p.length(); idx++) {
			hasUpperCases += Character.isUpperCase(p.charAt(idx)) ? 1 : 0;
			hasNumbers += Character.isDigit(p.charAt(idx)) ? 1 : 0;
		} // end loop.
		
		if (hasNumbers == 0 || hasUpperCases == 0) 
			throw new PasswordNotCombinedException("Must contains one Number and one Upper case at least!");
		
	}
	

}
