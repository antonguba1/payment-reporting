package com.utility;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtility {


    //private static final Date truncatedDate = DateUtils.truncate(new Date(), Calendar.DATE);
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

    public static Date toDate(String date) {
        try {
            return new Date(sdf1.parse(date).getTime());
        } catch (ParseException e) {

            e.printStackTrace();
            return null;
        }
    }

    public static Date incrementMonth(Date date) {
        return DateUtils.addMonths(date, 1);
    }

}