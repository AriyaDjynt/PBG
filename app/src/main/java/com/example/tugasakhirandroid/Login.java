package com.example.tugasakhirandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    TextView mRegister;
    ImageView mLogin;
    ProgressDialog dialog;
    EditText username, password;
    public static String url = "http://hendrysa.ga:443/project/uasandroid/login.php";
    public static final String TAG_SUCCESS = "success";
    private String Username, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernamelogin);
        password = findViewById(R.id.passwordlogin);
        mRegister = findViewById(R.id.registerinlogin);
        mLogin = findViewById(R.id.login);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iRegister = new Intent(getApplicationContext(), Register.class);
                startActivity(iRegister);
                finish();

            }
        });


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"TIDAK BOLEH KOSONG", Toast.LENGTH_LONG).show();
                }else{
                    Username = username.getText().toString();
                    Password = password.getText().toString();
                    new ValidateLogin().execute();
                }
            }
        });
    }


    class ValidateLogin extends AsyncTask<String ,String ,String > {
        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Login.this);
            dialog.setMessage("pleasse wait....");
            dialog.setIndeterminate(false);
            dialog.setCancelable(true);
            dialog.show();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("username", Username));
            params.add(new BasicNameValuePair("password", Password));

            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
            Log.d("Create Respone ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
                        }
                    });
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Username atau Password Salah", Toast.LENGTH_LONG).show();
                        }
                    });

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String file_url) {
            dialog.dismiss();
        }
    }
}