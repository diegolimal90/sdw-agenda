package utils;

import java.time.LocalDateTime;

public class LocalDateTimeUtils {


    /**
     * Is date before of date now boolean.
     *
     * @param dateOne the date one
     * @return the boolean
     */
    public static boolean isDateBeforeOfDateNow(LocalDateTime dateOne){
        return isDateBeforeOfDateNow(dateOne, LocalDateTime.now());
    }

    /**
     * Is date before of date now boolean.
     *
     * @param dateOne the date one
     * @param dateTwo the date two
     * @return the boolean
     */
    public static boolean isDateBeforeOfDateNow(LocalDateTime dateOne, LocalDateTime dateTwo){
        return dateOne.isBefore(dateTwo);
    }
}
