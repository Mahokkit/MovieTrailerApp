package mahokkit.movietrailerapp;

import android.content.*;
import android.database.sqlite.*;

/**
 * Created by Edward on 12/07/17.
 */

public class DBHelper extends SQLiteOpenHelper
{
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "movieTrailers";

    private static final String CREATE_TABLE = "" +
            "CREATE TABLE " + model.DatabaseEntry.TABLE_NAME + "(" +
            model.DatabaseEntry.COL_ID + " INTEGER PRIMARY KEY," +
            model.DatabaseEntry.COL_TITLE + " TEXT," +
            model.DatabaseEntry.COL_GENRE + " TEXT," +
            model.DatabaseEntry.COL_URL+ " TEXT," +
            model.DatabaseEntry.COL_RATING + " TEXT)";

    private static final String DELETE_TABLE =
            "DROP TABLE IF EXISTS " + model.DatabaseEntry.TABLE_NAME;

    DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}
