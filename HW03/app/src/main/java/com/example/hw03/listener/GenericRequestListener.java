package com.example.hw03.listener;

import java.io.Reader;

public interface GenericRequestListener {
    void onFailure( String message );
    void onSuccess( Reader reader );
}
