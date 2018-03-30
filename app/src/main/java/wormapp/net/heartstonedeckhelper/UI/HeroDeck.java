package wormapp.net.heartstonedeckhelper.UI;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import wormapp.net.heartstonedeckhelper.R;


public class HeroDeck extends ActionBarActivity {

    DrawerLayout drawerLayout;
    GridView gridView;
    ListView listView, leftDrawer, rightDrawer;
    String[] itemList;
    String[] left_Menu;
    int modificationX=100;
    int modificationY=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_deck);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutHeroDeck);
        leftDrawer = (ListView) findViewById(R.id.drawerListLeft);
        left_Menu = getResources().getStringArray(R.array.Left_Menu);
        leftDrawer.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, left_Menu));
        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (leftDrawer.getItemAtPosition(position)).toString();
                switch (s) {
                    case "Back Up":
                        startActivity(new Intent(HeroDeck.this, BackUp.class));
                        drawerLayout.closeDrawers();
                        break;
                    case "Home Screen":
                        startActivity(new Intent(HeroDeck.this, Deck_Types.class));
                        drawerLayout.closeDrawers();
                        break;
                }
            }
        });



        itemList = getResources().getStringArray(R.array.HeroDeckItems);
        left_Menu = getResources().getStringArray(R.array.Left_Menu);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v=gridView.getChildAt(position);
                v.setOnTouchListener(mTouchListener);
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList));


    }

    View.OnTouchListener mTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            PointF DownPT = new PointF();
            PointF StartPT = new PointF();
            int eg = event.getAction();
            switch (eg)
            {
                case MotionEvent.ACTION_MOVE:
                    StartPT = new PointF(v.getX(), v.getY());
                    PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);

                    v.setX((StartPT.x+mv.x)-(modificationX));
                    v.setY((StartPT.y+mv.y)-(modificationY));
                    break;
                case MotionEvent.ACTION_DOWN:
                    DownPT.x = event.getX();
                    DownPT.y = event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    break;
            }
            return true;
        }
    };
}
