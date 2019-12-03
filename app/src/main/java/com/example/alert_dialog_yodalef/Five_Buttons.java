package com.example.alert_dialog_yodalef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class Five_Buttons extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout ll;
    Random rnd;

    /**
     * @author Dvir Dadon
     * @since 3/12/2019
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll =(LinearLayout) findViewById(R.id.ll);
        rnd = new Random();
    }

    /**
     * @since 3/12/2019
     * The Method is showing alert dialog with message
     */
    public void Message(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message Only");
        adb.setMessage("Hello");
        AlertDialog message = adb.create();
        message.show();
    }

    /**
     *
     * @since 3/12/2019
     * The Method is showing alert dialog with message and icon
     */
    public void Message_Icon(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.hello);
        adb.setTitle("Message and Icon");
        adb.setMessage("Hello");
        AlertDialog Icon = adb.create();
        Icon.show();
    }

    /**
     * @since 3/12/2019
     * The method showing alert dialog with a button that cancel it
     */
    public void Message_And_Button(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.hello);
        adb.setTitle("Message with Button");
        adb.setMessage("Hello");
        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog Icon = adb.create();
        Icon.setCancelable(false);
        Icon.show();
    }

    /**
     * @since 3/12/2019
     * The method is showing alert dialog that let the user pick a random color
     */
    public void Background_Two_Buttons(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Random color");
        adb.setMessage("Change the background to a random color");
        adb.setPositiveButton("Color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));

            }
        });
        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog Colors = adb.create();
        Colors.setCancelable(false);
        Colors.show();
    }

    /**
     * @since 3/12/2019
     * The method let the user pick a deafult color or a random color or close the alert dialog
     */
    public void Background_Three_Buttons(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Random Color Or white");
        adb.setMessage("You can choose a random color or for the default color");
        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setNeutralButton("Deafult Color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setPositiveButton("Random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
            }
        });
        AlertDialog Everything = adb.create();
        Everything.setCancelable(false);
        Everything.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * @since 3/12/2019
     * @return This method moving the user for the credits activity
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent si = new Intent(this,Credits.class);
        startActivity(si);
        return true;
    }
}
