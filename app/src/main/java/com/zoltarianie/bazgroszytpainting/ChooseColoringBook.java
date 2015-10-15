package com.zoltarianie.bazgroszytpainting;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zoltarianie.bazgroszytpainting.elems.CategoryHolder;
import com.zoltarianie.bazgroszytpainting.elems.LoadCategoryHolder;
import com.zoltarianie.bazgroszytpainting.elems.ViewPagerParallax;

public class ChooseColoringBook extends Activity {

    private CategoryHolder[] coloringBooksToShow = LoadCategoryHolder.getAll();
    private static final int MAX_PAGES = 10;
    private int num_pages = coloringBooksToShow.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_coloring_books);

        final ViewPagerParallax pager = (ViewPagerParallax) findViewById(R.id.pager);
        pager.set_max_pages(MAX_PAGES);
        pager.setBackgroundAsset(R.drawable.sanfran);
        pager.setAdapter(new my_adapter());

        if (savedInstanceState!=null) {
            Log.v("ViewPagerParallax", "savedInstanceState!=null");

            num_pages = savedInstanceState.getInt("num_pages");
            pager.setCurrentItem(savedInstanceState.getInt("current_page"), false);
        }
    }

    public void efClickColoringBookTile(View view) {
        Intent intent = new Intent(getApplicationContext(), DrawingColoringBook.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("num_pages", num_pages);
        final ViewPagerParallax pager = (ViewPagerParallax) findViewById(R.id.pager);
        outState.putInt("current_page", pager.getCurrentItem());
    }

    private class my_adapter extends PagerAdapter {
        @Override
        public int getCount() {
            return num_pages;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View new_view=null;

            Log.v("ViewPagerParallax", position+"!!!"+coloringBooksToShow.length);

            LayoutInflater inflater = getLayoutInflater();
            new_view = inflater.inflate(R.layout.page_coloring_book, null);
/*
            ImageView tileImg = (ImageView) new_view.findViewById(R.id.image);
            tileImg.setImageDrawable(getResources().getDrawable(coloringBooksToShow[position].idDrawagbleTile));
            tileImg.setTag("" + position);
*/
            container.addView(new_view);

            return new_view;
        }
    }
}