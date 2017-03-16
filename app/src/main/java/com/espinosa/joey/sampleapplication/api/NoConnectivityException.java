package com.espinosa.joey.sampleapplication.api;

import java.io.IOException;

public class NoConnectivityException extends IOException {
 
    @Override
    public String getMessage() {
        return "Please check your internet connection";
    }
 
}