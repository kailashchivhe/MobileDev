package com.kai.hw02.listener;

public interface FragmentChangeListener {
    void launchFilterFragment();
    void goToUserFragmentFromFilter(String state );
    void setTitle( String title );
}
