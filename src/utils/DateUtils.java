package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mcvakou
 */
public class DateUtils {
    //TODO USING LEGACY DATE NEED TO LEARN HOW TO USE A NEWER ONE

    public static Date parseStringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
}
