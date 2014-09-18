Password Checking
============================

<html>

<body>
<h4>
It's a simple class to check the word, especially for password. 
</h4>

<ol type="1">

<li> Security level:</li>

<ol type="a">

 <li>  Must have at least one upper case letter and Must have at least one number. </li>
 <li>  Must be at least 6 characters. </li>
 <li>  Cannot be one of the specific words.</li>

	 111111
	 password
	 123456
  
 </ol>
    
    
<li> Spec: </li>

<ul>

  <li>  checkCombinedPassword(String) // Check the word with all security levels. </li>

  <li>  checkCombinedPassword(String, int) // Check the word with a specific security level. </li>
  
  <li>  checkCombinedPassword(String, int, String[]) // Check the word with a specific level and custom sensitive words.</li> 
  
  <li>  checkCombinedPassword(String, int, List<String>) // Check the word with a specific level and custom sensitive words. </li>

</ul>
  
  
<li> About Usage:  </li>

<p>
    String p = "word"; <br>
    try {<br>
          Password pp = new Password(); <br>
          pp.checkCombinedPassword(p);<br>

    } catch (Exception e) { <br>
      //Put your code to handle the exception when you calling it. <br>
    } <br>
    
</p>



<p>
Try it on your hand!

Thanks!
</p>

</body>

</html>
