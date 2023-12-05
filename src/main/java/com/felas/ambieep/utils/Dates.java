package com.felas.ambieep.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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

    public static String formaterToString(String dateString){
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);


        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime().minusHours(3);
        String dataFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return dataFormatada;
    }

    public static String formaterToDaS(String dateString) {
        DateTimeFormatter parserFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        // Converter a string para LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, parserFormatter);

        // Usar outro DateTimeFormatter para formatar para 'yyyy-MM-dd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Formatando para 'yyyy-MM-dd'
        String formattedDate = localDateTime.format(formatter);

        return formattedDate;
    }
}
