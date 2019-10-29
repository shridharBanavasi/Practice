<?php

//setting the personal key identification
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

?> 