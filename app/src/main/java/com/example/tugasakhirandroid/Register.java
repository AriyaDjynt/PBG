package com.example.tugasakhirandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register extends AppCompatActivity {
    ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    EditText password, username;
    final private static String url = "http://hendrysa.ga:443/project/uasandroid/register.php";
    String Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        ImageView register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isEmailValid(email.getText().toString())) {
//                    Toast.makeText(Register.this, "Emailnya ga valid", Toast.LENGTH_LONG).show();
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Usename dan Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }

                else {
                    Username = username.getText().toString();
                    Password = password.getText().toString();
                    daftarAku proses = new daftarAku();
                    proses.execute();
                }
                Intent iRegister = new Intent(getApplicationContext(), Login.class);
                startActivity(iRegister);
                finish();

            }


        });
    }

    public class daftarAku extends AsyncTask<String, String, String>
    {
        String success;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Proses mendaftar...");
            pDialog.setIndeterminate(false);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            String strnama = Username;
            String strpassword = Password;
            List<NameValuePair> nvp = new ArrayList<>();
            nvp.add(new BasicNameValuePair("username", strnama));
            nvp.add(new BasicNameValuePair("password", strpassword));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", nvp);
            try {
                success = json.getString("success");
            } catch (Exception e) {
                //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
            return null;
        }


        protected void onPostExecute(String file_url) {
// dismiss the dialog once done
            pDialog.dismiss();
            if (success.equals("1")) {
                Toast.makeText(getApplicationContext(), "Regitrasi sukses", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Registrasi gagal", Toast.LENGTH_LONG).show();
            }
        }
    }

//    public static boolean isEmailValid(String email) {
//        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
}
