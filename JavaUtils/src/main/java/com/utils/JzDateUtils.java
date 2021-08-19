package com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Title: 日期类
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */
public class JzDateUtils {

    /**
     * @Title: day1 > day2
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean largerThan(String day1, String day2){
        int n = day1.compareTo(day2);
        if (n>0) return true;
        else return false;
    }
    public static boolean largerThan(Date date1, Date date2){
        if(date1.getTime()>date2.getTime()) return true;
        return false;
    }

    /**
     * @Title: day1 >= day2
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean largerThanOrEqual(String day1, String day2){
        int n = day1.compareTo(day2);
        if (n>=0) return true;
        else return false;
    }
    public static boolean largerThanOrEqual(Date date1, Date date2){
        if(date1.getTime()>=date2.getTime()) return true;
        return false;
    }

    /**
     * @Title: day1 < day2
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean lesserThan(String day1, String day2){
        int n = day1.compareTo(day2);
        if (n<0) return true;
        else return false;
    }
    public static boolean lesserThan(Date date1, Date date2){
        if(date1.getTime()<date2.getTime()) return true;
        return false;
    }

    /**
     * @Title: day1 <= day2
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean lesserThanOrEqual(String day1, String day2){
        int n = day1.compareTo(day2);
        if (n<=0) return true;
        else return false;
    }
    public static boolean lesserThanOrEqual(Date date1, Date date2){
        if(date1.getTime() <= date2.getTime()) return true;
        return false;
    }

    /**
     * @Title: day1 == day2?
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean equalTo(String day1, String day2) {
        if (day1.compareTo(day2) == 0) return true;
        return false;
    }
    public static boolean equalTo(Date date1, Date date2) {
        if(date1.getTime() == date2.getTime()) return true;
        return false;
    }

    /**
     * @Title: 把日期规范化为 yyyy-MM-dd 格式的字符串
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static String formatDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date!=null){
            return sdf.format(date);
        }
        return null;
    }
    /**
     * @Title: 把日期规范化为 yyyy-MM-dd HH:mm:ss 格式的字符串
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static String formatDayHour(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date!=null){
            return sdf.format(date);
        }
        return null;
    }

    /**
     * @Title: 将String转为Date（字符串为 yyyy-MM-dd HH:mm:ss）
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
	public static Date transHourStrToDate(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date date = format.parse(dateStr, pos);
		return date;
	}
    /**
     * @Title: 将String转为Date（字符串为 yyyy-MM-dd）
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date transDateStrToDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date date = format.parse(dateStr, pos);
        return date;
    }

    /**
     * @Title: 将日期加n天
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
	public static Date addNDay(Date date, int n){
		n = 1*n;
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR, n);
		Date newDate = rightNow.getTime();
		return newDate;
	}
    /**
     * @Title: 将日期减n天
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
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
     * @Title: 把字符串yyyy-MM-dd加一天
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
	public static String addNDay(String time, int n){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR,n);
	    Date dt1=rightNow.getTime();
	    String reStr = format.format(dt1);
	    return reStr;
	}
    /**
     * @Title: 把字符串yyyy-MM-dd减一天
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
	public static String minusNDay(String time, int n){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR,-n);
	    Date dt1=rightNow.getTime();
	    String reStr = format.format(dt1);
	    return reStr;
	}

    /**
     * @Title: 获取两个日期之间的所有日期
     * @Params: param1: 开始日期字符串
     *          param2: 结束日期字符串
     * @Return: List<String>
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static List<String> getDays(String day1, String day2) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(day1);
            Date end = dateFormat.parse(day2);

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
     * @Title: 获得本小时的开始时间（Date类）
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentHourStartTime() {
        SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date now = new Date();
        try {
            now = longHourSdf.parse(longHourSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * @Title: 获得本小时的结束时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentHourEndTime() {
        SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        try {
            now = longSdf.parse(longHourSdf.format(now) + ":59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * @Title: 获得今天的开始时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentDayStartTime() {
        Date now = new Date();
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            now = shortSdf.parse(shortSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * @Title: 获得今天的结束时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentDayEndTime() {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * @Title: 获得本周的第一天的开始时间（Date类）
     * @Params:
     * @Return: Date类
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentWeekDayStartTime() {
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
        return c.getTime();
    }
    /**
     * @Title: 获得本周最后一天的结束时间（Date类）
     * @Params: 
     * @Return: 
     * @Author: ZhangJing
     * @Date:  
     * @Description: 
     * @Version 1.0
     */
    public static Date getCurrentWeekDayEndTime() {
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
        return c.getTime();
    }
    /**
     * @Title: 获得本月的开始时间（Date类）
     * @Params: 
     * @Return: 
     * @Author: ZhangJing
     * @Date:  
     * @Description: 
     * @Version 1.0
     */
    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * @Title: 获得本月的结束时间（Date类）
     * @Params: 
     * @Return: 
     * @Author: ZhangJing
     * @Date:  
     * @Description: 
     * @Version 1.0
     */
    public static Date getCurrentMonthEndTime() {
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
        return now;
    }
    /**
     * @Title: 获得本季度的开始时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentQuarterStartTime() {
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
        return now;
    }
    /**
     * @Title: 获得本季度的结束时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getCurrentQuarterEndTime() {
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
        return now;
    }
    /**
     * @Title: 获得前/后半年的开始时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getHalfYearStartTime() {
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
        return now;

    }
    /**
     * @Title: 获得前/后半年的结束时间（Date类）
     * @Params:
     * @Return:
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static Date getHalfYearEndTime() {
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
        return now;
    }
    /**
     * @Title: 获得本年的开始时间（Date类）
     * @Params: 
     * @Return: 
     * @Author: ZhangJing
     * @Date:  
     * @Description: 
     * @Version 1.0
     */
    public static Date getCurrentYearStartTime() {
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
        return now;
    }
    /**
     * @Title: 获得本年的结束时间（Date类）
     * @Params: 
     * @Return: 
     * @Author: ZhangJing
     * @Date:  
     * @Description: 
     * @Version 1.0
     */
    public static Date getCurrentYearEndTime() {
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
        return now;
    }

}
