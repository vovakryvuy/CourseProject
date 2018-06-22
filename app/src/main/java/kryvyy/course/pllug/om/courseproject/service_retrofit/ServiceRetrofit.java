package kryvyy.course.pllug.om.courseproject.service_retrofit;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vovak on 02.06.2018.
 */

public class ServiceRetrofit {
    private final static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static final ServiceRetrofit ourInstance = new ServiceRetrofit();
    private static InterfaceResponse mInterfaceResponse;
    private Retrofit mRetrofit;
    private OkHttpClient.Builder mClient;

    private ServiceRetrofit() {
        initHttpLogging();
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(mClient.build())
                .build();
        mInterfaceResponse = mRetrofit.create(InterfaceResponse.class);
    }

    public static ServiceRetrofit getInstance() {
        return ourInstance;
    }

    public static InterfaceResponse getInterfaceResponse() {
        return mInterfaceResponse;
    }

    private void initHttpLogging() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mClient = new OkHttpClient.Builder();
        mClient.addInterceptor(loggingInterceptor);
    }
}
