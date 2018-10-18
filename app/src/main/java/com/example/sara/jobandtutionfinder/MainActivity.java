package com.example.sara.jobandtutionfinder;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String studentid,gender,namee,imagee,PartPostKey,mail;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studentid=getIntent().getStringExtra("Studentid");
        gender=getIntent().getStringExtra("Gender");
        namee=getIntent().getStringExtra("Name");
        imagee=getIntent().getStringExtra("Image");
        PartPostKey=getIntent().getStringExtra("PartPostKey");

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      /*  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent i = new Intent(getApplicationContext(), profilefrag.class);
            startActivity(i);
            Toast.makeText(this,"Welcome to your profile",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_part) {
           Intent i=new Intent(getApplicationContext(),partfrag.class);
            i.putExtra("Name",namee);
            i.putExtra("Image",imagee);
            i.putExtra("PartPostKey",PartPostKey);
            startActivity(i);

            Toast.makeText(this,"Part time",Toast.LENGTH_LONG).show();


        } else if (id == R.id.nav_full) {
            Intent i=new Intent(getApplicationContext(),fullfrag.class);
            startActivity(i);
            Toast.makeText(this,"Full Time",Toast.LENGTH_LONG).show();



        } else if (id == R.id.nav_coaching) {
            Intent i=new Intent(getApplicationContext(),Coachx.class);
            startActivity(i);
            Toast.makeText(this,"Coaching",Toast.LENGTH_LONG).show();



        } else if (id == R.id.nav_home) {
            Intent i=new Intent(getApplicationContext(),Homex.class);
            startActivity(i);
            Toast.makeText(this,"Home Tutor",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_cv) {
            //Intent i=new Intent(getApplicationContext(),showCv.class);
            //startActivity(i);
            Intent cvIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1CTV3QwRx7qJph7axzwmdwIta1AXhbzBj"));
            startActivity(cvIntent);
          //  Toast.makeText(this,"CV",Toast.LENGTH_LONG).show();

        }
        else if (id == R.id.nav_book) {
                Intent i=new Intent(getApplicationContext(),selectCls.class);
                startActivity(i);
                Toast.makeText(this,"Book",Toast.LENGTH_LONG).show();

        }
        else if(id==R.id.nav_settings){
            Intent i=new Intent(getApplicationContext(),settingfrag.class);
            i.putExtra("Studentid",studentid);
            i.putExtra("Gender",gender);
            startActivity(i);
            Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();

        }
        else if(id==R.id.nav_logout){

            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("LogOut?")
                    .setMessage("Really you want to log out?")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mail = user.getEmail();
                            FirebaseAuth.getInstance().signOut();
                            finish();
                            SharedPreferences mySPrefs =PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor editor = mySPrefs.edit();
                            editor.remove("currentUser");
                            editor.apply();
                            Intent i= new Intent(MainActivity.this,login.class);
                            startActivity(i);
                            Toast.makeText(MainActivity.this,mail+"Successfully logout",Toast.LENGTH_SHORT).show();

                        }
                    }).setNegativeButton("Cancel",null).setCancelable(false);

            AlertDialog alert=builder.create();
            alert.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}



