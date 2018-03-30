package wormapp.net.heartstonedeckhelper.DB_Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import wormapp.net.heartstonedeckhelper.Model.CardClass;

/**
 * Created by hamdi on 12/07/15.
 */
public class CardClassHelper extends SQLiteOpenHelper {

    public static final String TABLE_CARDCLASS = "card_class";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LABEL = "label";

    private static final String DATABASE_NAME = "hearthStone.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CARDCLASS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_LABEL
            + " text not null);";
    ArrayList<CardClass> cardClasses = new ArrayList<>();

    public CardClassHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    void inti(){
        CardClass cardClass = new CardClass();
        cardClass.setLib("Paladin");
        cardClasses.add(cardClass);
        cardClass.setLib("Mage");
        cardClasses.add(cardClass);
        cardClass.setLib("Priest");
        cardClasses.add(cardClass);
        cardClass.setLib("Warlock");
        cardClasses.add(cardClass);
        cardClass.setLib("Rogue");
        cardClasses.add(cardClass);
        cardClass.setLib("Druid");
        cardClasses.add(cardClass);
        cardClass.setLib("Shaman");
        cardClasses.add(cardClass);
        cardClass.setLib("Hunter");
        cardClasses.add(cardClass);
        cardClass.setLib("Warrior");
        cardClasses.add(cardClass);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        inti();

        db.execSQL(DATABASE_CREATE);
        //db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (int i= 0 ; i< cardClasses.size(); i++){
            values.put(COLUMN_LABEL,cardClasses.get(i).getLib()); // Contact Phone Number

            // Inserting Row
            db.insert(TABLE_CARDCLASS, null, values);
        }


        //db.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(CardClassHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDCLASS);
        onCreate(db);
    }
}
