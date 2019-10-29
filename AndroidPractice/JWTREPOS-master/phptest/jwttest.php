<?php
require 'jwt_helper.php';


    $db_usr_id = 111;
    $secret_key = 'some_test_key';
    $valid_for = '3600';

        $headers = getallheaders();
        if (array_key_exists('Authorization', $headers)) {
            $jwt = $headers['Authorization'];
            $token = JWT::decode($jwt, $secret_key);
            if ($token->exp >= time()) {
                //loggedin
             echo "111" ;
            } else {
                http_response_code(401);
               echo "error";
            }
        } else {
            http_response_code(401);
         //   return false;
          echo "error";
        }
    

?>