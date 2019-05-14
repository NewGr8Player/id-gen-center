package com.xavier.center.config;

import com.xavier.center.util.DateUtil;
import groovy.lang.Script;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 拓展语法
 *
 * @author NewGr8Player
 */
public class BasicScript extends Script {

    @Override
    public Object run() {
        Method[] methods = BasicScript.class.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(method);
        }

        return sb.substring(0, sb.length() - 1);
    }

    /**
     * yyyyMMdd
     *
     * @return
     */
    public static Object yyyyMMdd() {
        return DateUtil.formatDate(new Date(), DateUtil.YMD);
    }

    /**
     * yyyyMMdd
     *
     * @return
     */
    public static Object yyyyMM() {
        return DateUtil.formatDate(new Date(), DateUtil.YM);
    }

    /**
     * 当前年
     *
     * @return
     */
    public static Object yyyy() {
        return DateUtil.formatDate(new Date(), DateUtil.YEAR);
    }

    /**
     * 当前月
     *
     * @return
     */
    public static Object MM() {
        return DateUtil.formatDate(new Date(), DateUtil.MONTH);
    }

    /**
     * 当前日
     *
     * @return
     */
    public static Object dd() {
        return DateUtil.formatDate(new Date(), DateUtil.DAY);
    }

    /**
     * 格式化序列
     *
     * @param seq   序列号
     * @param fixed 补齐总位数
     * @return
     */
    public static Object format(int seq, int fixed) {
        return String.format("%0" + fixed + "d", seq);
    }

    /**
     * 格式化序列
     *
     * @param seq   序列号
     * @param fixed 补齐总位数
     * @return
     */
    public static Object format(long seq, int fixed) {
        return String.format("%0" + fixed + "d", seq);
    }
}
