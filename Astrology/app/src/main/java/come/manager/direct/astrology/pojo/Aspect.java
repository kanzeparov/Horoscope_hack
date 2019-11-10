package come.manager.direct.astrology.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aspect {

    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("second")
    @Expose
    private String second;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("orb")
    @Expose
    private Double orb;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getOrb() {
        return orb;
    }

    public void setOrb(Double orb) {
        this.orb = orb;
    }

}