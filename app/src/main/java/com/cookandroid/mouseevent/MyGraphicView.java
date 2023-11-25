package com.cookandroid.mouseevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;

public class MyGraphicView extends View {

    private Drawable image;

    // 생성자
    public MyGraphicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 이미지 리소스를 가져와 Drawable 객체 생성
        image = ContextCompat.getDrawable(context, R.drawable.woman);
    }

    //그래픽을 그리는 메소드로, 화면을 다시 그릴 때 호출됨.
    //그림의 위치가 onDraw에서 변경됨.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 이미지를 현재 위치에 그림
        image.setBounds((int) MainActivity.imageX, (int) MainActivity.imageY,
                (int) MainActivity.imageX + image.getIntrinsicWidth(),
                (int) MainActivity.imageY + image.getIntrinsicHeight());
        image.draw(canvas);
    }

    // 이미지의 폭을 반환하는 메소드
    public int getImageWidth() {
        return image.getIntrinsicWidth();
    }

    // 이미지의 높이를 반환하는 메소드
    public int getImageHeight() {
        return image.getIntrinsicHeight();
    }
}