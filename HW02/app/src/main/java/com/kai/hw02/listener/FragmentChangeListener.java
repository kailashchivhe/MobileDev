package com.kai.hw02.listener;

public interface FragmentChangeListener {
    void launchFilterFragment();
    void launchSortFragment();
    void goToUserFragmentFromFilter(String state );
    void setTitle( String title );
    void onSortClicked( boolean sortAgeAscEnabled,
                        boolean sortNameAscEnabled,
                        boolean sortStateAscEnabled,
                        boolean sortAgeDscEnabled,
                        boolean sortNameDscEnabled,
                        boolean sortStateDscEnabled );
}
