package wormapp.net.heartstonedeckhelper.UI;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import wormapp.net.heartstonedeckhelper.Adapter.CardClassAdapter;
import wormapp.net.heartstonedeckhelper.DAO.CardClassDataSource;
import wormapp.net.heartstonedeckhelper.Model.CardClass;
import wormapp.net.heartstonedeckhelper.R;


public class Deck_Types extends ActionBarActivity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView leftDrawer;
    String[] left_Menu;
    RecyclerView recyclerView;
    CardClassDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screenv2);



        dataSource = new CardClassDataSource(Deck_Types.this);
        dataSource.open();

        new LoadingClasses().execute();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        leftDrawer = (ListView) findViewById(R.id.drawerListLeft);
        left_Menu = getResources().getStringArray(R.array.Left_Menu);
        leftDrawer.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, left_Menu));
        leftDrawer.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = (leftDrawer.getItemAtPosition(position)).toString();
        switch (s) {
            case "Back Up":
                startActivity(new Intent(Deck_Types.this, BackUp.class));
                drawerLayout.closeDrawers();
                break;
            case "Home Screen":
                drawerLayout.closeDrawers();
                break;
        }
    }

    class LoadingClasses extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... params) {

            recyclerView = (RecyclerView) findViewById(R.id.recycler);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            ArrayList<CardClass> cardClasses = dataSource.getAllCardClass();
            CardClassAdapter cardClassAdapter = new CardClassAdapter(cardClasses);
            recyclerView.setAdapter(cardClassAdapter);

            return 1;
        }
    }
}
