package com.example.exercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_entrar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username=findViewById(R.id.et_login_username);
        et_password=findViewById(R.id.et_login_password);
        bt_entrar = findViewById(R.id.bt_login_entrar);

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = getIntent();
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                if(username.equals(i.getExtras().getString("username"))
                        && password.equals(i.getExtras().getString("password"))){
                    i = new Intent(LoginActivity.this, SobreActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(LoginActivity.this, "Login incorreto", Toast.LENGTH_SHORT).show();
                    et_username.setText("");
                    et_password.setText("");
                    
                }

            }
        });
    }
}