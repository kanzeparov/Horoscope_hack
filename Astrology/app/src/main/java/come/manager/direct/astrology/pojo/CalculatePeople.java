package come.manager.direct.astrology.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatePeople implements Parcelable{
    public String getDayFirst() {
        return dayFirst;
    }

    public void setDayFirst(String dayFirst) {
        this.dayFirst = dayFirst;
    }

    public String getDaySecond() {
        return daySecond;
    }

    public void setDaySecond(String daySecond) {
        this.daySecond = daySecond;
    }

    public String getMonthFirst() {
        return monthFirst;
    }

    public void setMonthFirst(String monthFirst) {
        this.monthFirst = monthFirst;
    }

    public String getMonthSecond() {
        return monthSecond;
    }

    public void setMonthSecond(String monthSecond) {
        this.monthSecond = monthSecond;
    }

    public String getYearFirst() {
        return yearFirst;
    }

    public void setYearFirst(String yearFirst) {
        this.yearFirst = yearFirst;
    }

    public String getYearSecond() {
        return yearSecond;
    }

    public void setYearSecond(String yearSecond) {
        this.yearSecond = yearSecond;
    }

    public String getHourFirst() {
        return hourFirst;
    }

    public void setHourFirst(String hourFirst) {
        this.hourFirst = hourFirst;
    }

    public String getHourSecond() {
        return hourSecond;
    }

    public void setHourSecond(String hourSecond) {
        this.hourSecond = hourSecond;
    }

    public String getMinuteFirst() {
        return minuteFirst;
    }

    public void setMinuteFirst(String minuteFirst) {
        this.minuteFirst = minuteFirst;
    }

    public String getMinuteSecond() {
        return minuteSecond;
    }

    public void setMinuteSecond(String minuteSecond) {
        this.minuteSecond = minuteSecond;
    }

    public String getCityFirst() {
        return cityFirst;
    }

    public void setCityFirst(String cityFirst) {
        this.cityFirst = cityFirst;
    }

    public String getCitySecond() {
        return citySecond;
    }

    public void setCitySecond(String citySecond) {
        this.citySecond = citySecond;
    }

    private String dayFirst;
    private String daySecond;
    private String monthFirst;
    private String monthSecond;
    private String yearFirst;
    private String yearSecond;
    private String hourFirst;
    private String hourSecond;
    private String minuteFirst;

    public CalculatePeople(String dayFirst, String daySecond, String monthFirst, String monthSecond, String yearFirst, String yearSecond,
            String hourFirst, String hourSecond, String minuteFirst, String minuteSecond, String cityFirst, String citySecond) {
        this.dayFirst = dayFirst;
        this.daySecond = daySecond;
        this.monthFirst = monthFirst;
        this.monthSecond = monthSecond;
        this.yearFirst = yearFirst;
        this.yearSecond = yearSecond;
        this.hourFirst = hourFirst;
        this.hourSecond = hourSecond;
        this.minuteFirst = minuteFirst;
        this.minuteSecond = minuteSecond;
        this.cityFirst = cityFirst;
        this.citySecond = citySecond;
    }

    public CalculatePeople(Parcel in) {
        String[] data = new String[12];
        in.readStringArray(data);
        this.dayFirst = data[0];
        this.daySecond = data[1];
        this.monthFirst = data[2];
        this.monthSecond = data[3];
        this.yearFirst = data[4];
        this.yearSecond =data[5];
        this.hourFirst = data[6];
        this.hourSecond = data[7];
        this.minuteFirst = data[8];
        this.minuteSecond = data[9];
        this.cityFirst = data[10];
        this.citySecond = data[11];
    }

    public CalculatePeople(){}


    private String minuteSecond;
    private String cityFirst;
    private String citySecond;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { dayFirst,daySecond,monthFirst,monthSecond,yearFirst,yearSecond,hourFirst,
                hourSecond,minuteFirst,minuteSecond,cityFirst,citySecond});
    }

    public static final Parcelable.Creator<CalculatePeople> CREATOR = new Parcelable.Creator<CalculatePeople>() {

        @Override
        public CalculatePeople createFromParcel(Parcel source) {
            return new CalculatePeople(source);
        }

        @Override
        public CalculatePeople[] newArray(int size) {
            return new CalculatePeople[size];
        }
    };
}
