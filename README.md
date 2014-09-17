Password Checking
============================

It's a simple class to check the word, especially for password. 

1. Security level:

  1). Must have at least one upper case letter and Must have at least one number
	2). Must be at least 6 characters
	3). Cannot be one of the specific words
	 			111111
	 			password
	 			123456
    
2. Spec:

  1) checkCombinedPassword(String) // Check the word with all security levels. 
  2) checkCombinedPassword(String, int) // Check the word with a specific security level.
  3) checkCombinedPassword(String, int, String[]) // Check the word with a specific level and custom sensitive words. 
  4) checkCombinedPassword(String, int, List<String>) // Check the word with a specific level and custom sensitive words.
  
  
3. About Usage:


    String p = "word";
    try {
       Password pp = new Password();
       pp.checkCombinedPassword(p);

    } catch (Exception e) {
      //Put your code to handle the exception when you calling it.
    }
    
Try it on your hand!

Thanks!
    
    
