package com.ambulance.proj.myambulance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.support.v4.widget.CircularProgressDrawable;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class LoginOtp  extends Activity {

    Button buttonSend,bverify;
    EditText textPhoneNo;
    EditText textSMS;
    String verifyNo;
    FirebaseAuth firebaseAuth;
   public static String mobile;
   private ProgressDialog progressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        textSMS = (EditText) findViewById(R.id.editTextSMS);
        bverify=(Button) findViewById(R.id.buttonVerify);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                 String phoneNo = textPhoneNo.getText().toString();
                 if(phoneNo.isEmpty())
                 {
                     textPhoneNo.setError("Enter valid phone number");
                     return;
                 }
                 if(phoneNo.length()!=10)
                 {
                     textPhoneNo.setError("Pnone number is invalid");
                     return;
                 }

                 phoneNo = textPhoneNo.getText().toString();
                mobile=phoneNo;
                Random r=new Random();
                int randomNumber=r.nextInt(10000)+99999;
                verifyNo=String.valueOf(randomNumber);
                String message = verifyNo+" "+"is your OTP "+"\n"+"Do not share your OTP with anyone - MedBus";


                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(LoginOtp.this, "OTP Sent", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(LoginOtp.this, "Failed to Send OTP", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }

        });

        bverify.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String otpVrify = textSMS.getText().toString();
                Intent i=new Intent(LoginOtp.this,MapsActivity.class);
                    startActivity(i);
//                if(otpVrify.isEmpty())
//                {
//                    textSMS.setError("Enter OTP");
//                    return;
////                }
//                if (otpVrify.equals(verifyNo)) {
//                    //  Toast.makeText(OtpActivity.this, "OTP verify", Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(LoginOtp.this,MapsActivity.class);
//                    startActivity(i);
//
//                } else
//                {
//                    Toast.makeText(LoginOtp.this, "Invalid OTP ", Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }
}
