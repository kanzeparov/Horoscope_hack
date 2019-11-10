package come.manager.direct.astrology.pojo;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Composite {

    @SerializedName("planets")
    @Expose
    private List<Planet> planets = null;
    @SerializedName("houses")
    @Expose
    private List<House> houses = null;
    @SerializedName("ascendant")
    @Expose
    private Double ascendant;
    @SerializedName("midheaven")
    @Expose
    private Double midheaven;
    @SerializedName("aspects")
    @Expose
    private List<Aspect> aspects = null;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public Double getAscendant() {
        return ascendant;
    }

    public void setAscendant(Double ascendant) {
        this.ascendant = ascendant;
    }

    public Double getMidheaven() {
        return midheaven;
    }

    public void setMidheaven(Double midheaven) {
        this.midheaven = midheaven;
    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public void setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
    }

}