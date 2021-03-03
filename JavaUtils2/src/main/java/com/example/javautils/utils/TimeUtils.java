package com.utils;

import com.Cons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description: 日期操作转换函数
 * @Author: zhangjing
 * @Date: 2021/3/2 9:55
*/
public class TimeUtils {

    /**
     * @Description: 获取当前时间
     * @Author: zhangjing
     * @Date: 2021/3/2 9:54
    */
    public static Date getCurrentTime(){
        Date current = new Date();
        return current;
    }

    /**
     * 转换 timeType，获取范围内的开始日期 String类型 yyyy-MM-dd
     * timeType取值可为 “本年” || “本季” || “本月” || “本周” || “本日”
     * @return
     */
    public static String getBeginDate(String timeType) {
        String beginDateStr = null;
        switch (timeType){
            case Cons.TIME_TYPE_YEAR: //本年
                beginDateStr = getCurrentYearStartTime();
                break;
            case Cons.TIME_TYPE_QUARTER: //本季
                beginDateStr = getCurrentQuarterStartTime();
                break;
            case Cons.TIME_TYPE_MONTH: //本月
                beginDateStr = getCurrentMonthStartTime();
                break;
            case Cons.TIME_TYPE_WEEK: //本周
                beginDateStr = getCurrentWeekDayStartTime();
                break;
            case Cons.TIME_TYPE_DAY: //本日
                beginDateStr = getCurrentDayStartTime();
                break;
            default:
                System.out.println(timeType+"不合法，默认显示本年。");
                beginDateStr = getCurrentYearStartTime();
                break;
        }
        return beginDateStr;
    }

    /**
     * 转换 timeType，获取范围内的结束日期 String类型 yyyy-MM-dd
     * timeType取值可为 “本年” || “本季” || “本月” || “本周” || “本日”
     * @return
     */
    public static String getEndDate(String timeType) {
        String endDateStr = null;
        switch (timeType){
            case Cons.TIME_TYPE_YEAR: //本年
                endDateStr = getCurrentYearEndTime();
                break;
            case Cons.TIME_TYPE_QUARTER: //本季
                endDateStr = getCurrentQuarterEndTime();
                break;
            case Cons.TIME_TYPE_MONTH: //本月
                endDateStr = getCurrentMonthEndTime();
                break;
            case Cons.TIME_TYPE_WEEK: //本周
                endDateStr = getCurrentWeekDayEndTime();
                break;
            case Cons.TIME_TYPE_DAY: //本日
                endDateStr = getCurrentDayEndTime();
                break;
            default:
                System.out.println(timeType+"不合法，默认显示本年。");
                endDateStr = getCurrentYearEndTime();
                break;
        }
        return endDateStr;
    }

    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime
     *            开始日期
     * @param endTime
     *            结束日期
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
     * 将Date类型的年月日转换成String类型的年月日 yyyy-MM-dd
     *
     * @return
     */
    public static String formatDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date!=null){
            return sdf.format(date);
        }
        return null;
    }

    /**
     * 获得本周的第一天，周一
     *
     * @return
     */
    public static String getCurrentWeekDayStartTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(c.getTime());
    }

    /**
     * 获得本周的最后一天，周日
     *
     * @return
     */
    public static String getCurrentWeekDayEndTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 8 - weekday);
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(c.getTime());
    }

    /**
     * 获得本天的开始时间
     *
     * @return
     */
    public static String getCurrentDayStartTime() {
        Date now = new Date();
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            now = shortSdf.parse(shortSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 获得本天的结束时间
     *
     * @return
     */
    public static String getCurrentDayEndTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 获得本小时的开始时间
     *
     * @return
     */
    public static String getCurrentHourStartTime() {
        SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date now = new Date();
        try {
            now = longHourSdf.parse(longHourSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 获得本小时的结束时间
     *
     * @return
     */
    public static String getCurrentHourEndTime() {
        SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        try {
            now = longSdf.parse(longHourSdf.format(now) + ":59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 获得本月的开始时间
     *
     * @return
     */
    public static String getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 本月的结束时间
     *
     * @return
     */
    public static String getCurrentMonthEndTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 当前年的开始时间
     *
     * @return
     */
    public static String getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 当前年的结束时间
     *
     * @return
     */
    public static String getCurrentYearEndTime() {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static String getCurrentQuarterStartTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 当前季度的结束时间
     *
     * @return
     */
    public static String getCurrentQuarterEndTime() {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * 获取前/后半年的开始时间
     *
     * @return
     */
    public static String getHalfYearStartTime() {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);

    }

    /**
     * 获取前/后半年的结束时间
     *
     * @return
     */
    public static String getHalfYearEndTime() {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDay(now);
    }

    /**
     * @Description: 将日，月，年转为指定 YYYY-MM-DD
     * @Author: zhangjing
     * @Date: 2021/3/2 9:52
    */
    public static String getTime(Integer day,Integer month,Integer year) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_YEAR,day);
        rightNow.add(Calendar.MONTH,month);
        rightNow.add(Calendar.YEAR,year);
        Date dt1=rightNow.getTime();
        String reStr = format.format(dt1);
        return reStr;
    }

    /**
     * @Description: 将日、月、年转为指定yyyy-MM-dd HH:mm:ss
     * @Author: zhangjing
     * @Date: 2021/3/2 9:52
    */
    public static String getTimeHHMMSS(Integer day,Integer month,Integer year) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_YEAR,day);
        rightNow.add(Calendar.MONTH,month);
        rightNow.add(Calendar.YEAR,year);
        Date dt1=rightNow.getTime();
        String reStr = format.format(dt1);
        return reStr;
    }

    /**
     * @Description: 将日、月、年和当前时间转为指定yyyy-MM-dd HH:mm:ss
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static String getTimeByCurrHHMMSS(Integer day,Integer month,Integer year,Date CurrDate) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(CurrDate);
        rightNow.add(Calendar.DAY_OF_YEAR,day);
        rightNow.add(Calendar.MONTH,month);
        rightNow.add(Calendar.YEAR,year);
        Date dt1=rightNow.getTime();
        String reStr = format.format(dt1);
        return reStr;
    }

    /**
     * @Description: 将日、月、年和当前时间转为指定yyyy-MM-dd HH:mm:ss
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static String getTimeByCurr(Integer day,Integer month,Integer year,Date CurrDate) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(CurrDate);
        rightNow.add(Calendar.DAY_OF_YEAR,day);
        rightNow.add(Calendar.MONTH,month);
        rightNow.add(Calendar.YEAR,year);
        Date dt1=rightNow.getTime();
        String reStr = format.format(dt1);
        return reStr;
    }

    /**
     * @Description: 将日、月、年和当前时间转为指定格式
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static String getTimeByCurrWithFormat(Integer day,Integer month,Integer year,Date CurrDate,String formatStr) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(CurrDate);
        rightNow.add(Calendar.DAY_OF_YEAR,day);
        rightNow.add(Calendar.MONTH,month);
        rightNow.add(Calendar.YEAR,year);
        Date dt1=rightNow.getTime();
        String reStr = format.format(dt1);
        return reStr;
    }

    /**
     * @Description: 获取当前时间戳String yyyyMMddHHmmss
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static String getCurrenttimeNoSplit(){

        String time = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date current = new Date();
        time= format.format(current);

        return time;

    }

    /**
     * @Description: 获取当前时间String yyyy-MM-dd HH:mm:ss
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static String getCurrentDayNoSplit(){

        String time = "";

        SimpleDateFormat format = new SimpleDateFormat("MMdd");
        Date current = new Date();
        time= format.format(current);

        return time;

    }

    /**
     * @Description: 将Date减n天
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static Date minusNDay(Date date, int n){
        n = -1*n;
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR, n);
        Date newDate = rightNow.getTime();
        return newDate;

    }

    /**
     * @Description: 比较时间大小
     * @Author: zhangjing
     * @Date: 2021/3/2 9:53
    */
    public static Boolean islargerTime(Date date1,Date date2){
        Boolean flag = true;
        if(date1.getTime()<date2.getTime()){
            flag = false;
        }

        return flag;
    }

    public static Boolean isEqual(Date date1,Date date2){
        Boolean flag = false;
        if(date1.getTime() == date2.getTime()){
            flag = true;
        }

        return flag;
    }

    public static Boolean isOutTime(Date date){
        Boolean flag = false;

        if(getCurrentTime().getTime()>date.getTime()){
            flag = true;
        }

        return flag;
    }

    /**
     * 判断curDateStr是否在起止日期之间 yyyy-MM-dd
     * true: curDateStr在范围内（含等于
     * false: curDateStr不在范围内
     * @return
     */
    public static boolean compareDateStr(String curDateStr, String beginDateStr, String endDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        Date curDate = null;
        try {
            beginDate = sdf.parse(beginDateStr);
            endDate = sdf.parse(endDateStr);
            curDate = sdf.parse(curDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!beginDate.after(curDate) && !endDate.before(curDate)){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 判断两个日期是否相等 yyyy-MM-dd
     *
     * @return
     */
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

}
