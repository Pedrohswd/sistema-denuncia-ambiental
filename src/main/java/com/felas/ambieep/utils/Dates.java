package com.felas.ambieep.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Dates {
    public static Date now(){
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        ZoneId zonaDefault = ZoneId.systemDefault();
        return Date.from(dataHoraAtual.atZone(zonaDefault).toInstant());
    }

    public static String year(){
        String year = new SimpleDateFormat("yy").format(new Date());
        return year;
    }
}
