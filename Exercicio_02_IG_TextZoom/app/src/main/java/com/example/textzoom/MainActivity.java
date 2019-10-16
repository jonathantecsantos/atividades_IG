package com.example.textzoom;

import android.service.autofill.FieldClassification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    TextView textView;
    final static float move = 200;
    float ratio = 1.0f;
    int baseDist;
    float baseRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView.setTextSize(ratio+15);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getPointerCount()==2){
            int action = event.getAction();
            int mainaction = action&MotionEvent.ACTION_MASK;
            if(mainaction == MotionEvent.ACTION_POINTER_DOWN){
                baseDist = getDistance(event);
                baseRatio = ratio;
            }else{
                float scale = (getDistance(event)-baseDist)/move;
                float factor = (float) Math.pow(2,scale);
                ratio = Math.min(1024.0f,Math.max(0.1f,baseRatio*factor));
                textView.setTextSize(ratio+15);
            }
        }
        return true;
    }
    private int getDistance(MotionEvent event){
        int dx = (int) (event.getX(0)-event.getX(1));
        int dy = (int) (event.getY(0)-event.getY(1));
        return (int)(Math.sqrt(dx*dx+dy*dy));
    }
}
