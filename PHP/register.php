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

$query = mysqli_query($mysqli, "SELECT * FROM Users WHERE Username='$username'");
$result = mysqli_fetch_array($query);

if(empty($result))
{
    $query = mysqli_query($mysqli, "INSERT INTO Users(Username, Password) VALUES('$username', '$password')");
    $response->success = 1;
    $response->message = "Registrasi berhasil!";
    die(json_encode($response));
}
else
{
    $response->success = 0;
    $response->message = "Username sudah terpakai!";
    die(json_encode($response));
}

?>