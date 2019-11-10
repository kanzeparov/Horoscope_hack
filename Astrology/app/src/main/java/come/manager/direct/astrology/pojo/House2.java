package come.manager.direct.astrology.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class House2 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("synastry_house")
    @Expose
    private Integer synastryHouse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSynastryHouse() {
        return synastryHouse;
    }

    public void setSynastryHouse(Integer synastryHouse) {
        this.synastryHouse = synastryHouse;
    }

}