package come.manager.direct.astrology.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planet {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_degree")
    @Expose
    private Double fullDegree;
    @SerializedName("norm_degree")
    @Expose
    private Double normDegree;
    @SerializedName("sign_id")
    @Expose
    private Integer signId;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("house")
    @Expose
    private Integer house;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFullDegree() {
        return fullDegree;
    }

    public void setFullDegree(Double fullDegree) {
        this.fullDegree = fullDegree;
    }

    public Double getNormDegree() {
        return normDegree;
    }

    public void setNormDegree(Double normDegree) {
        this.normDegree = normDegree;
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

}