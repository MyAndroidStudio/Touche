package com.example.hachem.touche;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchActivity extends Activity implements View.OnTouchListener {

    private static final String TAG_LOG = "TouchActivity";
    private static final boolean LOG = true;

    private FrameLayout mFrameLayout;
    private TextView mZ1;
    private TextView mZ2;

    private ToggleButton mButtonZ1;
    private ToggleButton mButtonZ2;
    private ToggleButton mButtonFrameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mFrameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        mZ1 = (TextView)findViewById(R.id.z1);
        mZ2 = (TextView)findViewById(R.id.z2);
        mButtonFrameLayout = (ToggleButton)findViewById(R.id.mButtonFrameLayout);
        mButtonZ1 = (ToggleButton)findViewById(R.id.mButtonZ1);
        mButtonZ2 = (ToggleButton)findViewById(R.id.mButtonZ2);

        mZ1.setOnTouchListener(this);
        mZ2.setOnTouchListener(this);
        mFrameLayout.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == mZ1) {
            log("mZ1: " + stringValue(event));
            return mButtonZ1.isChecked();
        } else if (v == mZ2) {
            log("mZ2: " + stringValue(event));
            return mButtonZ2.isChecked();
        } else if (v == mFrameLayout) {
            log("mFrameLayout: " + stringValue(event));
            return mButtonFrameLayout.isChecked();
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log("Activity: " + stringValue(event));
        return true;
    }

    private String stringValue(MotionEvent event) {

        final int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
        }

        return "";
    }

    private static void log(String message){
        if (LOG) {
            Log.d(TAG_LOG, message);
        }
    }
}