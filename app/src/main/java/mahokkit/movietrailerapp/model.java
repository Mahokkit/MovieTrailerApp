package mahokkit.movietrailerapp;

import android.provider.BaseColumns;

/**
 * Created by Edward on 12/07/17.
 */

public final class model
{
    int ID;
    String title, genre, url, rating;
    public static class DatabaseEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "MovieTrailers";
        public static final String COL_ID = "ID";
        public static final String COL_TITLE = "Title";
        public static final String COL_GENRE = "Genre";
        public static final String COL_URL = "URL";
        public static final String COL_RATING = "Rating";
    }

    public model(){};
    public model(String title, String desc)
    {
        super();
        this.title = title;
        this.genre = genre;
    }

    public int getId()
    {
        return ID;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getUrl()
    {
        return url;
    }

    public String getRating()
    {
        return rating;
    }

    public void setId(int id)
    {
        this.ID = ID;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setGenre(String desc)
    {
        this.genre = desc;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

}
