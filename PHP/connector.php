<?php

$databaseHost = '127.0.0.1';
$databaseName = 'Android';
$databaseUsername = 'android';
$databasePassword = 'android2019';

$sql = mysqli_connect($databaseHost, $databaseUsername, $databasePassword, $databaseName); 

if (!$sql)
{
    die("Koneksi gagal: " . mysqli_connect_error());
}

?>
