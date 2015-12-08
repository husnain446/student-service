package com.byteshaft.studentservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EmailActivity extends Activity implements View.OnClickListener {

    private EditText emailAddress;
    private Button continueButton;
    private String email;
    private String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_conformation);

        emailAddress = (EditText) findViewById(R.id.et_email);
        continueButton = (Button) findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        email = emailAddress.getText().toString().trim();
        emailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (email.matches(emailPattern) && s.length() > 0) {
                    Toast.makeText(AppGlobals.getContext(), "valid Email", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                Intent intent = new Intent(AppGlobals.getContext(), ForgetPasswordActivity.class);
                startActivity(intent);
                Toast.makeText(AppGlobals.getContext(), "Email has been sent", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
