package mahokkit.movietrailerapp;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;

/**
 * Created by Edward on 12/07/17.
 */

public class MovieActivity extends MainActivity
{
    ProgressDialog pDialog;
    VideoView videoViewTrailer;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_player);

        // Get string passed into intent

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        // Get views
        videoViewTrailer = findViewById(R.id.movieTrailer);

        // Create a progressbar
        pDialog = new ProgressDialog(MovieActivity.this);
        // Set progressbar title
        pDialog.setTitle(title);
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();
        // Setup media controls
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    MovieActivity.this);
            mediacontroller.setAnchorView(videoViewTrailer);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(url);
            videoViewTrailer.setMediaController(mediacontroller);
            videoViewTrailer.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoViewTrailer.requestFocus();
        videoViewTrailer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoViewTrailer.start();
            }
        });
    }
}
