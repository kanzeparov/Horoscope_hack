package come.manager.direct.astrology.pojo;

import java.util.ArrayList;

public class InitDescription {
    public static ArrayList<Result> resultArrayList = new ArrayList<>();
    public static int[] in = new int[]{30,60,90,120,150,180};

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

    public static void initResult() {
        String sNeg =
                "Солнце в соединении с СУ(мужчина чувствует себя обделенным, какими бы ни были чувства с обеих сторон, он не сможет почувствовать себя счастливым)\n" +
                "\n" +
                "Марс в соединении с Су(девушка не видит в парне мужчину, и это независимо от его личных объективных качеств)\n" +
                "\n" +
                "Луна в соединении с Северным Узлом(девушка не получит полного женского счастья, будет обделена, лучше не биться в закрытые двери-забыть его)\n" +
                "\n" +
                "Венера в соединении с Северным Узлом(девушка нежеланна и не любима по настоящему, мужчина будет смотреть налево независимо от ее достоинств)\n" +
                "\n" +
                "Марс в Весах(фатально для мужчины, каким бы он ни был, женщина не сможет относиться к нему серьезно,будет пренебрегать им(или ему просто будет так казаться))\n" +
                "\n" +
                "Аспект Меркурий-Лилит(классический случай из мелодрамы-как бы ни старались двое быть вместе-все против них, даже близкие люди строят козни)\n" +
                "\n" +
                "Квадрат Солнце-Сатурн(в парах с таким аспектом мужчина часто обманывает женщину, нечестен с ней)\n" +
                "\n" +
                "Квадрат Марс-Сатурн(у мужчины проблемы с моральными принципами, может параллельно быть связан несколькими обязательствами, не видит в этом ничего плохого)";

        String sPos = "Солнце-Луна(аспект имеет первостепенное значение,реальные претенденты на звание мужа и жены, когда двое не просто любят друг друга, но готовы трудиться для развития отношений, дает ощущение спокойствия и постоянства)\n" +
                "\n" +
                "Луна-Марс(аспект африканских страстей, непреодолимое влечение друг к другу, часто любовь с первого взгляда)\n" +
                "\n" +
                "Солнце-Нептун(дает мужчине неземное счастье, любовь,которую трудно пересказать словами, настоящая, та о которой пишут в книгах)\n" +
                "\n" +
                "Луна-Нептун(женщина очень счастлива рядом с этим мужчиной, растворяется в нем, настоящая любовь как она есть)\n" +
                "\n" +
                "Марс-Нептун(дает мужчине неземное счастье, любовь,которую трудно пересказать словами, настоящая, та о которой пишут в книгах)\n" +
                "\n" +
                "Венера-Нептун(женщина очень счастлива рядом с этим мужчиной, растворяется в нем, настоящая любовь как она есть)\n" +
                "\n" +
                "Солнце-Марс(девушка чувствует ,что нашла своего героя,восхищается им,парень ощущает в себе силы быть таким,по мужски очень счастлив рядом этой женщиной)\n" +
                "\n" +
                "Луна-Венера(один из лучших аспектов,пробуждает в женщине чувственность, мужчина обожает эту женщину, как бы ни сложились отношения, двое никогда не забудут друг друга)";
        String sNet = "Венера-Марс(двое подходят друг другу, существует взаимная симпатия, которая способна просуществовать очень долго при счастливом стечении обстоятельств)\n" +
                "\n" +
                "Марс-Плутон(женщине трудно устоять перед магнетизмом мужчины, но это не любовь,это наваждение,мужчина ревнует, хочет все контролировать,трудный аспект для долгосрочных отношений)\n" +
                "\n" +
                "Солнце-Плутон(отношения как контрастный душ,водоворот страстей, мужчина властный и ревнивый, может преследовать женщину)\n" +
                "\n" +
                "Луна-Плутон(женщина как клещ вцепляется в мужчину, не представляет без него своего существования, часто это тяжелая зависимость, которая сопровождается преследованием и разборками)\n" +
                "\n" +
                "Венера-Плутон(женщина чувствует сильнейшее притяжение к мужчине, стремится контролировать его жизнь, мучается сама и мучает его)\n" +
                "\n" +
                "Солнце-Юпитер(мужчина уверен,что сделал правильный выбор, уверен,что ему нужны эти отношения)\n" +
                "\n" +
                "Марс-Юпитер(мужчина не сомневается в правильности своего выбора, стремится продолжать и развивать отношения)\n" +
                "\n" +
                "Луна-Юпитер(женщина довольна своим выбором,уверена что это именно тот человек, который сделает ее счастливой)\n" +
                "\n" +
                "Венера-Юпитер(женщина строит планы в отношении мужчины, не сомневается в правильности своего выбора)\n" +
                "\n" +
                "Солнце-Лилит(на начальном этапе все супер,мужчина притягателен и сексуален, но потом его ревность и собственнические чувства достигнут невероятных размеров, делая жизнь невыносимой)\n" +
                "\n" +
                "Марс-Лилит(на начальном этапе все супер,мужчина притягателен и сексуален, но потом его ревность и собственнические чувства достигнут невероятных размеров, делая жизнь невыносимой)\n" +
                "\n" +
                "Луна-Лилит(женщина-вамп,пьющая жизнь,смелая и притягательная в начале,впоследствии начинает ревновать мужчину даже к столбу)\n" +
                "\n" +
                "Венера-Лилит(женщина-вамп,пьющая жизнь,смелая и притягательная в начале,впоследствии начинает ревновать мужчину даже к столбу)\n" +
                "\n" +
                "Солнце-Селена(мужчина мягок и уступчив,готов жертвовать многим ради отношений)\n" +
                "\n" +
                "Марс-Селена(мужчина мягок и уступчив,готов жертвовать многим ради отношений)\n" +
                "\n" +
                "Луны-Селена(женщина мягкая и послушная,светлая, жертвенная)\n" +
                "\n" +
                "Венера-Селена(женщина мягкая и послушная,светлая, жертвенная)";


        initResultPrev(sNeg,"NEG");
        initResultPrev(sPos,"POS");
        initResultPrev(sNet,"NET");

        for(int i = 0; i < resultArrayList.size(); i++) {
            switch (i){
                case 0:
                case 1:
                case 2:
                case 3:
                    resultArrayList.get(i).setStart(0);
                    resultArrayList.get(i).setWidthStart(5);
                    break;
                case 4:
                case 5:
                    resultArrayList.get(i).setStart(0);
                    resultArrayList.get(i).setWidthStart(2);
                    resultArrayList.get(i).setAngles(in);
                    resultArrayList.get(i).setAnglesWidth(2);
                    break;
                case 6:
                case 7:
                    resultArrayList.get(i).setStart(90);
                    resultArrayList.get(i).setWidthStart(2);
                    break;
                case 8:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                    resultArrayList.get(i).setStart(0);
                    resultArrayList.get(i).setWidthStart(7);
                    resultArrayList.get(i).setAngles(in);
                    resultArrayList.get(i).setAnglesWidth(2);
                    break;
                case 10:
                case 13:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    resultArrayList.get(i).setStart(0);
                    resultArrayList.get(i).setWidthStart(5);
                    resultArrayList.get(i).setAngles(in);
                    resultArrayList.get(i).setAnglesWidth(2);
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                    resultArrayList.get(i).setStart(0);
                    resultArrayList.get(i).setWidthStart(2);
                    resultArrayList.get(i).setAngles(in);
                    resultArrayList.get(i).setAnglesWidth(2);
                    break;

            }
        }
    }

    public static void main(String[] args) {
        int status = 31;
        initResult();
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
