package mahokkit.movietrailerapp;

import android.app.Activity;
import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

/**
 * Created by Edward on 12/07/17.
 */

public class GridViewAdapter extends ArrayAdapter
{
    private Context context;
    private int layoutResourceId;
    private ArrayList<model> moviesList;

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList moviesList) {
        super(context, layoutResourceId, moviesList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.moviesList = moviesList;
    }

    static class ViewHolder
    {
        TextView mTitle;
        TextView mGenre;
        TextView mRate;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View block = convertView;
        ViewHolder holder;

        if(block == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            block = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.mTitle = block.findViewById(R.id.movieTitle);
            holder.mGenre = block.findViewById(R.id.movieGenre);
            holder.mRate = block.findViewById(R.id.movieRating);
            block.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) block.getTag();
        }

        model movies = moviesList.get(position);

        holder.mTitle.setText("Title: " + movies.getTitle());
        holder.mGenre.setText("Genre: "+ movies.getGenre());
        holder.mRate.setText("Rating: " + movies.getRating());

        return block;
    }


}
