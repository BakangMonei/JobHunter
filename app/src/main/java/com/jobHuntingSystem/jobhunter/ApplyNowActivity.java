package com.jobHuntingSystem.jobhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ApplyNowActivity extends AppCompatActivity {

    // Firebase
    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_now);

        // FireBase
        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        // TextView
        TextView ApplyHereTextView = (TextView) findViewById(R.id.ApplyHereTextView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView jobView = (TextView) findViewById(R.id.jobView);
        TextView qualificationView = (TextView) findViewById(R.id.qualificationView);

        // EditText
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerJob = (EditText) findViewById(R.id.registerJob);
        EditText registerQualification = (EditText) findViewById(R.id.registerQualification);

        // Button
        Button registerJobButton = (Button) findViewById(R.id.registerJobButton);


        registerJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String job = registerJob.getText().toString();
                String qualification = registerQualification.getText().toString();
                if(TextUtils.isEmpty(email) || (TextUtils.isEmpty(job)) || (TextUtils.isEmpty(qualification))){
                    Toast.makeText(ApplyNowActivity.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    registerJob(email, job, qualification);
                }
            }
        });
    }

    public void registerJob(String registerEmail, String registerJob,
                             String registerQualification){


        mAuth.createUserWithEmailAndPassword(registerEmail,registerJob).addOnSuccessListener(new OnSuccessListener<AuthResult>(){
            public void onSuccess(AuthResult authResult){
                HashMap<String,Object> map = new HashMap<>();
                map.put("email", registerEmail);
                map.put("job", registerJob);
                map.put("lastName", registerQualification);



                mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>(){
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(ApplyNowActivity.this,"Successfully Applied", Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(ApplyNowActivity.this, SuccessfulLogin.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ApplyNowActivity.this,e.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}