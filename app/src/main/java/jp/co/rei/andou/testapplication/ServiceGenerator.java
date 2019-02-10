package jp.co.rei.andou.testapplication;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass/*, final HawkCredentials credentials*/) {
        //if (credentials != null) {
          //  HawkAuthenticationInterceptor interceptor =
            //        new HawkAuthenticationInterceptor(credentials);

            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging);
                httpClient.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        HttpUrl configuredUrl = chain.request()
                                                     .url()
                                                     .newBuilder()
                                                     .addQueryParameter("token", "abcd1234")
                                                     .build();
                        Request configuredRequest = chain.request().newBuilder().url(configuredUrl).build();
                        return chain.proceed(configuredRequest);
                    }
                });

                builder.client(httpClient.build());
                retrofit = builder.build();
            }

        return retrofit.create(serviceClass);
    }
}
