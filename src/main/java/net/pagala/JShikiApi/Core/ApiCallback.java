package net.pagala.JShikiApi.Core;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

public interface ApiCallback<T> {
    void onFailure(ApiCall<T> call, Throwable t);
    void onResponse(ApiCall<T> call, ApiResponse<T> response);
}
