package org.xiangbalao.gesturetesttest;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // TODO Auto-generated method stub
        return this.gestureDetector.onTouchEvent(event); 
    }

    
 
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      
        
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
            float start = e1.getX();
            float end = e2.getX();
            if ((start - end) > Constants.SCROLL_THRESHOLD)
            {
                // 
                startActivity(new Intent(MainActivity.this, SecendActivity.class));
                
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                
                finish();
                
            }
            else if ((end - start) > Constants.SCROLL_THRESHOLD)
            {
              Toast.makeText(MainActivity.this, "已是第一项", Toast.LENGTH_SHORT).show();
                
                
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
 
    
    
    
}
