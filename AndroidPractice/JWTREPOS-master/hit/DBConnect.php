<?php
   $con=mysqli_connect("localhost","root","","test");

   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
    $username = $_GET['username'];
   $password = $_GET['userpass'];
   $result = mysqli_query($con,"SELECT * FROM user where username='$username' 
      and userpass='$password'");
   $array = mysqli_fetch_array($result,MYSQLI_ASSOC);


if(isset($array[0])){
    echo $array[0];
}
else {
  //some error?
echo "issue ";
}

   
 mysqli_close($con);



?>