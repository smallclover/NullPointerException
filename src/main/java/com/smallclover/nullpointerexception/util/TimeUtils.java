package com.smallclover.nullpointerexception.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Amadeus
 * @date 2020-01-19
 * 时间处理工具
 */
@Slf4j
public class TimeUtils {

    private static Date getDateByString(String time){
        Date date = null;
        if (time == null){
            return date;
        }

        String pattern = "yyyy-MM-dd HH:mm:ss";
        var format = new SimpleDateFormat(pattern);
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            log.error("TimeUtils.getDateByString:时间转换时出现错误");
            e.printStackTrace();
        }
        return date;
    }

    public static String getFewTimeAgo(String time){
        String res = null;
        long now = Calendar.getInstance().getTimeInMillis();
        Date date = getDateByString(time);
        if (date == null){
            return res;
        }

        long tmp = (now - date.getTime())/1000;

        if (tmp > 365 * 24 * 60 * 60) {
            res = (int) (tmp / (365 * 24 * 60 * 60)) + " 年 前";
        } else if (tmp > 24 * 60 * 60) {
            res = (int) (tmp / (24 * 60 * 60)) + " 天 前";
        } else if (tmp > 60 * 60) {
            res = (int) (tmp / (60 * 60)) + " 小时 前";
        } else if (tmp > 60) {
            res = (int) (tmp / (60)) + " 分 前";
        } else if (tmp > 1) {
            res = tmp + " 秒 前";
        } else {
            res = "1 秒 前";
        }
        return res;
    }

    public static void main(String[] args) {
        String time = "2012-02-28 10:40:55";
        System.out.println(TimeUtils.getFewTimeAgo(time));
    }
}
