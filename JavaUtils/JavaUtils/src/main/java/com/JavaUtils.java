package com;

import com.utils.CommonReturnType;
import com.utils.TimeUtils;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.utils.SUtils.isInteger;

public class JavaUtils {
    /**
     * 获取 当前年、半年、季度、月、日、小时 开始结束时间
     */

    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;

    public static void main(String[] args) throws ParseException {
//        JavaFuncTest jft = new JavaFuncTest();
//        String s = "t5";
//        boolean b = jft.testE(s);
//        System.out.println(b);
        String s = "{\n" +
                "\t\"tt\":\"c\",\n" +
                "\t\"ll\":12,\n" +
                "\t\"islong\":false\n" +
                "}";
        try {
            JSONObject object = JSONObject.fromObject(s);
            System.out.println("object: ");
            System.out.println(object);
        }catch (Exception e){
            System.out.println("s:");
            System.out.println(s);
        }
    }

    public boolean testE(String s){
        if (s.subSequence(0,1).equals("c") || s.subSequence(0,1).equals("n")){
            if (Character.isDigit(s.charAt(1))){//如果c后边是数字，那接下来的都应该数字
                if (isInteger(s.substring(2))){
                    return true;
                }else return false;
            }
            else if (s.charAt(1)=='.'){ //如果c后边是小数点，应该有且只有2个小数点
                if (s.charAt(2)!='.' || !isInteger(s.substring(3))){
                    return false;
                }
                else if (isInteger(s.substring(3))){
                    return true;
                }
            }
            else return false;
        }
        else if (s.subSequence(0,1).equals("d")){
            if (isInteger(s.substring(1))){
                int n = Integer.parseInt(s.substring(1));
                if (n==4 || n==6 || n==8 || n==10){
                    return true;
                }
                else return false;
            }
            else {
                return false;
            }
        }
        else if (s.subSequence(0,2).equals("ts")){
            if (isInteger(s.substring(2))){
                int tss = Integer.parseInt(s.substring(2));
                if (tss==1 || tss==2 || tss==3 || tss==4 || tss==5 || tss==6 ||
                        tss==7 || tss==8 || tss==9){
                    return true;
                }
                else return false;
            }
            else {
                return false;
            }
        }
        else if (s.subSequence(0,1).equals("t")){
            if (isInteger(s.substring(1))){
                int n = Integer.parseInt(s.substring(1));
                if (n==2 || n==4 || n==6){
                    return true;
                }
                else return false;
            }
            else {
                return false;
            }
        }
        else if (s.subSequence(0,2).equals("bl")){
            if (s.equals("bl")){
                return true;
            }
            else return false;
        }
        else if (s.subSequence(0,4).equals("..ul")){
            if (s.equals("..ul")){
                return true;
            }
            else return false;
        }
        else if (s.subSequence(0,2).equals("BN")){
            if (s.equals("BN")){
                return true;
            }
            else return false;
        }
        return false;
    }
    /**
     * @Description: 判断一个字符串 是否是 整数
     * @Author: zhangjing
     * @Date: 2021/2/25 16:45
     */


    public static CommonReturnType parseExpression(JSONObject object){
        String length = object.getString("ll");
        // 判断长度是否是整数
        boolean b = isInteger(length);
        if(!b)return CommonReturnType.error("长度应为整数"); //如果 长度 填的不合法，要返回错误

        // 是否可变长
        boolean flag = object.getBoolean("islong");

        StringBuilder sb = new StringBuilder();
        String c = object.getString("tt");
        switch (c){
            case "c":   // 字符型
            case "n":   // 数值型
                sb.append(c);
                if (flag){
                    sb.append("..");
                }
                sb.append(length);
                break;
            case "d":   // 日期型和日期时间型  d后加4、6、8、10
                sb.append(c);
                int l = Integer.parseInt(length);
                if (l==4 || l==6 || l==8 || l==10){
                    sb.append(l);
                }else {
                    return CommonReturnType.error("日期型元素长度应为4、6、8、10");
                }
                break;
            case "t":   // 时间型  后加2、4、6
                sb.append(c);
                int len = Integer.parseInt(length);
                if (len==2 || len==4 || len==6){
                    sb.append(len);
                }else {
                    return CommonReturnType.error("时间型元素长度应为2、4、6");
                }
                break;
            case "ts":  // 时间戳型 数字1-9
                sb.append(c);
                int tss = Integer.parseInt(length);
                if (tss==1 || tss==2 || tss==3 || tss==4 || tss==5 || tss==6 ||
                        tss==7 || tss==8 || tss==9){
                    sb.append(tss);
                }else {
                    return CommonReturnType.error("时间戳型元素后加数字1-9表示时间戳的精度");
                }
                break;
            case "bl":  // 布尔型
                sb.append(c);
                break;
            case "BN":  //二进制型
                sb.append(c);
                break;
            case "..ul"://长度不定的文本
                sb.append(c);
                break;
            default:
                sb.append(c);
                break;
        }
        return CommonReturnType.ok(sb.toString(),"成功");
    }



    public static int hash(String s){
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        return h;
    }
    public static void testMin() throws ParseException {
        String s1 = "2020-08-11";
        String s2 = "2020-09-12";
        String s3 = "2021-11-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(s1);

        System.out.println(d1);
        Date d2 = sdf.parse(s2);
        Date d3 = sdf.parse(s3);


        System.out.println(d1);
//        List<Date> list = new ArrayList<>();
//        list.add(d1);
//        list.add(d2);
//        list.add(d3);
//        Date d = Collections.min(list);
//        System.out.println(d);

    }
    public static void testFor(){
        Date today = new Date();
        System.out.println(today);
        String todayStr = TimeUtils.formatDay(today);
        System.out.println(todayStr);
    }
    public static void mergeTwoMap(HashMap<Long, List<Integer>> map1, HashMap<Long, List<Integer>> map2){
        for (Map.Entry<Long, List<Integer>> entry : map2.entrySet()){
            long typeId = entry.getKey();
            List<Integer> everydayList = entry.getValue();
            if (map1.containsKey(typeId)){
                List<Integer> curList = map1.get(typeId);
                if (curList.size()>0 && curList.size()==everydayList.size()){
                    for (int i = 0; i < curList.size(); i++) {
                        int num = curList.get(i);
                        num += everydayList.get(i);
                        curList.set(i, num);
                    }
                }else {
                    map1.put(typeId, everydayList);
                }
            }else {
                map1.put(typeId, everydayList);
            }
        }
    }

    public static boolean equalsDate(String dateStr1, String dateStr2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(dateStr1);
            date2 = sdf.parse(dateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!date1.before(date2) && !date1.before(date2)){
            return true;
        }else {
            return false;
        }
    }

    public boolean compareDateStr(String curDateStr, String beginDateStr, String endDateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = sdf.parse(beginDateStr);
        Date endDate = sdf.parse(endDateStr);
        Date curDate = sdf.parse(curDateStr);
        if (!beginDate.after(curDate) && !endDate.before(curDate)){
            return true;
        }else {
            return false;
        }

    }

}
