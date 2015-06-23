package myaplicacion.my_recover_password;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by angel on 28/04/15.
 */
public class OkHttpRequest {

    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    private String url;
    private String json;
    private static int timeout = 10;
    private OkHttpClient client = new OkHttpClient();

    public OkHttpRequest(String url){
        setTimeout();
        this.url = url;
    }

    public Call post(String json,Callback callback) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public Call postNotParams(Callback callback) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public Call getNotParams(Callback callback) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public Call get(String json,Callback callback) throws IOException{
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    private void setTimeout(){
        client.setConnectTimeout(timeout, TimeUnit.SECONDS); // connect timeout
        client.setRetryOnConnectionFailure(true);
        client.setWriteTimeout(timeout,TimeUnit.SECONDS);
        client.setReadTimeout(timeout, TimeUnit.SECONDS);    // socket timeout
    }
}
