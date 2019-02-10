package jp.co.rei.andou.testapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestService {

    @GET("users/{user}/repos")
    Call<ResponseBody> listRepos(@Path("user") String user);

    @GET("http://demo6379364.mockable.io/optional")
    Call<ArrayContainedResponse> getArrayContainedPojo(@Query(value = "array") Integer[] array);

    @GET("http://demo6379364.mockable.io/optional")
    Call<ArrayContainedResponse> getArrayContainedPojo(@Query(value = "array", encoded = true) String array);
}
