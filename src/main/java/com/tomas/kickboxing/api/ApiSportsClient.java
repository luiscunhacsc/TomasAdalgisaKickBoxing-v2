package com.tomas.kickboxing.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tomas.kickboxing.model.Fighter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiSportsClient {
    private static final String API_KEY = "3f37e2be2ba15d37ac812c31838f9b66";
    private static final String BASE_URL = "https://v1.mma.api-sports.io";
    private final HttpClient client = HttpClient.newHttpClient();

    public List<Fighter> getFighters(String search) throws IOException, InterruptedException {
        String endpoint = BASE_URL + "/fighters?search=" + search;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("x-apisports-key", API_KEY)
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("API error: " + response.body());
        }
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonArray fighters = json.getAsJsonArray("response");
        List<Fighter> result = new ArrayList<>();
        for (int i = 0; i < fighters.size(); i++) {
            JsonObject f = fighters.get(i).getAsJsonObject();
            int id = f.get("id").getAsInt();
            String name = f.get("name").getAsString();
            String nickname = f.has("nickname") && !f.get("nickname").isJsonNull() ? f.get("nickname").getAsString() : null;
            String photo = f.has("photo") && !f.get("photo").isJsonNull() ? f.get("photo").getAsString() : null;
            String gender = f.has("gender") && !f.get("gender").isJsonNull() ? f.get("gender").getAsString() : null;
            String birthDate = f.has("birth_date") && !f.get("birth_date").isJsonNull() ? f.get("birth_date").getAsString() : null;
            Integer age = f.has("age") && !f.get("age").isJsonNull() ? (f.get("age").isJsonPrimitive() ? f.get("age").getAsInt() : null) : null;
            String height = f.has("height") && !f.get("height").isJsonNull() ? f.get("height").getAsString() : null;
            String weight = f.has("weight") && !f.get("weight").isJsonNull() ? f.get("weight").getAsString() : null;
            String reach = f.has("reach") && !f.get("reach").isJsonNull() ? f.get("reach").getAsString() : null;
            String stance = f.has("stance") && !f.get("stance").isJsonNull() ? f.get("stance").getAsString() : null;
            String category = f.has("category") && !f.get("category").isJsonNull() ? f.get("category").getAsString() : null;
            String team = null;
            if (f.has("team") && !f.get("team").isJsonNull()) {
                JsonObject teamObj = f.getAsJsonObject("team");
                if (teamObj.has("name") && !teamObj.get("name").isJsonNull()) {
                    team = teamObj.get("name").getAsString();
                }
            }
            String lastUpdate = f.has("last_update") && !f.get("last_update").isJsonNull() ? f.get("last_update").getAsString() : null;
            result.add(new Fighter(id, name, nickname, photo, gender, birthDate, age, height, weight, reach, stance, category, team, lastUpdate));
        }
        System.out.println("[DEBUG] API response: " + response.body());
        return result;
    }
}
