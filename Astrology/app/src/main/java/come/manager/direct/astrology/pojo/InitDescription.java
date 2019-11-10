package come.manager.direct.astrology.pojo;

import java.util.ArrayList;

public class InitDescription {
    public static ArrayList<Result> resultArrayList = new ArrayList<>();
    public static int[] in = new int[]{30,60,90,120,150,180};
    public static String s = new String();

    public static void initResultPrev(String sNeg, String type) {
        String[] sMasNeg = sNeg.split("\n");
        for(int i = 0; i < sMasNeg.length; i++) {
            if(i %2 == 0) {
                String firstName = sMasNeg[i].substring(0, sMasNeg[i].indexOf("("));
                String desc = sMasNeg[i].substring(sMasNeg[i].indexOf("(") + 1, sMasNeg[i].lastIndexOf(")"));
                Result result = new Result();
                result.setType(type);
                result.setNameFirst(firstName);
                result.setNameSecond("");
                result.setDescription(desc);
                resultArrayList.add(result);
            }
        }
    }

  

    public static void main(String[] args) {
        int status = 31;
        //initResult();
        for(int i = 0; i < resultArrayList.size(); i++) {
            System.out.println(i + " " + resultArrayList.get(i).appropStatus(status));
        }
       float countNeg = 0;
        float countNet = 0;
        float countPos = 0;


        for (int i = 0; i < resultArrayList.size(); i++) {
            if(resultArrayList.get(i).getType().equals("NEG") && resultArrayList.get(i).appropStatus(status)) {
                countNeg++;
            }
            if(resultArrayList.get(i).getType().equals("NET") && resultArrayList.get(i).appropStatus(status)) {
                countNet++;
            }
            if(resultArrayList.get(i).getType().equals("POS") && resultArrayList.get(i).appropStatus(status)) {
                countPos++;
            }
        }

        System.out.println(countNeg);
        System.out.println(countNet);
        System.out.println(countPos);
    }
}
