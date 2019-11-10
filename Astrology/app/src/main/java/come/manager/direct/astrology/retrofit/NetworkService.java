//package come.manager.direct.astrology.retrofit;
//
//import retrofit2.Retrofit;
//
//public class NetworkService {
//    private static NetworkService mInstance;
//    private static final String BASE_URL = "http://34.87.49.51/hero/";
//    private Retrofit mRetrofit;
//
//    private NetworkService() {
//        mRetrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .build();
//    }
//
//    public static NetworkService getInstance() {
//        if (mInstance == null) {
//            mInstance = new NetworkService();
//        }
//        return mInstance;
//    }
//
//    public JSONPlaceHolderApi getJSONApi() {
//        return mRetrofit.create(JSONPlaceHolderApi.class);
//    }
//}