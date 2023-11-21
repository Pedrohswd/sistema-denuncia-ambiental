package com.felas.ambieep.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.CountyJSON;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class CountyAPI {

    public List<CountyJSON> contryByState(State state) {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + state.getAcronym() + "/municipios";
        String request = request(url, "GET", null);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<CountyJSON> listContry = objectMapper.readValue(
                    request,
                    new TypeReference<List<CountyJSON>>() {
                    }
            );
            return listContry;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    private String request(String urlApi, String metodo, Map<String, Object> params) {
        try {
            URL url = new URL(urlApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(metodo.toUpperCase());

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
