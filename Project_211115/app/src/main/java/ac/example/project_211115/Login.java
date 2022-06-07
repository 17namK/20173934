package ac.example.project_211115;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends Join {
    EditText edtId,edtPw;
    Button btnJoin, btnLogin;
    int IdFlag=0;
    int PwFlag=0;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.login);
        edtId = (EditText) findViewById(R.id.main_edtId);
        edtPw = (EditText) findViewById(R.id.main_edtPw);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });//btnJoin

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor;
                sqlDB=myHelper.getReadableDatabase();
                cursor=sqlDB.rawQuery("SELECT * FROM Joininfo;", null);
                String edt1 = null;//화면에 입력된 아이디 저장할 임시변수 초기화
                String pass1 = null;//화면에 입력된 비번 저장할 임시변수
                String edt2 = null;//LoginDB->Joininfo테이블에 찾은 아이디 저장 임시변수
                String pass2 = null;//LoginDB->Joininfo테이블에서 찾은 비번 저장 임시변수

                IdFlag = 0;//회원 ID가 일치하면 1 아니면 0
                PwFlag = 0;//while문 전 초기화

                while (cursor.moveToNext()){
                    edt2 = cursor.getString(0);
                    pass2 = cursor.getString(1);
                    edt1=edtId.getText().toString();
                    pass1=edtPw.getText().toString();

                    if(edt2.equals(edt1)){
                        IdFlag=1;
                        if (pass2.equals(pass1)){
                            PwFlag=1;
                            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_LONG).show();
                            //MainActivity화면으로 다시 이동한다고 가정
                            Intent intent = new Intent(getApplicationContext(), MaIn.class);
                            startActivity(intent);
                        }//if-passward
                        else {
                            Toast.makeText(getApplicationContext(), "비밀번호를 틀렸습니다. 확인해 주세요.", Toast.LENGTH_LONG).show();
                        }
                    }//if-id
                    else{

                    }//else
                }//while
                cursor.close();
                sqlDB.close();
                if (IdFlag==0 && PwFlag==0){
                    Toast.makeText(getApplicationContext(), "회원이 아닙니다. 회원가입 부탁드립니다.", Toast.LENGTH_LONG).show();
                }

            }//onClick
        });//btnLogin

    }//onCreate
}//MainActivity
