package com.zoltarianie.bazgroszytpainting;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.zoltarianie.bazgroszytpainting.elems.DrawingView;


public class DrawingColoringBook extends Activity {

    //custom drawing view
    private DrawingView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_coloring_book);

        //get drawing view
        drawView = (DrawingView)findViewById(R.id.drawing);
        //set initial size
        drawView.setBrushSize(20);
    }
}
