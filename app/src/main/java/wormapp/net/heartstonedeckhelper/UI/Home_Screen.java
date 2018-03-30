package wormapp.net.heartstonedeckhelper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import wormapp.net.heartstonedeckhelper.R;


public class Home_Screen extends ActionBarActivity {

    Button buildDeck;
    ListView listView;
    String[] itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);

        buildDeck = (Button) findViewById(R.id.btnBuildDeck);
        buildDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, Deck_Types.class));
            }
        });

        itemList = getResources().getStringArray(R.array.HeroDeckItems);
        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home__screen, menu);
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
