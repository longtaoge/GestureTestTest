package org.xiangbalao.gesturetesttest;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class SecendActivity extends ActionBarActivity
{
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        
        gestureDetector = new GestureDetector(this, onGestureListener);
    }
    
    /**
     * 手势监听对象
     */
    OnGestureListener onGestureListener = new OnGestureListener()
    {
        @Override
        public boolean onSingleTapUp(MotionEvent e)
        {
            return false;
        }
        
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            return false;
        };
        
        public void onLongPress(MotionEvent e)
        {
            
        };
        
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            float start = e2.getX();
            float end = e1.getX();
            if ((start - end) > Constants.SCROLL_THRESHOLD)
            {
                // finish();
                startActivity(new Intent(SecendActivity.this, MainActivity.class));
                
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                
                
                
            }
            else if ((end - start) > Constants.SCROLL_THRESHOLD)
            {
              Toast.makeText(SecendActivity.this, "已是最后一项", Toast.LENGTH_SHORT).show();
                
                
            }
            return false;
        };
        
        public void onShowPress(MotionEvent e)
        {
            
        };
        
        public boolean onDown(MotionEvent e)
        {
            return false;
        };
    };
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // TODO Auto-generated method stub
        return this.gestureDetector.onTouchEvent(event); 
    }

    
    
}
