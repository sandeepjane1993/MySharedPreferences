package com.example.sande.mysharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText et1,et2;
    Button loginButton;
    CheckBox cb1;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = findViewById(R.id.editText_username);
        et2 = findViewById(R.id.editText_password);
        loginButton = findViewById(R.id.btn_login);
        cb1=findViewById(R.id.cb1);
        sp = getSharedPreferences("MyFile",MODE_PRIVATE);
        et1.setText(sp.getString("key1",""));
        et2.setText(sp.getString("key2",""));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked())
                {
                    String user = et1.getText().toString();
                    String pass = et2.getText().toString();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("key1",user);
                    editor.putString("key2",pass);
                    editor.commit();
                }
                else
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("key1","");
                    editor.putString("key2","");
                    editor.commit();
                }
            }
        });

    }
}
