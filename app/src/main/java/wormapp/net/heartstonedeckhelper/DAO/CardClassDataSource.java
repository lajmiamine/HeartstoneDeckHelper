package wormapp.net.heartstonedeckhelper.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import wormapp.net.heartstonedeckhelper.DB_Helper.CardClassHelper;
import wormapp.net.heartstonedeckhelper.Model.CardClass;

/**
 * Created by hamdi on 12/07/15.
 */
public class CardClassDataSource {

    private SQLiteDatabase database;
    private CardClassHelper dbHelper;
    private String[] allColumns = { CardClassHelper.COLUMN_ID,
            CardClassHelper.COLUMN_LABEL };

    public CardClassDataSource(Context context) {
        dbHelper = new CardClassHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public CardClass creatCardClass(String cardClass) {
        ContentValues values = new ContentValues();
        values.put(CardClassHelper.COLUMN_LABEL, cardClass);
        long insertId = database.insert(CardClassHelper.COLUMN_LABEL, null,
                values);
        Cursor cursor = database.query(CardClassHelper.TABLE_CARDCLASS,
                allColumns, CardClassHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        CardClass newComment = cursorToCardClass(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteCardClass(CardClass cardClass) {
        long id = cardClass.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(CardClassHelper.TABLE_CARDCLASS, CardClassHelper.COLUMN_ID
                + " = " + id, null);
    }

    public ArrayList<CardClass> getAllCardClass() {
        ArrayList<CardClass> cards = new ArrayList<CardClass>();

        Cursor cursor = database.query(CardClassHelper.TABLE_CARDCLASS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CardClass comment = cursorToCardClass(cursor);
            cards.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return cards;
    }

    private CardClass cursorToCardClass(Cursor cursor) {
        CardClass comment = new CardClass();
        comment.setId(cursor.getInt(0));
        comment.setLib(cursor.getString(1));
        return comment;
    }
}



