package com.company.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtility {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

    public static Date toDate(String date) {
        try {
            return new Date(sdf1.parse(date).getTime());
        } catch (ParseException e) {

            e.printStackTrace();
            return null;
        }
    }
}