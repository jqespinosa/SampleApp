
package com.espinosa.joey.sampleapplication.api;

import android.content.Context;

import com.espinosa.joey.sampleapplication.utils.Utility;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {
 
    private Context mContext;
 
    public ConnectivityInterceptor(Context context) {
        mContext = context;
    }
 
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!Utility.isOnline(mContext)) {
            throw new NoConnectivityException();
        }
 
        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }
 
}