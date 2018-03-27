package com.example.eddie.cookingapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private EditText username;
    private Button mStartButton;
    //private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get this context
        //mContext = this;

        // find the edit text view from the layout
        // save it to the variable username
        //username = findViewById(R.id.username);
        //resultTextView = findViewById(R.id.resultTextView);

        // button?
        mStartButton = findViewById(R.id.startButton);

        // how do I start second activity when the login button is clicked
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });
    }
}

                //launchActivity();

            //}
       // });

    //}

    //private void launchActivity() {
        // package intent
        // start activity

        // build a notification for this launch
        // before 23, you only need to pass the context as parameter
        // now, you need to pass context, channel id - > "default"
        //NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
               //"default");
        // set icons
        //builder.setSmallIcon(android.R.drawable.btn_star);

        // if you want to use anything from this context, you can add it to the intent
        // then get the data from intent

        // username, you have logged in!


        // 1. intent with from and to
        //Intent intent = new Intent(mContext, SearchActivity.class);
        // 2. add data to the intent
        //intent.putExtra("username", username.getText().toString());
        // 3. start activity with the intent
        //startActivity(intent);


        // create a pending intent for the notification with the intent I created
       // PendingIntent pendingIntent =
              //  PendingIntent.getActivity(this, 0, intent, 0);
       // builder.setContentIntent(pendingIntent);

        // set the title and content of the notification
      //  builder.setContentTitle("Welcome! Lets start cooking!");
        //builder.setContentText("Hi " + intent.getExtras().getString("username"));

        // get the system service to display this notification
       // NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // notify and build the nodification
       // notificationManager.notify(1, builder.build());

        //startActivityForResult(intent, 1);

    //}

//}

    //@Override
    //public void onActivityResult(int requestCode, int resultCode, Intent data){

        //super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == 1) {
            //if (resultCode == RESULT_OK) { // SECOND ACTIVITY IS SENDING DATA
                //boolean yesBox = data.getBooleanExtra("yes", false);
                //boolean noBox = data.getBooleanExtra("no", false);

                // check to see which box has been selected
                // then display different strings in the text view

                //if (yesBox && !noBox){
                    //resultTextView.setText("You love dogs!");
                //}

                //else if (!yesBox && noBox){
                    //resultTextView.setText("No dog please.");
                //}

                //else if(yesBox && noBox){
                    //resultTextView.setText("HUH?");
                //}

                //else{
                    //resultTextView.setText("You have to select at least one.");
                //}



