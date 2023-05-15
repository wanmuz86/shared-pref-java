package com.example.volleyapplicatiom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText =  findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText  = findViewById(R.id.phoneEditText);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String name = sharedPref.getString("name", "");
        String email = sharedPref.getString("email", "");
        String phone = sharedPref.getString("phone", "");

        nameEditText.setText(name);
        emailEditText.setText(email);
        phoneEditText.setText(phone);

    }

    public void saveData(View view) {

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", nameEditText.getText().toString());
        editor.putString("email", emailEditText.getText().toString());
        editor.putString("phone", phoneEditText.getText().toString());
        editor.apply();

        Toast.makeText(MainActivity.this, "Data saved succesfully", Toast.LENGTH_LONG).show();

    }

    public void removeData(View view) {

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.clear();
        nameEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
        editor.apply();
        Toast.makeText(MainActivity.this,"Data cleared succesfully", Toast.LENGTH_LONG).show();

    }
}