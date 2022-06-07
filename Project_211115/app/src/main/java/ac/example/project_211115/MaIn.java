package ac.example.project_211115;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class MaIn extends Activity {

    ImageButton room_view,room_share,room_tips;
    Button MView, Mtips, Mmain, Mfavorite, Mprofile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        room_view = (ImageButton) findViewById(R.id.room_view);
        room_share = (ImageButton) findViewById(R.id.room_share);
        room_tips = (ImageButton) findViewById(R.id.room_tips);

        MView = (Button) findViewById(R.id.MView);
        Mtips = (Button) findViewById(R.id.Mtips);
        Mmain = (Button) findViewById(R.id.Mmain);
        Mfavorite = (Button) findViewById(R.id.Mfavorite);
        Mprofile = (Button) findViewById(R.id.Mprofile);

        //메인 탭
        room_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_view_main.class);
                startActivity(intent);
                finish();
            }
        });//setOn
        room_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_share.class);
                startActivity(intent);
                finish();
            }
        });
        room_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_tips.class);
                startActivity(intent);
                finish();
            }
        });

        //하단 메뉴
        MView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_view_main.class);
                startActivity(intent);
                finish();
            }
        });
        Mtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_tips.class);
                startActivity(intent);
                finish();
            }
        });
        Mmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MaIn.class);
                startActivity(intent);
                finish();
            }
        });
        Mfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), favorite.class);
                startActivity(intent);
                finish();
            }
        });
        Mprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
                finish();
            }
        });

    }//onCreate
}//Activity
