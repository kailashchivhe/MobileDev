package com.kai.hw05.listener;

public interface FragmentChangeListener {
    void onRegisterCancelClicked();
    void navigateToRegisterFragment();
    void navigateToForumsFromRegister();
    void navigateToForums();
    void navigateToForumsFromCreate();
    void navigateToCreateForums();
    void onLogout();
}
