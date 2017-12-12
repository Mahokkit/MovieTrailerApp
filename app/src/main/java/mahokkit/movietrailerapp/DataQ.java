package mahokkit.movietrailerapp;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.*;


/**
 * Created by Edward on 12/07/17.
 */

public class DataQ {
    private DBHelper dbHelper;

    // Constructor to get context
    public DataQ(Context context)
    {
        this.dbHelper = new DBHelper(context);
    }

    public void insertData
            (
            int id,
            String title,
            String genre,
            String url,
            String rating)
    {
        SQLiteDatabase dbWrite = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(model.DatabaseEntry.COL_ID, id);
        values.put(model.DatabaseEntry.COL_TITLE, title);
        values.put(model.DatabaseEntry.COL_GENRE, genre);
        values.put(model.DatabaseEntry.COL_URL, url);
        values.put(model.DatabaseEntry.COL_RATING, rating);

        // Insert the new row, returning the primary key value of the new row
        dbWrite.insert(model.DatabaseEntry.TABLE_NAME, null, values);
    }

    public List<String> queryData()
    {
        SQLiteDatabase dbRead = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                model.DatabaseEntry.COL_ID,
                model.DatabaseEntry.COL_TITLE,
                model.DatabaseEntry.COL_GENRE,
                model.DatabaseEntry.COL_URL,
                model.DatabaseEntry.COL_RATING,
        };


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                model.DatabaseEntry.COL_TITLE + " DESC";

        Cursor cursor = dbRead.query(
                model.DatabaseEntry.TABLE_NAME,   // The table to query
                projection,     // The columns to return
                null,   // The columns for the WHERE clause
                null,   // The values for the WHERE clause
                null,   // don't group the rows
                null,   // don't filter by row groups
                sortOrder   // The sort order
        );


        // Get from cursor into a list
        int titleColIndex = cursor.getColumnIndex(model.DatabaseEntry.COL_TITLE);
        List<String> items = new ArrayList<>();
        while(cursor.moveToNext())
        {
            String title = cursor.getString(titleColIndex);
            items.add(title);
        }
        cursor.close();

        return items;
    }

    public ArrayList<model> getAllMovies()
    {
        String query = "SELECT * FROM " + model.DatabaseEntry.TABLE_NAME;
        ArrayList<model> moviesList = new ArrayList<>();
        SQLiteDatabase dbRead = dbHelper.getReadableDatabase();

        Cursor cursor = dbRead.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(model.DatabaseEntry.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(model.DatabaseEntry.COL_TITLE));
            String genre = cursor.getString(cursor.getColumnIndex(model.DatabaseEntry.COL_GENRE));
            String url = cursor.getString(cursor.getColumnIndex(model.DatabaseEntry.COL_URL));
            String rating = cursor.getString(cursor.getColumnIndex(model.DatabaseEntry.COL_RATING));

            model movie = new model();
            movie.setId(id);
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setUrl(url);
            movie.setRating(rating);

            moviesList.add(movie);
        }
        cursor.close();

        return moviesList;
    }

    public void deleteData()
    {
        SQLiteDatabase dbWrite = dbHelper.getWritableDatabase();
        dbWrite.delete(model.DatabaseEntry.TABLE_NAME, null, null);
    }

    ArrayList<model> run()
    {
        this.deleteData();
        this.insertData(
                1,
                "Hollow In The Land",
                "Mystery, Thriller",
                "http://movietrailers.apple.com/movies/independent/hollow-in-the-land/hollow-in-the-land-trailer-1_h480p.mov",
                "3/10"
        );

        this.insertData(
                2,
                "7 Days In Entebbe",
                "Crime, Drama, Thriller ",
                "http://movietrailers.apple.com/movies/focus_features/7-days-in-entebbe/7-days-in-entebbe-trailer-1_h480p.mov",
                "N/A"
        );

        this.insertData(
                3,
                "Beyond Skyline",
                "Fantasy, Thriller",
                "http://movietrailers.apple.com/movies/independent/beyond-skyline/beyond-skyline-trailer-1_h480p.mov",
                "6/10"
        );

        this.insertData(
                4,
                "You Were Never Really Here",
                " Mystery, Thriller",
                "http://movietrailers.apple.com/movies/independent/you-were-never-really-here/you-were-never-really-here-trailer-1_h480p.mov",
                "7/10"
        );

        this.insertData(
                5,
                "Poop Talk",
                "Documentary",
                "http://movietrailers.apple.com/movies/independent/poop-talk/poop-talk-trailer-1_h480p.mov",
                "N/A"
        );

        this.insertData(
                6,
                "Jurassic World: Fallen Kingdom",
                "Action, Adventure",
                "http://movietrailers.apple.com/movies/universal/jurassic-world-fallen-kingdom/jurassic-world-fallen-kingdom-15-awesome_h480p.mov",
                "N/A"
        );

        this.insertData(
                7,
                "Summer 1993",
                "Drama, Biography",
                "http://movietrailers.apple.com/movies/oscilloscope/summer-1993/summer-1993-trailer-1_h480p.mov",
                "7/10"
        );

        this.insertData(
                8,
                "The Strange Ones",
                "Triller, Drama",
                "http://movietrailers.apple.com/movies/independent/the-strange-ones/the-strange-ones-trailer-1_h480p.mov",
                "6/10"
        );

        this.insertData(
                9,
                "Have A Nice Day",
                "Crime, Drama",
                "http://movietrailers.apple.com/movies/independent/have-a-nice-day/have-a-nice-day-trailer-1_h480p.mov",
                "7/10"
        );

        this.insertData(
                10,
                "Please Stand By",
                "Drama, Comedy",
                "http://movietrailers.apple.com/movies/magnolia_pictures/please-stand-by/please-stand-by-trailer-1_h480p.mov",
                "8/10"
        );

        return this.getAllMovies();
    }
}
