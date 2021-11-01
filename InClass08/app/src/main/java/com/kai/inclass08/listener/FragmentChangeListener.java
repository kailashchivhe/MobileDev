package com.kai.inclass08.listener;

public interface FragmentChangeListener {
    void onRegisterCancelClicked();
    void navigateToRegisterFragment();
    void navigateToForumsFromRegister();
    void navigateToForums();
    void navigateToForumsFromCreate();
    void navigateToCreateForums();
    void onLogout();
}
