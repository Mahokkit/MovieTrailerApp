package mahokkit.movietrailerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    GridView gridView;
    GridViewAdapter gridViewAdapter;
    ArrayList<model> databaseResults;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up database
        DataQ db = new DataQ(this);

        // Delete, insert, and query data
        databaseResults = db.run();

        // Setup grid view
        gridView = findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(this, R.layout.item_layout, databaseResults);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Get movie selection
                model movies = (model) parent.getItemAtPosition(position);

                // Intent
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra("title",movies.getTitle());
                intent.putExtra("url", movies.getUrl());

                startActivity(intent);
            }
        });
    }
}
