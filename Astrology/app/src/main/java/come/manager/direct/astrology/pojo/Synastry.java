package come.manager.direct.astrology.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Synastry {

    @SerializedName("house_1")
    @Expose
    private List<House1> house1 = null;
    @SerializedName("house_2")
    @Expose
    private List<House2> house2 = null;
    @SerializedName("aspects")
    @Expose
    private List<Aspect> aspects = null;

    public List<House1> getHouse1() {
        return house1;
    }

    public void setHouse1(List<House1> house1) {
        this.house1 = house1;
    }

    public List<House2> getHouse2() {
        return house2;
    }

    public void setHouse2(List<House2> house2) {
        this.house2 = house2;
    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public void setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
    }

}