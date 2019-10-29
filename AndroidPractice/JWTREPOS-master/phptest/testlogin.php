<?php
require 'jwt_helper.php';

    $db_usr = "vishal";
    $db_usr_pw = "vishal";
    $db_usr_id = 111;
    $secret_key = 'some_test_key';
    $valid_for = '3600';
    if ($_POST['username'] && $_POST['userpass']) {
        $usr = $_POST['username'];
        $pw = $_POST['userpass'];
        if ($usr == $db_usr && $pw == $db_usr_pw) {
            $token = array();
            $token['id'] = $db_usr_id;
            $token['exp'] = time() + $valid_for;
            echo json_encode(array('token' => JWT::encode($token, $secret_key)));
            //return "login";
        } else {
            http_response_code(401);
            echo "login error";
        }
    } else {
        $headers = getallheaders();

        if (array_key_exists('Authorization', $headers))
		 {
            $jwt = $headers['Authorization'];
            $token = JWT::decode($jwt, $secret_key);
            if ($token->exp >= time()) {
                //loggedin
			echo "id is".$db_usr_id;
               // return "done";
            } else 
			{
                http_response_code(401);
                echo "error";
               
            }
        } else {
            http_response_code(401);
			echo "error ";
           // return "error";
        }
    }

?>