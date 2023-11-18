package com.felas.ambieep.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Dates {
    public static Date now(){
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        ZoneId zonaDefault = ZoneId.systemDefault();
        return Date.from(dataHoraAtual.atZone(zonaDefault).toInstant());
    }
}
