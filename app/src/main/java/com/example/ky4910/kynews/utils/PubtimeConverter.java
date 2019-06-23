package com.example.ky4910.kynews.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PubtimeConverter {

    /* Genymotion模拟器的时间戳转换会出现偏差(About 12 hours) */
    public static String pubtimeToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.ENGLISH);
        long lt = Long.valueOf(s);
        res = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(lt*1000))));
        //Date date = new Date(lt);
        //res = simpleDateFormat.format(date);
        return res;
    }
}
