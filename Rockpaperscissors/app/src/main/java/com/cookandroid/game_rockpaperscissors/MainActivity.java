package com.cookandroid.game_rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //ui의 위젯과 연결할 참조 변수
    TextView txtUser, txtComputer, txtScore, txtMessage;
    Button btnScissors, btnRock, btnPaper;
    //이미지 리소스 저장
    ImageView imgUser;
    ImageView imgComputer;
    int imgResource[] ={R.drawable.scissors, R.drawable.rock, R.drawable.paper};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ui의 위젯 연결
        imgUser = (ImageView) findViewById(R.id.imageUser); //이미지 위젯 연결
        imgComputer = (ImageView) findViewById(R.id.imageComputer); //이미지 위젯 연결
        txtUser = (TextView) findViewById(R.id.textUser);
        txtComputer = (TextView) findViewById(R.id.textComputer);
        txtMessage = (TextView) findViewById(R.id.textMessage);
        txtScore = (TextView) findViewById(R.id.textScore);
        //버튼
        btnScissors = (Button) findViewById(R.id.buttonScissors);
        btnRock = (Button) findViewById(R.id.buttonRock);
        btnPaper = (Button) findViewById(R.id.buttonPaper);
        //Listener 메소드
        Button.OnClickListener MyButtonListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //출력
                txtMessage.setText(view.getTag().toString());
                //이미지 출력
                int user = Integer.parseInt(view.getTag().toString());
                imgUser.setImageResource(imgResource[user]);
            }
        };
        //Listener 적용
        btnScissors.setOnClickListener(MyButtonListener);
        btnRock.setOnClickListener(MyButtonListener);
        btnPaper.setOnClickListener(MyButtonListener);
        //Computer를 위한 난수 발생
        
        //user와 computer의 수를 비교하여 승패 판단.
        
        //결과는 textView에 출력

    }//OnCreate


}//MainActivity