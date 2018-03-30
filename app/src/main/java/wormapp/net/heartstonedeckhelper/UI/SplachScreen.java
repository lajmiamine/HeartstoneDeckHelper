package wormapp.net.heartstonedeckhelper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import wormapp.net.heartstonedeckhelper.R;


public class SplachScreen extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

        //Activity recognize our new Action Bar as its ActionBar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toolbar);

        Runnable mRunnable;
        Handler mHandler=new Handler();
        mRunnable=new Runnable() {
            @Override
            public void run() {

                /* code to recognize if already signed in or not --
                boolean test = helper.searchPass();
                Log.d("Test", String.valueOf(test));
                if(test==false){
                    startActivity(new Intent(Home_page.this,log_sign.class));
                }
                else {
                    startActivity(new Intent(Home_page.this,list_projects.class));
                }*/

                startActivity(new Intent(SplachScreen.this,LogIn_SignUp.class));
            }
        };
        mHandler.postDelayed(mRunnable,1000);
    }

}
