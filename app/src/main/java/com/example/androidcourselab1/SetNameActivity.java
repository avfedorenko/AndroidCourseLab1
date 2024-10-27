package com.example.androidcourselab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SetNameActivity extends AppCompatActivity {
    public static final String MESSAGE = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);

        Intent data = getIntent();
        String greeting = data.getStringExtra(MainActivity.GREETING);
        TextView textGreeting = findViewById(R.id.textGreeting);
        textGreeting.setText(greeting);

        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(v -> {
            EditText inputPerson = findViewById(R.id.inputPerson);
            String person = inputPerson.getText().toString();
            String message = greeting + ", " + person;
            Intent result = new Intent();
            result.putExtra(MESSAGE, message);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}