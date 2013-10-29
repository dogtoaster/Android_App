package com.signals.api_test;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class TouchCircleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchcircle);
        //setContentView(new DrawCircles(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.touch_circle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class DrawCircles extends View {

        public DrawCircles(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
            drawCircle(canvas);

        }

        private void drawCircle(Canvas canvas) {

            Random r = new Random();

            int DrawWidth = getWindowManager().getDefaultDisplay().getWidth();
            int DrawHeight = getWindowManager().getDefaultDisplay().getHeight();
            int randomX = r.nextInt(DrawWidth - 15 + 1) + 16;
            int randomY = r.nextInt(DrawHeight - 15 + 1) + 16;

            // TODO Auto-generated method stub
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(randomX, randomY, 30, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DrawNewCircle();
        int eventaction = event.getAction();

        TextView edttouchcircleinfo = (TextView) findViewById(R.id.edttouchcircleinfo);

/*        if (edttouchcircleinfo.isShown())  {

            edttouchcircleinfo.setVisibility(TextView.INVISIBLE);

        }*/

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                // finger touches the screen
                setContentView(new DrawCircles(this));
                break;

            case MotionEvent.ACTION_MOVE:
                // finger moves on the screen
                break;

            case MotionEvent.ACTION_UP:
                // finger leaves the screen
                break;
        }

        // tell the system that we handled the event and no further processing is required
        return true;
    }

}
