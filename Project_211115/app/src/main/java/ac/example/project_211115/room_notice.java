package ac.example.project_211115;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class room_notice extends Activity {

    Button MView, Mtips, Mmain, Mfavorite, Mprofile, btnBack;
    ListView notice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_notice);
        MView = (Button) findViewById(R.id.MView);
        Mtips = (Button) findViewById(R.id.Mtips);
        Mmain = (Button) findViewById(R.id.Mmain);
        Mfavorite = (Button) findViewById(R.id.Mfavorite);
        Mprofile = (Button) findViewById(R.id.Mprofile);
        btnBack = (Button)findViewById(R.id.btnBack);



        final String[] mid1={"안녕하세요. 방이필요해 입니다.", "공지사항2", "공지사항3", "공지사항4"};
        notice = (ListView)findViewById(R.id.noticeList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,mid1);
        notice.setAdapter(adapter);//리스트 형태지점

        notice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(getApplicationContext(), room_notice_detail.class);
                    startActivity(intent);
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });



        //하단 메뉴
        MView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_view_main.class);
                startActivity(intent);
            }
        });
        Mtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_tips.class);
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
                Intent intent= new Intent(getApplicationContext(), favorite.class);
                startActivity(intent);
            }
        });
        Mprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });
    }


}
