package com.cookandroid.keyboardevent;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private int x, y;
    private final int MOVE_STEP = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageView 객체 초기화 및 이미지 및 초기 좌표 설정
        imgView = findViewById(R.id.imageView1);
        imgView.setImageResource(R.drawable.woman);
        imgView.setX(100.0f); // 초기 좌표
        imgView.setY(100.0f);

        // 현재 좌표 저장
        x = (int) imgView.getX();
        y = (int) imgView.getY();

        // 키보드 이벤트 처리
        imgView.setFocusable(true);
        imgView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // 키 이벤트가 눌린 경우
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_UP:
                            // 위로 이동
                            y -= MOVE_STEP;
                            break;
                        case KeyEvent.KEYCODE_DPAD_DOWN:
                            // 아래로 이동
                            y += MOVE_STEP;
                            break;
                        case KeyEvent.KEYCODE_DPAD_LEFT:
                            // 왼쪽으로 이동
                            x -= MOVE_STEP;
                            break;
                        case KeyEvent.KEYCODE_DPAD_RIGHT:
                            // 오른쪽으로 이동
                            x += MOVE_STEP;
                            break;
                    }

                    // 이미지가 화면을 벗어나면 반대편에서 나타나도록 처리
                    handleOutOfBounds();
                    // 이미지의 위치를 업데이트
                    updateImagePosition();

                    return true;
                }
                return false;
            }
        });
    }

    //onKeyDown() override 하여 사용
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 키 이벤트가 눌린 경우
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                // 위로 이동
                y -= MOVE_STEP;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                // 아래로 이동
                y += MOVE_STEP;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                // 왼쪽으로 이동
                x -= MOVE_STEP;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                // 오른쪽으로 이동
                x += MOVE_STEP;
                break;
        }

        // 이미지가 화면을 벗어나면 반대편에서 나타나도록 처리
        handleOutOfBounds();
        // 이미지의 위치를 업데이트
        updateImagePosition();

        return super.onKeyDown(keyCode, event);
    }

    private void handleOutOfBounds() {
        // 이미지가 화면을 벗어나면 반대편에서 나타나도록 처리
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;

        if (x + imgView.getWidth() < 0) {
            x = screenWidth;
        } else if (x > screenWidth) {
            x = 0 - imgView.getWidth();
        }

        if (y + imgView.getHeight() < 0) {
            y = screenHeight;
        } else if (y > screenHeight) {
            y = 0 - imgView.getHeight();
        }
    }

    private void updateImagePosition() {
        // 이미지의 위치를 업데이트
        imgView.setX(x);
        imgView.setY(y);
    }
}

