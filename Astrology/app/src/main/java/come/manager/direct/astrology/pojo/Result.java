package come.manager.direct.astrology.pojo;

public class Result {
    private String type;
    private String nameFirst;
    private String nameSecond;
    private String description;
    private int start;
    private int widthStart;
    private int[] angles;
    private int anglesWidth;

    public Result(){}

    public Result(String type, String nameFirst, String nameSecond, String description, int start, int widthStart, int[] angles, int anglesWidth) {
        this.type = type;
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.description = description;
        this.start = start;
        this.widthStart = widthStart;
        this.angles = angles;
        this.anglesWidth = anglesWidth;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getWidthStart() {
        return widthStart;
    }

    public void setWidthStart(int widthStart) {
        this.widthStart = widthStart;
    }

    public int[] getAngles() {
        return angles;
    }

    public void setAngles(int[] angles) {
        this.angles = angles;
    }

    public int getAnglesWidth() {
        return anglesWidth;
    }

    public void setAnglesWidth(int anglesWidth) {
        this.anglesWidth = anglesWidth;
    }

    public boolean appropStatus(int value) {
        if(angles != null) {
            for (int i = 0; i < angles.length; i++) {
                if (Math.abs(angles[i] - value) <= anglesWidth) {
                    return true;
                }
            }
        }


        if(start!= 0) {
            if(value % start <= widthStart && value % start >= widthStart)
            return true;
        } else if(value <= widthStart && value >= -widthStart) {
            return true;
        }

        return false;
    }
}
