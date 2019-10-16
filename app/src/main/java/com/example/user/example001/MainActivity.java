package com.example.user.example001;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout edt_uname, edt_enrl, edt_email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_uname=findViewById(R.id.uname_id);
        edt_enrl=findViewById(R.id.enrl_id);
        edt_email=findViewById(R.id.email_id);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean validateUsername() {
        String usernameInput = edt_uname.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            edt_uname.setError("Field can't be empty");
           // edt_uname.setErrorTextColor(ColorStateList.valueOf(getColor(R.color.blue)));

            return false;
        }else {
            edt_uname.setError(null);
            return true;
        }
    }

    private boolean validateEnrollment() {
        String usernameInput = edt_enrl.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            edt_enrl.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 12) {
            edt_enrl.setError("enter valid Enrollmetn no.");
            return false;
        } else if (usernameInput.length() < 12) {
            edt_enrl.setError("enter valid Enrollmetn no.");
            return false;
        }
        else {
            edt_enrl.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {

        String emailid = edt_email.getEditText().getText().toString().trim();

        if (emailid.isEmpty()) {
            edt_email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            edt_email.setError("Please enter valid email-id");
            return false;
        } else {
            edt_email.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!validateEmail() | !validateUsername() | !validateEnrollment()) {
                return;
            }
        }


       String input = "Username: " + edt_uname.getEditText().getText().toString();
        input += "\n";
        input += "Enrollment: " + edt_enrl.getEditText().getText().toString();
        input += "\n";
        input += "Email: " + edt_email.getEditText().getText().toString();

        /*input += "Password: " +edt4.getEditText().getText().toString();
        input += "\n";
        input += "Confirm Password: " +edt5.getEditText().getText().toString();
        input += "\n";*/

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
        finish();
    }

}
