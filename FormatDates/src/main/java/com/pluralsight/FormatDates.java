package com.pluralsight;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FormatDates {
    public static void main(String[] args) {
        //Get current date and time
        LocalDateTime now = LocalDateTime.now();

        //Format 1: MM/dd/yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(format1));

        //Format 2: yyyy-MM-dd
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(format2));

        //Format 3: Month day, year (like Sep 5,2021)
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        System.out.println(now.format(format3));

        //Format 4: Mon day, year hour:minute (like Sunday, Sep 5, 2021 10:02)
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm", Locale.ENGLISH);
        System.out.println(now.format(format4));
    }

}

