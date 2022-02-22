package service.impl;


import java.io.IOException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Builder
@Getter
public class BasicAuthApiClient {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
  private final String user;
  private final String password;
  private final String url;
  private static final TrustManager X_509_TRUST_MANAGER = new X509TrustManager() {
    @Override
    public void checkClientTrusted(
        X509Certificate[] chain,
        String authType
    ) {
    }

    @Override
    public void checkServerTrusted(
        X509Certificate[] chain,
        String authType
    ) {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[]{};
    }
  };

  public <T> T sendGet(
      final String uri,
      final Class<T> clazz
  ) throws Exception {
    final Request.Builder requestBuilder = prepareRequestBuilder(uri);
    return this.sendRequest(requestBuilder, clazz);
  }

  public <T> T sendPost(
      final String uri,
      final Object data,
      final Class<T> clazz
  ) throws Exception {
    final Request.Builder requestBuilder = prepareRequestBuilder(uri);
    if (data != null) {
      final RequestBody requestBody = RequestBody
          .create(MediaType.parse("application/json"), OBJECT_MAPPER.writeValueAsString(data));
      requestBuilder.post(requestBody);
    } else {
      requestBuilder.post(RequestBody.create(null, ""));
    }

    return this.sendRequest(requestBuilder, clazz);
  }

  public <T> T sendPut(
      final String uri,
      final String data
  ) throws Exception {
    final Request.Builder requestBuilder = prepareConfigRequestBuilder(uri);
    if (data != null) {
      final RequestBody requestBody = RequestBody
          .create(MediaType.parse("application/json"), data);
      requestBuilder.put(requestBody);
    } else {
      requestBuilder.put(RequestBody.create(null, ""));
    }

    return this.sendRequest(requestBuilder);
  }

  public <T> T sendDelete(
      final String uri
  ) throws Exception {
    final Request.Builder requestBuilder = prepareConfigRequestBuilder(uri);
    requestBuilder.delete();
    return this.sendRequest(requestBuilder);
  }

  private Request.Builder prepareRequestBuilder(final String uri) throws IOException {
    final String auth = new String(Base64.getEncoder().encode((this.user + ":" + this.password).getBytes()));
    return new Request.Builder()
        .url(new URL(this.url + uri))
        .header("Content-Type", "application/json")
        .header("Authorization", "Basic " + auth);
  }

  private Request.Builder prepareConfigRequestBuilder(final String uri) throws IOException {
    return new Request.Builder()
        .url(new URL(uri))
        .header("Content-Type", "application/json");
  }

  private <T> T sendRequest(
      final Request.Builder requestBuilder,
      final Class<T> clazz
  ) throws Exception {
    try (Response response = new OkHttpClient().newCall(requestBuilder.build()).execute()) {
      if (response.isSuccessful()) {
        final ResponseBody body = response.body();
        if (body != null) {
          return OBJECT_MAPPER.readValue(body.string(), clazz);
        }
        return null;
      }
      throw new RuntimeException("Response status from TestRail is not equal 2XX code =" + response.code());
    }
  }

  private <T> T sendRequest(
      final Request.Builder requestBuilder
  ) throws Exception {
    SSLContext sslContext = SSLContext.getInstance("SSL");
    sslContext.init(null, new TrustManager[]{X_509_TRUST_MANAGER}, new java.security.SecureRandom());
    try (Response response = okHttpClient
        .hostnameVerifier((hostname, session) -> true)
        .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) X_509_TRUST_MANAGER)
        .build()
        .newCall(requestBuilder.build())
        .execute()) {
      if (response.code() == 204) {
        return null;
      }
      throw new RuntimeException("Response status from broker-service is not equal 204 code =" + response.code());
    }
  }
}
