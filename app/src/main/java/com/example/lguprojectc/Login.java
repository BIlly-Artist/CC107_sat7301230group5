package com.example.lguprojectc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText user, pass ;
    String str_user, str_pass;
    String url ="https://websitenibill.000webhostapp.com/Login.php";
   TextView textView;
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        textView = findViewById(R.id.signUpText);
        button= findViewById(R.id.buttonLogin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(v);




            }
        });










        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void Login(View view){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait..");

        if (user.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();

        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();

        }  else {
            progressDialog.show();
            str_user = user.getText().toString().trim();
            str_pass = pass.getText().toString().trim();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    if(response.equals("Login Succesfully")){


                        Toast.makeText(Login.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, NavmainActivity.class);
                        intent.putExtra("Keyname" , str_user);
                        startActivity(intent);


                    }else{
                        Toast.makeText(Login.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }


            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("User", str_user);
                    params.put("Pass", str_pass);
                    return params;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
            requestQueue.add(request);
        }
    }
}