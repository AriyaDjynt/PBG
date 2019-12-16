import requests

login = "http://35.187.246.188/project/uasandroid/login.php"
register = "http://35.187.246.188/project/uasandroid/register.php"

data = {'username' : 'admin2', 'password' : 'admin'}

re = requests.post(register, data=data).json()

print(re)