package jp.co.rei.andou.testapplication;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = ServiceGenerator.createService(RestService.class);
        service.listRepos("Tameshiya")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        makeAnotherRequestSynchronously();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

    }

    private void makeAnotherRequestSynchronously() {
        service.getArrayContainedPojo(Arrays.toString(new Integer[]{1, 2, 3, 4, 5})).enqueue(new Callback<ArrayContainedResponse>() {
            @Override
            public void onResponse(Call<ArrayContainedResponse> call, Response<ArrayContainedResponse> response) {
                Toast.makeText(MainActivity.this, response.body().someEnumValue.name(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayContainedResponse> call, Throwable t) {

            }
        });
    }
}
