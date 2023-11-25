package com.cookandroid.mouseevent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 전역 변수로 이미지의 초기 위치를 지정
    static float imageX = 100;
    static float imageY = 100;

    private final int MOVE_STEP = 10;
    private MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MyGraphicView를 레이아웃에서 ID로 찾아와 연결
        graphicView = findViewById(R.id.myGraphicView);

        // 전체 레이아웃에 TouchListener 설정 (그림이 아닌 전체 레이아웃을 클릭했을 때 반응하게 하기 위함)
        RelativeLayout layout = findViewById(R.id.mainLayout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 터치 이벤트 처리
                // 왼쪽으로 이동
                imageX -= MOVE_STEP;

                // 그림이 화면을 벗어나면 반대편에서 나타나도록 처리
                handleOutOfBounds();
                // 화면 갱신
                graphicView.invalidate();

                // 이벤트를 소비하여 다른 동작이 처리되지 않도록 함
                return true;
            }
        });
    }

    private void handleOutOfBounds() {
        // 그림이 화면을 벗어나면 반대편에서 나타나도록 처리
        if (imageX + graphicView.getImageWidth() < 0) {
            imageX = getWidth();
        } else if (imageX > getWidth()) {
            imageX = 0 - graphicView.getImageWidth();
        }

        if (imageY + graphicView.getImageHeight() < 0) {
            imageY = getHeight();
        } else if (imageY > getHeight()) {
            imageY = 0 - graphicView.getImageHeight();
        }
    }

    //디바이스의 가로 크기를 반환하는 메소드
    private int getWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    //디바이스의 세로 크기를 반환하는 메소드
    private int getHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}