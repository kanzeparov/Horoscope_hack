package come.manager.direct.astrology.retrofit;

import come.manager.direct.astrology.pojo.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/horo/{id}")
    public Call<Post> getPostWithID(@Path("id") String id);
}
