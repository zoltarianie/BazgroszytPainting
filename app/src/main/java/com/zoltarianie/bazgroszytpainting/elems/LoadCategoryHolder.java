package com.zoltarianie.bazgroszytpainting.elems;

import com.zoltarianie.bazgroszytpainting.R;

public class LoadCategoryHolder {
    public static CategoryHolder[] getAll() {
        CategoryHolder categoryTail[] = new CategoryHolder[3];
        categoryTail[0] = new CategoryHolder(R.drawable.okladka_00);
        categoryTail[1] = new CategoryHolder(R.drawable.okladka_01);
        categoryTail[2] = new CategoryHolder(R.drawable.okladka_02);
        return categoryTail;
    }
}