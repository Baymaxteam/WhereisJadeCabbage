package qwedsazxc78.app_heritage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class introDetailActivity extends AppCompatActivity {

    private ImageView showImage;
    private TextView showDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        String title        = this.getIntent().getExtras().getString("title");
        int image           = this.getIntent().getExtras().getInt("image");
        String Description  = this.getIntent().getExtras().getString("description");

        setTitle(title);

        showDescription = (TextView) findViewById(R.id.introDetail_Description);
        showDescription.setText(Description);

        showImage = (ImageView) findViewById(R.id.introDetail_image);
        showImage.setImageResource(image);
        // showDescription.setText(Description);


        // Toast.makeText(getApplicationContext(), "Send Image " + image, Toast.LENGTH_LONG).show();
//        showImage.setImageDrawable((imageview)findViewById(image));


    }
}
