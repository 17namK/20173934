package ac.example.project_211115;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Join extends Activity {

    EditText jId, jPw;
    Button btnRegistartion, btnJoinMain;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        jId=(EditText)findViewById(R.id.jId);
        jPw=(EditText)findViewById(R.id.jPw);
        btnRegistartion=(Button)findViewById(R.id.j_Registration);
        btnJoinMain=(Button)findViewById(R.id.jMain);
        myHelper = new myDBHelper(this);
        btnRegistartion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO Joininfo VALUES('"
                        +jId.getText().toString()+"','"
                        +jPw.getText().toString()+"');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "성공적으로 회원가입 되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });//btnRegistartion

        btnJoinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });//btnJoinMain



    }//onCreate
    public class myDBHelper extends SQLiteOpenHelper{

        public myDBHelper(Context context){
            super(context, "LoginDB", null, 1);
        }//

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE Joininfo(uId TEXT, upassword TEXT);");
        }//oncreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Joininfo");
            onCreate(db);
        }//onUpgrade
    }//SQLiteOpenHelper

}//MainActivity
