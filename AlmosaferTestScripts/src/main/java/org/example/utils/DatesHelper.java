package org.example.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatesHelper {
    public static String getTomorrowDate(){
        LocalDate today = LocalDate.now();
        String tomorrow = (today.plusDays(1)).format(DateTimeFormatter.ISO_DATE);
        return tomorrow;
    }

    public static String getNextWeekDate(){
        LocalDate today = LocalDate.now();
        String nextWeek = (today.plusDays(7)).format(DateTimeFormatter.ISO_DATE);
        return nextWeek;
    }
}
