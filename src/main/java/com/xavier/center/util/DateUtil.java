package com.xavier.center.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author NewGr8Player
 */
public final class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final ThreadLocal<DateFormat> YMD_HMS =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmmss"));

    /**
     * yyyy-MM-dd
     */
    public static final ThreadLocal<DateFormat> YMD =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    /**
     * yyyy-MM-dd
     */
    public static final ThreadLocal<DateFormat> YM =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMM"));

    /**
     * yyyy
     */
    public static final ThreadLocal<DateFormat> YEAR =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy"));

    /**
     * MONTH
     */
    public static final ThreadLocal<DateFormat> MONTH =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("MM"));

    /**
     * DAY
     */
    public static final ThreadLocal<DateFormat> DAY =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("dd"));


    /**
     * 格式化完整日期
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:ss格式的字符串
     */
    public static String formatDate(Date date, ThreadLocal<DateFormat> dateFormat) {
        return dateFormat.get().format(date);
    }

    /**
     * 格式化年月日
     *
     * @param date
     * @return yyyy-MM-dd格式的字符串
     */
    public static String formatYMD(Date date) {
        return YMD.get().format(date);
    }

    /**
     * 获取指定日期0点的字符串
     *
     * @param date
     * @return 返回示例:2017-12-23 00:00:00
     */
    public static String getZeroPointStr(Date date) {
        return formatDate(calendar(date, 0, 0, 0, 0).getTime(), YMD_HMS);
    }

    /**
     * 获取指定日期末点的字符串
     *
     * @param date
     * @return 返回示例:2017-12-23 23:59:59
     */
    public static String getLastPointStr(Date date) {
        return formatDate(calendar(date, 23, 59, 59, 999).getTime(), YMD_HMS);
    }

    /**
     * 获取指定日期的0点的毫秒数
     *
     * @param date
     * @return
     */
    public static long getZeroPointMillisecond(Date date) {
        return calendar(date, 0, 0, 0, 0).getTime().getTime();
    }

    /**
     * 获取指定日期的末点的毫秒数
     *
     * @param date
     * @return
     */
    public static long getLastPointMillisecond(Date date) {
        return calendar(date, 23, 59, 59, 999).getTime().getTime();
    }

    /**
     * 获取当前日起对象
     *
     * @return
     */
    public static Date getNowDate() {
        return new Date();
    }

    private static Calendar calendar(Date date, int hourOfDay, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar;
    }

}