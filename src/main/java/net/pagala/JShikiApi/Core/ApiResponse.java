package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.CodeMessage;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;

import static net.pagala.JShikiApi.Core.Shikimori.mapper;

public class ApiResponse<T> implements AutoCloseable {
    private final Response response;
    private final String rawBody;
    private final T body;

    ApiResponse(Response response, Class<T> tClass) throws Exception {
        this.response = response;

        if (response.body() == null || tClass == null) {
            this.body = null;
            this.rawBody = null;
            return;
        }
        this.rawBody = response.body().string();
        if (Shikimori.isShowResponse()) {
            System.out.println(prettyRawBody());
        }
        if (response.isSuccessful()) {
            this.body = mapper.readValue(rawBody, tClass);
        } else {
            this.body = null;
        }
    }

    public int code() {
        return response.code();
    }

    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    public String message() {
        return response.message();
    }

    public Headers headers() {
        return response.headers();
    }

    public T body()  {
        return body;
    }

    public String rawBody() {
        return rawBody;
    }

    public String prettyRawBody() {
        Object node;
        try {
            node = mapper.readValue(rawBody, Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {
        response.close();
    }
}
