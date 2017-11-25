package qwedsazxc78.app_heritage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class introActivity extends AppCompatActivity {

    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "翠玉白菜", "肉形石", "毛公鼎",
    };


    int[] listviewImage = new int[]{
            R.drawable.jade_cabbage, R.drawable.meat_stone, R.drawable.mao_kung_ting,
    };

    String[] listviewShortDescription = new String[]{
            "翠玉屬輝玉類,產於雲南至緬甸的山區,其赭紅色者俗稱作「翡」,翠綠色者俗稱作「翠」。\n\n" +
                    "此件「翠玉白菜」原陳設於永和宮,但種在一個海棠花形小琺瑯盆裡,其旁尚搭配紅色珊瑚靈芝。" +
                    "其原為一塊半灰白半翠綠的輝玉,玉匠巧妙地利用玉質本來的顏色," +
                    "雕成一顆筋脈分明、栩栩如生的白菜,其上則雕刻螽斯和蝗蟲。\n\n" +
                    "螽斯也就是俗稱的「紡織娘」," +
                    "紡織娘因為繁殖力很強,在古代是被當做多子多孫的吉祥象徵。\n\n" +
                    "《詩經.周南》即言:「螽斯羽詵詵兮,宜爾子孫振振兮。」\n\n",

            "肉形石為國立故宮博物院最富人氣的文物之一,材質屬玉髓類的碧石。\n\n" +
                    "仔細端詳可見玉石形成過程中層次豐富的堆疊紋理,由底部天然的原石;至頂部的鑽孔、染色," +
                    "無不透露出自然與人工生動且巧妙的結合。\n\n" +
            "在工匠的巧思下,冷硬的玉石化為軟嫩「東坡肉」的想像,蘇軾在黃州時曾寫過:「待他自熟莫催他,火候足時他自美。" +
                    "......飽得自家君莫管。」的〈豬肉頌。\n\n" +
                    "而宋人也有:「蒸處已將蕉葉裹,熟時兼用杏漿澆。紅鮮雅稱金盤飣,熟軟真堪玉箸挑。」形容豬肉烹調的詩句。\n\n" +
            "「肉形石」除反映華夏「人與美石」的關係外,也充分展現飲食文化的特色," +
                    "無怪乎蘇東坡曾讚嘆:「蓋聚物之夭美,以養吾之老饕。」\n\n",

            "毛公鼎是西周宣王年間所鑄造的青銅鼎,腹內刻有 500 字金文冊命書," +
                    "字數為舉世銘文青銅器中最多,是西周散文代表作。\n\n" +
                    "書法也是金文中最高等級,故有「抵得一篇《尚書》」、晚清「四大國寶」、「青銅三寶」之譽現\n\n" +
                    "收藏於臺北國立故宮博物院,並列為中華民國國寶。\n\n",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("文物導覽");

        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.intro_list, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listview_introitem);
        androidListView.setAdapter(simpleAdapter);

        final Context context = this;
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();

                Intent Intent_detail = new Intent(context, introDetailActivity.class);

                Intent_detail.putExtra("title", listviewTitle[position]);
                Intent_detail.putExtra("image", listviewImage[position]);
                Intent_detail.putExtra("description", listviewShortDescription[position]);
                startActivity(Intent_detail);
            }
        });

    }
}
