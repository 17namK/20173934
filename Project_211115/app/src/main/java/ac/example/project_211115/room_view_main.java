package ac.example.project_211115;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class room_view_main extends Activity {
    public static final String EXTRA_DELVERY = "delivery";

    Button MView, Mtips, Mmain, Mfavorite, Mprofile, reg_button, btn;
    ListView vlist;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_view_main);
        MView = (Button) findViewById(R.id.MView);
        Mtips = (Button) findViewById(R.id.Mtips);
        Mmain = (Button) findViewById(R.id.Mmain);
        Mfavorite = (Button) findViewById(R.id.Mfavorite);
        Mprofile = (Button) findViewById(R.id.Mprofile);
        reg_button = findViewById(R.id.reg_button);
        Intent intent = getIntent();
        String de1Name = intent.getStringExtra("Rname");
        String deP1rice = intent.getStringExtra("Rpirce");
        String de1add = intent.getStringExtra("Radd");
        String de1date1 = intent.getStringExtra("Rdate1");
        String de1date2 = intent.getStringExtra("Rdate2");
        String de1first = intent.getStringExtra("Rfirst");
        String de1cause = intent.getStringExtra("Rcause");
        final ArrayList<String> mid = new ArrayList<String>();
        vlist=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,mid);
        vlist.setAdapter(adapter);//리스트 형태지점
        mid.add(de1Name);
        adapter.notifyDataSetChanged();





        CharSequence info[] = new CharSequence[] {"가격 : "+deP1rice, "주소 : " + de1add, "기간 : "+de1date1 + "~"+de1date2, "우선입주사항 : "+de1first, "주의사항 : "+de1cause };


        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(room_view_main.this);


                builder.setIcon(R.drawable.jib_logo);
                builder.setTitle(de1Name).setItems(info, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setPositiveButton("즐겨찾기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), favorite.class);
                        intent.putExtra("fname", de1Name);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("닫기", null);
                builder.show();
            }
        });







        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), room_share.class);
                startActivity(intent);
            }
        });


        //하단 메뉴
        MView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), room_view_main.class);
                startActivity(intent);
            }
        });
        Mtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), room_tips.class);
                startActivity(intent);
            }
        });
        Mmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MaIn.class);
                startActivity(intent);
            }
        });
        Mfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), favorite.class);
                startActivity(intent);
            }
        });
        Mprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });
    }//onCreate

}
