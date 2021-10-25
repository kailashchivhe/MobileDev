package com.kai.midterm.listener;

import java.io.Reader;

public interface GenericRequestListener {
    void onFailure( String message );
    void onSuccess( Reader reader );
}
