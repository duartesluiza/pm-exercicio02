package com.example.exercicio02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button bt_registro, bt_login, bt_sobre;
    String username="", password="";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==1 && data!=null){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            Toast.makeText(this, "Dados de Login atualizados", Toast.LENGTH_SHORT).show();
                    
            
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_registro = findViewById(R.id.bt_registro);
        bt_login = findViewById(R.id.bt_login);
        bt_sobre = findViewById(R.id.bt_sobre);

        bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, RegistroActivity.class);
                startActivityForResult(i,1);

            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se eles(usernname e password) estiverem vazios:
                if(username.equals("") || password.equals("")){
                    Toast.makeText(MenuActivity.this, "Registre utilizador antes de se autenticar", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MenuActivity.this, LoginActivity.class);
                    i.putExtra("username", username);
                    i.putExtra("password", password);
                    startActivity(i);
                }
            }
        });

        bt_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, SobreActivity.class);
                startActivity(i);

            }
        });
    }


}