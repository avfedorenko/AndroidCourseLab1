package com.example.androidcourselab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String GREETING = "greeting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send = findViewById(R.id.buttonSend);
        send.setOnClickListener(v -> {
            Intent intent = new Intent(this, SetNameActivity.class);
            EditText inputGreeting = findViewById(R.id.inputGreeting);
            String greeting = inputGreeting.getText().toString();
            intent.putExtra(GREETING, greeting);
            startActivityForResult(intent, 1);
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String message = data.getStringExtra(SetNameActivity.MESSAGE);
            TextView textMessage = findViewById(R.id.textMessage);
            textMessage.setText(message);

            CheckBox checkboxRemindGreeting = findViewById(R.id.checkboxRemindGreeting);
            if (!checkboxRemindGreeting.isChecked()){
                EditText inputGreeting = findViewById(R.id.inputGreeting);
                inputGreeting.setText("");
            }
        }
    }
}