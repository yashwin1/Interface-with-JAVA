package com.example.interfacewithjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//      LAYOUT
        RelativeLayout yashwinLayout = new RelativeLayout(this);  /* To add a layout */
        yashwinLayout.setBackgroundColor(Color.GREEN);

//      BUTTON
        Button redButton = new Button(this);   /* To create a button */
        redButton.setText("Click me Buddy");
        redButton.setBackgroundColor(Color.RED);

//      USERNAME input
        EditText username = new EditText(this);

//      We set Ids so that it is easy to track them later and also provide positioning
        redButton.setId(1);
        username.setId(2);


//      CONTAINER to hold our button for positioning
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,    /* This is for the height */
                RelativeLayout.LayoutParams.WRAP_CONTENT     /* This is for the width */
        );
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,    /* This is for the height */
                RelativeLayout.LayoutParams.WRAP_CONTENT     /* This is for the width */
        );


//      Give rules to position widgets
        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());   /* This places the username field above the button using its Id */
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);   /* To give a gap of 50 units between bottom of text and top of button */

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        Resources r = getResources();       /* Gets bunch of information about our app */
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());     /* This typecasting because pixels can take only integer values */

        username.setWidth(px);


//      Add widget to layout
        yashwinLayout.addView(redButton, buttonDetails);    /* Here we are adding our button as well as its positioning */
        yashwinLayout.addView(username, usernameDetails);

//      Set this activity's content /display to this view
        setContentView(yashwinLayout);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
