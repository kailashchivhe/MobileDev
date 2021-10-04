package com.kai.inclass07.listeners;

import java.io.Reader;

public interface GenericRequestListener {
    void onFailure( String message );
    void onSuccess( Reader reader );
}
