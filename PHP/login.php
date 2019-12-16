<?php

include_once 'connector.php';

$username = $_POST["username"];
$password = $_POST["password"];


if((empty($username)) || (empty($password)))
{

    $response->success = 0;
    $response->message = "Username atau Password tidak boleh kosong";
    die(json_encode($response));
}

$query = mysqli_query($mysqli, "SELECT * FROM Users WHERE Username='$username' AND Password='$password'");
$result = mysqli_fetch_array($query);

if(!empty($result))
{
    $response->success = 1;
    $response->message = "Selamat datang ".$username;
    die(json_encode($response));
}
else
{
    $response->success = 0;
    $response->message = "Username atau Password salah";
    die(json_encode($response));
}

mysqli_close($sql)
?>