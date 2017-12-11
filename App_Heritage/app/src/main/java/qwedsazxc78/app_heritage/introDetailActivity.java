package qwedsazxc78.app_heritage;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class introDetailActivity extends AppCompatActivity {

    private TextToSpeech TTSObj;
    private String title;
    private int image;
    private String Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title        = this.getIntent().getExtras().getString("title");
        image      = this.getIntent().getExtras().getInt("image");
        Description = this.getIntent().getExtras().getString("description");

        // set select item name
        setTitle(title);

        // show the select item image and description by
        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("introDetail_Description", Description);
            hm.put("introDetail_image", Integer.toString(image));
            aList.add(hm);

        String[] from = {"introDetail_image", "introDetail_Description"};
        int[] to = {R.id.introDetail_image, R.id.introDetail_Description};

        // list view adapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.intro_detail_list, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listview_introdetail);
        androidListView.setAdapter(simpleAdapter);

        // text to speech function
        TTSObj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS) {
                    if(TTSObj.isLanguageAvailable(Locale.CHINESE) == TextToSpeech.LANG_AVAILABLE) {
                        TTSObj.setLanguage(Locale.CHINESE);
                        Toast.makeText(getApplicationContext(), "TTS chinese", Toast.LENGTH_LONG).show();

                        Log.v("[T]", "TTS chinese");
                    }
                    else if(TTSObj.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE) {
                        TTSObj.setLanguage(Locale.US);
                        Toast.makeText(getApplicationContext(), "TTS US", Toast.LENGTH_LONG).show();
                        Log.v("[T]","TTS US");
                    }
                    else if(TTSObj.isLanguageAvailable(Locale.TRADITIONAL_CHINESE) == TextToSpeech.LANG_AVAILABLE) {
                        TTSObj.setLanguage(Locale.TRADITIONAL_CHINESE);
                        Toast.makeText(getApplicationContext(), "TTS TRADITIONAL_CHINESE", Toast.LENGTH_LONG).show();
                        Log.v("[T]","TTS TRADITIONAL_CHINESE");
                    }
                } else if (status == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(), "TTS init fail", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "TTS init else", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onPause(){
        if(TTSObj !=null){
            TTSObj.stop();
            TTSObj.shutdown();
        }
        super.onPause();
    }

    /** Called when the user touches the button */
    // start speech the introduction text
    public void speechMessage(View view) {
        // Toast.makeText(getApplicationContext(), "開啟語音導覽", Toast.LENGTH_LONG).show();
        TTSObj.speak(Description, TextToSpeech.QUEUE_FLUSH, null);
    }
}
