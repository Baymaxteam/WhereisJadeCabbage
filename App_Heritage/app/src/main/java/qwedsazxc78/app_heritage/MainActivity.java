package qwedsazxc78.app_heritage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "翠玉白菜",
    };


    int[] listviewImage = new int[]{
            R.drawable.jade_cabbage,
    };

    String[] listviewShortDescription = new String[]{
            "翠玉屬輝玉類,產於雲南至緬甸的山區,其赭紅色者俗稱作「翡」,翠綠色者俗稱作「翠」。\n\n" +
                    "此件「翠玉白菜」原陳設於永和宮,但種在一個海棠花形小琺瑯盆裡,其旁尚搭配紅色珊瑚靈芝。" +
                    "其原為一塊半灰白半翠綠的輝玉,玉匠巧妙地利用玉質本來的顏色," +
                    "雕成一顆筋脈分明、栩栩如生的白菜,其上則雕刻螽斯和蝗蟲。\n\n" +
                    "螽斯也就是俗稱的「紡織娘」," +
                    "紡織娘因為繁殖力很強,在古代是被當做多子多孫的吉祥象徵。\n\n" +
                    "《詩經.周南》即言:「螽斯羽詵詵兮,宜爾子孫振振兮。」\n\n",

    };

    int detect_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("文物辨識");



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Context context_detect = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent Intent_detect = new Intent( context_detect ,introDetailActivity.class);
                Intent_detect.putExtra("title", listviewTitle[detect_index]);
                Intent_detect.putExtra("image", listviewImage[detect_index]);
                Intent_detect.putExtra("description", listviewShortDescription[detect_index]);
                startActivity(Intent_detect);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent Intent_intro1 = new Intent(this , introActivity.class);
            startActivity(Intent_intro1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
