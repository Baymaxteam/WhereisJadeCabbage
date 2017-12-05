package qwedsazxc78.app_heritage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class introDetailActivity extends AppCompatActivity {

//    private ImageView showImage;
//    private TextView  showDescription;
    private Button    clickSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title        = this.getIntent().getExtras().getString("title");
        int image           = this.getIntent().getExtras().getInt("image");
        String Description  = this.getIntent().getExtras().getString("description");

        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("introDetail_Description", Description);
            hm.put("introDetail_image", Integer.toString(image));
            aList.add(hm);

        String[] from = {"introDetail_image", "introDetail_Description"};
        int[] to = {R.id.introDetail_image, R.id.introDetail_Description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.intro_detail_list, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listview_introdetail);
        androidListView.setAdapter(simpleAdapter);

        setTitle(title);

//        showDescription = (TextView) findViewById(R.id.introDetail_Description);
//        showDescription.setText(Description);
//
//        showImage = (ImageView) findViewById(R.id.introDetail_image);
//        showImage.setImageResource(image);

    }

    /** Called when the user touches the button */
    public void speechMessage(View view) {
        // Do something in response to button click
    }
}
