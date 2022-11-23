package org.apache.commons.DateValidator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {

    DateValidator dateValidator = DateValidator.getInstance();
    String str = "2000-01-01";
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    Date date1;

    {
        try {
            date1 = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    Date date = Date.from(LocalDate.now().plusMonths(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    @Test
    void compareDates() {
        int res= dateValidator.compareDates(date1, date,null);
        Assert.assertEquals(0,res);
    }

    @Test
    void compareWeeks() {
        int res1=dateValidator.compareWeeks(new Date(), date,null);
        Assert.assertEquals(1,res1);
    }

    @Test
    void compareMonths() {
        int res2=dateValidator.compareMonths(new Date(), date,null);
        Assert.assertEquals(1,res2);
    }

    @Test
    void compareQuarters() {
        int res3=dateValidator.compareQuarters(new Date(), date,null);
        Assert.assertEquals(1,res3);
    }

    @Test
    void compareYears() {
        int res4=dateValidator.compareYears(new Date(), date,null);
        Assert.assertEquals(1,res4);
    }
}
