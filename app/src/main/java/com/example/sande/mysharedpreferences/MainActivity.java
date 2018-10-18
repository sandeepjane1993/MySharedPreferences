package com.example.sande.mysharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText = findViewById(R.id.editText);
         button = findViewById(R.id.button);
        sp = getSharedPreferences("MyFile",MODE_PRIVATE);

        // checking if app is running first time
        if(sp.getBoolean("my_first_time", true))
        {
            Toast.makeText(this,"App is running first time ",Toast.LENGTH_LONG).show();
            // record the fact that the app has been started at least once
            sp.edit().putBoolean("my_first_time", false).commit();
        }
        else
        {
            Toast.makeText(this, "App has already run before", Toast.LENGTH_LONG).show();
        }

        editText.setText(sp.getString("myKey",""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("myKey",user);
                editor.commit();
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
