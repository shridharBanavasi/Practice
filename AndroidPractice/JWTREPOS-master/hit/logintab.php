<?php



   $con=mysqli_connect("localhost","root","","test");

   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
}


// username and password sent from Form
$myusername=mysqli_real_escape_string($con,$_POST['username']); 
$mypassword=mysqli_real_escape_string($con,$_POST['userpass']); 

$sql="SELECT  * FROM user WHERE username='$myusername' and userpass='$mypassword'";
$result=mysqli_query($con,$sql);
$row=mysqli_fetch_array($result,MYSQLI_ASSOC);

$count=mysqli_num_rows($result);


// If result matched $myusername and $mypassword, table row must be 1 row
if($count==1)
{
$key = 'vishal';
$header = [
                        'typ' => 'JWT',
		   'alg' => 'HS256'
		  ];


$header = json_encode($header);

$header = base64_encode($header);

		
$payload = [      
		"country" => "india",
		"name" => "vishal",
		"email" => "vishal@gmail.com"
		  ];

$payload = json_encode($payload );
$payload= base64_encode($payload );
$signature = hash_hmac('sha256','$header.$payload', $key, true);

//base64 encode the signature
$signature = base64_encode($signature);

//concatenating the header, the payload and the signature to obtain the JWT token
$token = "$header.$payload.$signature";
echo $token;



}
else 
{
$error="Your Login Name or Password is invalid";
echo "error ";
}

?>