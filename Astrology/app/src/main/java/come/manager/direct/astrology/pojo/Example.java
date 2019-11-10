package come.manager.direct.astrology.pojo;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("first")
    @Expose
    private List<First> first = null;
    @SerializedName("second")
    @Expose
    private List<Second> second = null;
    @SerializedName("synastry")
    @Expose
    private Synastry synastry;

    public List<First> getFirst() {
        return first;
    }

    public void setFirst(List<First> first) {
        this.first = first;
    }

    public List<Second> getSecond() {
        return second;
    }

    public void setSecond(List<Second> second) {
        this.second = second;
    }

    public Synastry getSynastry() {
        return synastry;
    }

    public void setSynastry(Synastry synastry) {
        this.synastry = synastry;
    }

}