package me.jeffrey.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 多线程安全时间格式转换
 * Created by jeffreysun on 2017/7/18.
 */
public class ThreadLocalDateUtil {
    private static final String date_format = "yyyyMMddHHmmss";
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getDateFormat()
    {
        SimpleDateFormat df = threadLocal.get();
        if(df==null){
            df = new SimpleDateFormat(date_format);
            threadLocal.set(df);
        }
        return df;
    }

    public static String formatDate(Date date) {
        return getDateFormat().format(date);
    }

    public static long parseDateString (String source) throws ParseException {
        Date date = getDateFormat().parse(source);
        return date.getTime() / 1000L;
    }
}
