package net.pagala.JShikiApi.Core;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiCall<T> {
    private final Call okHttpCall;
    private final Class<T> tClass;

    ApiCall(Call okHttpCall, Class<T> tClass) {
        this.okHttpCall = okHttpCall;
        this.tClass = tClass;
    }

    public Request request() {
        return okHttpCall.request();
    }

    public ApiResponse<T> execute() throws Exception {
        if (Shikimori.showRequestUrl()) {
            System.out.println("Requested URL: " + okHttpCall.request().url());
        }
        return new ApiResponse<>(okHttpCall.execute(), tClass);
    }

    public void enqueue(ApiCallback<T> responseCallback) {
        if (Shikimori.showRequestUrl()) {
            System.out.println("Requested URL: " + okHttpCall.request().url());
        }
        okHttpCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseCallback.onFailure(new ApiCall<>(okHttpCall, tClass), e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try (ApiResponse<T> apiResponse = new ApiResponse<>(response, tClass)) {
                    responseCallback.onResponse(new ApiCall<>(okHttpCall, tClass), apiResponse);
                } catch (Exception e) {
                    responseCallback.onFailure(new ApiCall<>(okHttpCall, tClass), e);
                }
            }
        });
    }

    public void cancel() {
        okHttpCall.cancel();
    }

    public ApiCall<T> clone() {
        return new ApiCall<>(okHttpCall.clone(), tClass);
    }

    public boolean isExecuted() {
        return okHttpCall.isExecuted();
    }

    public boolean isCanceled() {
        return okHttpCall.isCanceled();
    }
}
