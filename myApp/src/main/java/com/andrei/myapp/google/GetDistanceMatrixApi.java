package com.andrei.myapp.google;

import com.andrei.myapp.configuration.AppProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GetDistanceMatrixApi {
    private static final String API_KEY = "AIzaSyDtS5COCtMQt_imteg92y-RQ9ujvxpAF9Q";
    private final AppProperties appProperties;

    public GetDistanceMatrixApi(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public long getData(String source, String destination) throws Exception {
        String url1 = appProperties.getUrl();

        StringBuilder sb = new StringBuilder(100);
        sb.append(url1).append(source)
                .append("&destinations=")
                .append(destination)
                .append("&key=").append(API_KEY)
                .toString();

        var url = String.valueOf(sb);
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        long distance = -1L;
        long time = -1L;

        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(response);
        JSONArray ja = (JSONArray) jo.get("rows");
        jo = (JSONObject) ja.get(0);
        ja = (JSONArray) jo.get("elements");
        jo = (JSONObject) ja.get(0);
        JSONObject je = (JSONObject) jo.get("distance");
        JSONObject jf = (JSONObject) jo.get("duration");
        distance = ((long) je.get("value")) / 1000;
        time = ((long) jf.get("value")) / 60;


        System.out.println(distance + " km");
        System.out.println(time + " min");
        return distance;
    }
}



