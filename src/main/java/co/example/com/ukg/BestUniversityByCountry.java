package co.example.com.ukg;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BestUniversityByCountry {

    public static String getBestUniversity(String country) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/universities";
        JSONParser parser = new JSONParser();

        String bestUniversity = "";
        int bestRank = Integer.MAX_VALUE; // Lower rank = better

        try {
            int page = 1;
            int totalPages = 1;

            while (page <= totalPages) {
                String fullUrl = baseUrl + "?page=" + page;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(fullUrl))
                        .GET()
                        .build();

                HttpResponse apiResponse = client.send(request, HttpResponse.BodyHandlers.ofString());


                JSONObject response = (JSONObject) parser.parse(apiResponse.body().toString());

                if (page == 1) {
                    totalPages = ((Long) response.get("total_pages")).intValue();
                }

                JSONArray data = (JSONArray) response.get("data");

                for (Object obj : data) {
                    JSONObject dataObject = (JSONObject) obj;

                    JSONObject locationObj = (JSONObject) dataObject.get("location");

                    String uniCountry = (String) locationObj.get("country");
                    if (!country.equalsIgnoreCase(uniCountry))
                        continue;

                    String name = (String) dataObject.get("university");
                    Integer rank = Integer.parseInt((String) dataObject.get("rank_display")); // Might be Long


                    if (rank < bestRank) {
                        bestRank = rank;
                        bestUniversity = name;
                    }
                }

                page++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestUniversity;
    }

    // For testing
    public static void main(String[] args) {
        String country = "London";
        String bestUni = getBestUniversity(country);
        System.out.println("Best university in " + country + ": " + bestUni);
    }
}