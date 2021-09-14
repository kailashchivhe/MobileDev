package com.kai.inclass04.listener;

import com.kai.inclass04.data.DataServices;

public interface FragmentReplaceListener {
    void onLoginSuccess(DataServices.Account account);
    void onCreateClicked();
    void onCancelClicked();
    void onSubmitClicked( DataServices.Account account );
    void onEditClicked( DataServices.Account account );
    void onLogoutClicked();
}
