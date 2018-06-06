package dmi.pmf.novica.mvparchitect.twitch;

import dagger.Module;
import dagger.Provides;
import dmi.pmf.novica.mvparchitect.root.ActivityScope;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TwitchModule {

    public final String BASE_URL = "https://api.twitch.tv/kraken/";

    @Provides
    @ActivityScope
    public OkHttpClient provideClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public TwitchAPI provideApi(){
        return provideRetrofit(BASE_URL, provideClient()).create(TwitchAPI.class);
    }

}
