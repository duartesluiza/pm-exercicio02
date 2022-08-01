package com.example.exercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_registrar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_username = findViewById(R.id.et_registro_username);
        et_password = findViewById(R.id.et_registro_password);
        bt_registrar =findViewById(R.id.bt_registro_registrar);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(RegistroActivity.this, "Preencha ambos os campos para registrar", Toast.LENGTH_SHORT).show();
                    
                }else{
                    i=getIntent();
                    i.putExtra("username",username);
                    i.putExtra("password",password);
                    setResult(1, i);
                    finish();

                }


            }
        });
    }
}