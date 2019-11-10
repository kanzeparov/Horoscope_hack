package come.manager.direct.astrology.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class House {

    @SerializedName("house")
    @Expose
    private Integer house;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("degree")
    @Expose
    private Double degree;

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

}