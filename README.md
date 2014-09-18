Password Checking
============================

<html>

<body>
<h4>
It's a simple class to check the word, especially for password. 
</h4>

<ol type="1">

<li> Security level:

	<ol type="a">

 		<li>  Must have at least one upper case letter and Must have at least one number. </li>
 		<li>  Must be at least 6 characters. </li>
 		<li>  Cannot be one of the specific words. like: 

	 		111111, 
			password,
	 		123456
	 	</li>
  
 	</ol>
 </li>   
    
<li> Spec: 

	<ul>

  		<li>  checkCombinedPassword(String) -- Check the word with all security levels. </li>

  		<li>  checkCombinedPassword(String, int) --  Check the word with a specific security level. </li>
  
  		<li>  checkCombinedPassword(String, int, String[]) -- Check the word with a specific level and custom sensitive words.</li> 
  
  		<li>  checkCombinedPassword(String, int, List<String>) -- Check the word with a specific level and custom sensitive words. </li>

	</ul>

</li>
  
<li> About Usage:  

<p>
   
   <br> String p = "word"; <br>
   <br> try {<br>
   <br>       &nbsp;&nbsp; Password pp = new Password(); <br>
   <br>       &nbsp; &nbsp; pp.checkCombinedPassword(p);<br>
   <br> } catch (Exception e) { <br>
   <br>   //Put your code to handle the exception when you calling it. <br>
   <br> } <br>
    
</p>

</li>

</ol>


<p>
Try it on your hand!

Thanks!
</p>

</body>

</html>
