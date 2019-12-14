package com.hendrysa.myapplication;

import java.util.HashMap;
import org.json.JSONArray;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyAccount extends Activity{
    Button logout;
    SessionManager session;
    TextView status;
    JSONArray contacts = null;
    String email, nama, id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        session = new SessionManager(getApplicationContext());
        Toast.makeText(getApplicationContext(),"User Login Status: " + session.isLoggedIn(),Toast.LENGTH_LONG).show();
        session.checkLogin();
        HashMap < String, String > user = session.getUserDetails();
        nama = user.get(SessionManager.KEY_NAME);
        TextView status = (TextView) findViewById(R.id.status);
        status.setText(Html.fromHtml("hallo bro,<b>" + nama + "</b> "));
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                session.logoutUser();
                finish();
            }
        });
    }
}