package com.example.textinputapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Listener extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initViews();

        TextInputEditText textInputLayout;
        textInputLayout = (TextInputEditText) findViewById(R.id.textInputLayout);

        textInputLayout.setOnKeyListener(new TextInputLayout.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                return false;
            }
        });

    }

    void initViews() {
        TextInputEditText input1 = (TextInputEditText) findViewById(R.id.input1);
        TextInputEditText input2 = (TextInputEditText) findViewById(R.id.input2);
        Button go1 = (Button) findViewById(R.id.Go1);

        go1.setEnabled(false); //Default turning off my button


        TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                go1.setEnabled(!TextUtils.isEmpty(input1.getHint())
                        && !TextUtils.isEmpty(input2.getHint()));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }
}
