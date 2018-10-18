package com.example.sara.jobandtutionfinder;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class trysection extends AppCompatActivity {

    private TextView tvprofile,tvpart,tvfull,tvcoa,tvhome,tvcv,tvbook,tvset,tvlog,tvsetmail;
    private ImageView imguser,imgjob,imgjob1,imgtea,imgtea1,imgcv,imgbok,imgst,imglog;
    String studentid,gender,namee,imagee,PartPostKey,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trysection);

        studentid=getIntent().getStringExtra("Studentid");
        gender=getIntent().getStringExtra("Gender");
        namee=getIntent().getStringExtra("Name");
        imagee=getIntent().getStringExtra("Image");
        PartPostKey=getIntent().getStringExtra("PartPostKey");

        tvprofile=findViewById(R.id.textViewprofile);
        tvpart=findViewById(R.id.textViewparttime);
        tvfull=findViewById(R.id.textViewfulltime);
        tvcoa=findViewById(R.id.textViewcoaching);
        tvhome=findViewById(R.id.textViewhometutior);
        tvcv=findViewById(R.id.textViewcv);
        tvbook=findViewById(R.id.textViewbooks);
        tvset=findViewById(R.id.textViewsettings);
        tvlog=findViewById(R.id.textViewlog);
        tvsetmail=findViewById(R.id.settextview);

        imguser=findViewById(R.id.proimg);
        imgjob=findViewById(R.id.imgpart);
        imgjob1=findViewById(R.id.imgfull);
        imgtea=findViewById(R.id.imgcoaching);
        imgtea1=findViewById(R.id.imgtuition);
        imgcv=findViewById(R.id.imgcv);
        imgbok=findViewById(R.id.imgbook);
        imgst=findViewById(R.id.imgset);
        imglog=findViewById(R.id.imglog);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mail = user.getEmail();

        tvsetmail.setText(mail);


        tvprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), profilefrag.class);
                startActivity(i);
            }
        });
        imguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), profilefrag.class);
                startActivity(i);
            }
        });

        tvpart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),partfrag.class);
                i.putExtra("Name",namee);
                i.putExtra("Image",imagee);
                i.putExtra("PartPostKey",PartPostKey);
                startActivity(i);

                Toast.makeText(trysection.this,PartPostKey,Toast.LENGTH_LONG).show();
            }
        });
        imgjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),partfrag.class);
                i.putExtra("Name",namee);
                i.putExtra("Image",imagee);
                i.putExtra("PartPostKey",PartPostKey);
                startActivity(i);

                Toast.makeText(trysection.this,PartPostKey,Toast.LENGTH_LONG).show();

            }
        });
        tvfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),fullfrag.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Full Time",Toast.LENGTH_LONG).show();


            }
        });
        imgjob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),fullfrag.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Full Time",Toast.LENGTH_LONG).show();
            }
        });
        tvcoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Coachx.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Coaching",Toast.LENGTH_LONG).show();
            }
        });
        imgtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Coachx.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Coaching",Toast.LENGTH_LONG).show();
            }
        });
        imgtea1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Homex.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Home Tutor",Toast.LENGTH_LONG).show();

            }
        });
        tvhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Homex.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Home Tutor",Toast.LENGTH_LONG).show();
            }
        });
        tvcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cvIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1CTV3QwRx7qJph7axzwmdwIta1AXhbzBj"));
                startActivity(cvIntent);
            }
        });
        imgcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cvIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1CTV3QwRx7qJph7axzwmdwIta1AXhbzBj"));
                startActivity(cvIntent);
            }
        });
        tvbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),selectCls.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Book",Toast.LENGTH_LONG).show();
            }
        });
        imgbok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),selectCls.class);
                startActivity(i);
                Toast.makeText(trysection.this,"Book",Toast.LENGTH_LONG).show();
            }
        });

        tvset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),settingfrag.class);
                i.putExtra("Studentid",studentid);
                i.putExtra("Gender",gender);
                startActivity(i);
                Toast.makeText(trysection.this,studentid,Toast.LENGTH_SHORT).show();
            }
        });
        imgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),settingfrag.class);
                i.putExtra("Studentid",studentid);
                i.putExtra("Gender",gender);
                startActivity(i);
                Toast.makeText(trysection.this,studentid,Toast.LENGTH_SHORT).show();
            }
        });

        tvlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(trysection.this);
                builder.setTitle("LogOut?")
                        .setMessage("Really you want to log out?")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                mail = user.getEmail();
                                FirebaseAuth.getInstance().signOut();
                                finish();
                                SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(trysection.this);
                                SharedPreferences.Editor editor = mySPrefs.edit();
                                editor.remove("currentUser");
                                editor.apply();
                                Intent i= new Intent(trysection.this,login.class);
                                startActivity(i);
                                Toast.makeText(trysection.this,mail+"Successfully logout",Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("Cancel",null).setCancelable(false);

                AlertDialog alert=builder.create();
                alert.show();

            }
        });
        imglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(trysection.this);
                builder.setTitle("LogOut?")
                        .setMessage("Really you want to log out?")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                mail = user.getEmail();
                                FirebaseAuth.getInstance().signOut();
                                finish();
                                SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(trysection.this);
                                SharedPreferences.Editor editor = mySPrefs.edit();
                                editor.remove("currentUser");
                                editor.apply();
                                Intent i= new Intent(trysection.this,login.class);
                                startActivity(i);
                                Toast.makeText(trysection.this,mail+"Successfully logout",Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("Cancel",null).setCancelable(false);

                AlertDialog alert=builder.create();
                alert.show();


            }
        });



    }
}
