package ac.example.project_211115;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.Nullable;

import java.time.ZoneId;


// 정확하게 뭐를 하는 화면인지 몰라서 임의의 이름을 사용.


public class room_share extends Activity {

    Button MView, Mtips, Mmain, Mfavorite, Mprofile, rok, rcancle;
    EditText rname, raddress, rprice, rdate1, rdate2, rfirst, rcause;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_share);

        MView = (Button) findViewById(R.id.MView);
        Mtips = (Button) findViewById(R.id.Mtips);
        Mmain = (Button) findViewById(R.id.Mmain);
        Mfavorite = (Button) findViewById(R.id.Mfavorite);
        Mprofile = (Button) findViewById(R.id.Mprofile);
        rok = (Button)findViewById(R.id.rok);
        rcancle = (Button) findViewById(R.id.rcancle);

        rname = (EditText)findViewById(R.id.rname);
        raddress = (EditText)findViewById(R.id.raddres);
        rprice = (EditText)findViewById(R.id.rprice);
        rdate1 = (EditText)findViewById(R.id.rdate1);
        rdate2 = (EditText)findViewById(R.id.rdate2);
        rfirst = (EditText)findViewById(R.id.rfirst);
        rcause = (EditText)findViewById(R.id.rcause);

        rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Rname = rname.getText().toString();
                String Radd = raddress.getText().toString();
                String Rprice = rprice.getText().toString();
                String Rdate1 = rdate1.getText().toString();
                String Rdate2 = rdate2.getText().toString();
                String Rfirst = rfirst.getText().toString();
                String Rcause = rcause.getText().toString();

                Intent intent = new Intent(getApplicationContext(), room_view_main.class);
                intent.putExtra("Rname", Rname);
                intent.putExtra("Radd", Radd);
                intent.putExtra("Rpirce", Rprice);
                intent.putExtra("Rdate1", Rdate1);
                intent.putExtra("Rdate2", Rdate2);
                intent.putExtra("Rfirst", Rfirst);
                intent.putExtra("Rcause", Rcause);
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
