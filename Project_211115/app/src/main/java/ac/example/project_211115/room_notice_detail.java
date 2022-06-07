package ac.example.project_211115;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class room_notice_detail extends Activity {

    Button btnback, MView, Mtips, Mmain, Mfavorite, Mprofile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_notice_detail);
        MView = (Button) findViewById(R.id.MView);
        Mtips = (Button) findViewById(R.id.Mtips);
        Mmain = (Button) findViewById(R.id.Mmain);
        Mfavorite = (Button) findViewById(R.id.Mfavorite);
        Mprofile = (Button) findViewById(R.id.Mprofile);
        btnback = (Button) findViewById(R.id.noback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), room_notice.class);
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
