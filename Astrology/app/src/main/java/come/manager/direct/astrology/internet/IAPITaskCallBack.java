package come.manager.direct.astrology.internet;
/**
 * Created by Ashwani Janghu on 9/1/2015.
 */
public interface IAPITaskCallBack {

    void onSuccess(String response);
    void onFailure(String error);
}
