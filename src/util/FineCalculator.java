package util;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class FineCalculator {

    public static long fine(
            LocalDate issue,
            LocalDate returned){

        long days =

                ChronoUnit.DAYS
                        .between(issue,returned);

        if(days>7){

            return (days-7)*10;

        }

        return 0;

    }

}
