package com.example.lguprojectc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    Button buttonSignup;
    TextView textView;
    TextInputEditText user, pass , num, fname;
    String str_user, str_pass,str_fname, str_num ;
    String url ="https://lguressssssssssssssss.000webhostapp.com/Register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fname = findViewById(R.id.fullname);
        user= findViewById(R.id.usernameSignup);
        pass= findViewById(R.id.passwordSignUp);
        num = findViewById(R.id.email);
        buttonSignup = findViewById(R.id.buttonSignUp);
        textView = findViewById(R.id.loginText);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register(v);


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }
        });


    }

    public void Register(View view) {

        if (user.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();

        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();

        } else if (fname.getText().toString().equals(""))  {
            Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show();

        }else if (num.getText().toString().equals("")){
            Toast.makeText(this, "Enter Contact Number", Toast.LENGTH_SHORT).show();
        } else {

            str_user = user.getText().toString().trim();
            str_pass = pass.getText().toString().trim();
            str_fname = fname.getText().toString().trim();
            str_num = num.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    user.setText("");
                    pass.setText("");
                    fname.setText("");
                    num.setText("");
                    Toast.makeText(Register.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Register.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }


            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("Fname",str_fname);
                    params.put("User",str_user);
                    params.put("Pass",str_pass);
                    params.put("Num",str_num);
                    return params;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
            requestQueue.add(request);



        }
    }




}