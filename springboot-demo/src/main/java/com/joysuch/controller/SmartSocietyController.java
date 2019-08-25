package com.joysuch.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import com.joysuch.entity.AverageUsage;
import com.joysuch.entity.AverageUsageGuest;
//import com.joysuch.entity.Prediction;
import com.joysuch.entity.Prediction;
import com.joysuch.entity.RealTimeUsage;
import com.joysuch.mapper.AverageUsageGuestMapper;
import com.joysuch.mapper.AverageUsageMapper;
//import com.joysuch.mapper.PredictionMapper;
import com.joysuch.mapper.PredictionMapper;
import com.joysuch.mapper.RealTimeUsageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class SmartSocietyController {


    @Autowired
    private AverageUsageGuestMapper averageUsageGuestMapper;

    @Autowired
    private AverageUsageMapper averageUsageMapper;

    @Autowired
    private RealTimeUsageMapper realTimeUsageMapper;

    @Autowired
    private PredictionMapper predictionMapper;

    @RequestMapping("/smartSociety/a")
    @ResponseBody
    public String test1(HttpServletRequest request) {

        String name = request.getParameter("name");


        System.out.println("!" + name + "!");
        ArrayList<RealTimeUsage> realTimeUsage = realTimeUsageMapper.queryAll();



        String id = "";
        String creditLevel = "";
        ArrayList<AverageUsageGuest> averageUsageGuest = averageUsageGuestMapper.queryAll();
        for (int i = 0; i < averageUsageGuest.size(); i++) {
            if(name.equals(averageUsageGuest.get(i).getPname().trim())){
                Double a = averageUsageGuest.get(i).getConsumption() + averageUsageGuest.get(i).getBalance();
                creditLevel = String.valueOf(a);
                System.out.println(a);
                id = averageUsageGuest.get(i).getId();
            }

        }

        String energyConsumption = "";
        ArrayList<AverageUsage> averageUsage = averageUsageMapper.queryAll();
        for (int i = 0; i < averageUsage.size(); i++) {
            if(averageUsage.get(i).getId() == id){
                System.out.println(averageUsage.get(i).getGas() + averageUsage.get(i).getWater() + averageUsage.get(i).getPower());
//                energyConsumption = String.valueOf(averageUsage.get(i).getGas() + averageUsage.get(i).getWater() + averageUsage.get(i).getPower());
//                energyConsumption = Double.toString(averageUsage.get(i).getGas() + averageUsage.get(i).getWater() + averageUsage.get(i).getPower());
                energyConsumption = averageUsage.get(i).getGas() + averageUsage.get(i).getWater() + averageUsage.get(i).getPower() + "";

                System.out.println(energyConsumption);
            }
        }


        String diffculty = "";
        ArrayList<Prediction> prediction = predictionMapper.queryAll();
        for (int i = 0; i < prediction.size(); i++) {
            if(prediction.get(i).getId() == id){
                diffculty = String.valueOf(prediction.get(i).getIspoorprob());
            }
        }





        JsonObject josnobj1 = new JsonObject();

        josnobj1.addProperty("diffculty",diffculty);

        josnobj1.addProperty("creditLevel",creditLevel);

        josnobj1.addProperty("energyConsumption",energyConsumption);

        return josnobj1.toString();



    }



    @RequestMapping("/smartSociety/b")
    @ResponseBody
    public String test2(HttpServletRequest request) {


        String name = request.getParameter("name");

        String id = "";
        String energyConsumption = "";
        ArrayList<AverageUsage> averageUsage = averageUsageMapper.queryAll();
        for (int i = 0; i < averageUsage.size(); i++) {
            if(averageUsage.get(i).getPname().trim().equals(name) ){
                energyConsumption = String.valueOf(averageUsage.get(i).getGas() + averageUsage.get(i).getWater() + averageUsage.get(i).getPower());
                id = averageUsage.get(i).getId();
            }
        }


        String diffculty = "";
        ArrayList<Prediction> prediction = predictionMapper.queryAll();
        for (int i = 0; i < prediction.size(); i++) {
            if(prediction.get(i).getId() == id){
                diffculty = String.valueOf(prediction.get(i).getIspoorprob());
            }
        }


        String riskLevel = "";








        JsonObject josnobj1 = new JsonObject();
        josnobj1.addProperty("diffculty",diffculty);
        josnobj1.addProperty("energyConsumption",energyConsumption);
        josnobj1.addProperty("riskLevel",riskLevel);





        return josnobj1.toString();


    }


    @RequestMapping("/smartSociety/c")
    @ResponseBody
    public String test3(HttpServletRequest request) {

        String name = request.getParameter("name");


        String id = "";
        String creditLevel = "";
        ArrayList<AverageUsageGuest> averageUsageGuest = averageUsageGuestMapper.queryAll();
        for (int i = 0; i < averageUsageGuest.size(); i++) {
            if(name.equals(averageUsageGuest.get(i).getPname().trim())){
                Double a = averageUsageGuest.get(i).getConsumption() + averageUsageGuest.get(i).getBalance();
                creditLevel = String.valueOf(a);
                id = averageUsageGuest.get(i).getId();
            }

        }


        String diffculty = "";
        ArrayList<Prediction> prediction = predictionMapper.queryAll();
        for (int i = 0; i < prediction.size(); i++) {
            if(prediction.get(i).getId() == id){
                diffculty = String.valueOf(prediction.get(i).getIspoorprob());
            }
        }


        JsonObject josnobj1 = new JsonObject();
        josnobj1.addProperty("diffculty",diffculty);
        josnobj1.addProperty("creditLevel",creditLevel);


        return josnobj1.toString();



    }



    @RequestMapping("/smartSociety/d")
    @ResponseBody
    public String test4(HttpServletRequest request) {

        String name = request.getParameter("name");


        int a[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};

        Double b[] = new Double[]{0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};

        Double c[] = new Double[]{0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};


        ArrayList<RealTimeUsage> realTimeUsage = realTimeUsageMapper.queryAll();

        for (int i = 0; i < realTimeUsage.size(); i++) {
            Integer time = Integer.valueOf(realTimeUsage.get(i).getTimeperiod());
            if(time == 0){
                b[0] += realTimeUsage.get(i).getIshome();
                c[0] += 1;
            }else if(time == 1){
                b[1] += realTimeUsage.get(i).getIshome();
                c[1] += 1;
            }else if(time == 2){
                b[2] += realTimeUsage.get(i).getIshome();
                c[2] += 1;
            }else if(time == 3){
                b[3] += realTimeUsage.get(i).getIshome();
                c[3] += 1;
            }else if(time == 4){
                b[4] += realTimeUsage.get(i).getIshome();
                c[4] += 1;
            }else if(time == 5){
                b[5] += realTimeUsage.get(i).getIshome();
                c[5] += 1;
            }else if(time == 6){
                b[6] += realTimeUsage.get(i).getIshome();
                c[6] += 1;
            }else if(time == 7){
                b[7] += realTimeUsage.get(i).getIshome();
                c[7] += 1;
            }else if(time == 8){
                b[8] += realTimeUsage.get(i).getIshome();
                c[8] += 1;
            }else if(time == 9){
                b[9] += realTimeUsage.get(i).getIshome();
                c[9] += 1;
            }else if(time == 10){
                b[10] += realTimeUsage.get(i).getIshome();
                c[10] += 1;
            }else if(time == 11){
                b[11] += realTimeUsage.get(i).getIshome();
                c[11] += 1;
            }else if(time == 12){
                b[12] += realTimeUsage.get(i).getIshome();
                c[12] += 1;
            }else if(time == 13){
                b[13] += realTimeUsage.get(i).getIshome();
                c[13] += 1;
            }else if(time == 14){
                b[14] += realTimeUsage.get(i).getIshome();
                c[14] += 1;
            }else if(time == 15){
                b[15] += realTimeUsage.get(i).getIshome();
                c[15] += 1;
            }else if(time == 16){
                b[16] += realTimeUsage.get(i).getIshome();
                c[16] += 1;
            }else if(time == 17){
                b[17] += realTimeUsage.get(i).getIshome();
                c[17] += 1;
            }else if(time == 18){
                b[18] += realTimeUsage.get(i).getIshome();
                c[18] += 1;
            }else if(time == 19){
                b[19] += realTimeUsage.get(i).getIshome();
                c[19] += 1;
            }else if(time == 20){
                b[20] += realTimeUsage.get(i).getIshome();
                c[20] += 1;
            }else if(time == 21){
                b[21] += realTimeUsage.get(i).getIshome();
                c[21] += 1;
            }else if(time == 22){
                b[22] += realTimeUsage.get(i).getIshome();
                c[22] += 1;
            }else if(time == 23){
                b[23] += realTimeUsage.get(i).getIshome();
                c[23] += 1;
            }

        }





//        for (int i = 0; i < 24; i++) {
//            System.out.println(b[i]);
//        }
//        for (int i = 0; i < 24; i++) {
//            System.out.println(c[i]);
//        }


        for (int i = 0; i < 24; i++) {
            b[i] = b[i] / c[i] * 100;
        }


        JsonObject josnobj = new JsonObject();
        JsonArray array1 = new JsonArray();
        JsonArray array2 = new JsonArray();
        for (int i = 0; i < a.length; i++) {
            array1.add(a[i]);
            Double f = b[i];
            String string = String.valueOf(f);
            String string1 = string.split("\\.")[0];
            int result  = Integer.valueOf(string1);
            array2.add(result);
        }



        josnobj.addProperty("dataAxis",array1.toString());
        josnobj.addProperty("dataYaxis",array2.toString());


        return josnobj.toString();



    }

    @RequestMapping("/smartSociety/e")
    @ResponseBody
    public String test5(HttpServletRequest request) {

        String name = request.getParameter("name");


        int a[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};

        Double b[] = new Double[]{0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};

        ArrayList<RealTimeUsage> realTimeUsage = realTimeUsageMapper.queryAll();

        for (int i = 0; i < realTimeUsage.size(); i++) {
            Integer time = Integer.valueOf(realTimeUsage.get(i).getTimeperiod());
            if(time == 0){
                b[0] += realTimeUsage.get(i).getPower();
            }else if(time == 1){
                b[1] += realTimeUsage.get(i).getPower();
            }else if(time == 2){
                b[2] += realTimeUsage.get(i).getPower();
            }else if(time == 3){
                b[3] += realTimeUsage.get(i).getPower();
            }else if(time == 4){
                b[4] += realTimeUsage.get(i).getPower();
            }else if(time == 5){
                b[5] += realTimeUsage.get(i).getPower();
            }else if(time == 6){
                b[6] += realTimeUsage.get(i).getPower();
            }else if(time == 7){
                b[7] += realTimeUsage.get(i).getPower();
            }else if(time == 8){
                b[8] += realTimeUsage.get(i).getPower();
            }else if(time == 9){
                b[9] += realTimeUsage.get(i).getPower();
            }else if(time == 10){
                b[10] += realTimeUsage.get(i).getPower();
            }else if(time == 11){
                b[11] += realTimeUsage.get(i).getPower();
            }else if(time == 12){
                b[12] += realTimeUsage.get(i).getPower();
            }else if(time == 13){
                b[13] += realTimeUsage.get(i).getPower();
            }else if(time == 14){
                b[14] += realTimeUsage.get(i).getPower();
            }else if(time == 15){
                b[15] += realTimeUsage.get(i).getPower();
            }else if(time == 16){
                b[16] += realTimeUsage.get(i).getPower();
            }else if(time == 17){
                b[17] += realTimeUsage.get(i).getPower();
            }else if(time == 18){
                b[18] += realTimeUsage.get(i).getPower();
            }else if(time == 19){
                b[19] += realTimeUsage.get(i).getPower();
            }else if(time == 20){
                b[20] += realTimeUsage.get(i).getPower();
            }else if(time == 21){
                b[21] += realTimeUsage.get(i).getPower();
            }else if(time == 22){
                b[22] += realTimeUsage.get(i).getPower();
            }else if(time == 23){
                b[23] += realTimeUsage.get(i).getPower();
            }


        }



        JsonObject josnobj = new JsonObject();
        JsonArray array1 = new JsonArray();
        JsonArray array2 = new JsonArray();
        for (int i = 0; i < a.length; i++) {
            array1.add(a[i]);
            Double c = b[i];
            String string = String.valueOf(c);
            String string1 = string.split("\\.")[0];
            int result  = Integer.valueOf(string1);
            array2.add(result);
        }



        josnobj.addProperty("dataAxis",array1.toString());
        josnobj.addProperty("dataYaxis",array2.toString());


        return josnobj.toString();



    }

}
