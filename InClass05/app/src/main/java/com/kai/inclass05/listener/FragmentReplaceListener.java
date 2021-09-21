package com.kai.inclass05.listener;

import com.kai.inclass05.data.DataServices;

public interface FragmentReplaceListener {

    void onAppCategoryClick( String category );
    void onCategoryClick(DataServices.App app);
    void setTitle( String title );
}
