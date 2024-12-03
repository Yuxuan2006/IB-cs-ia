package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AI {
    public static String GeminiApi(String prompt) {
        String apiKey = "AIzaSyDycjmo_ZNcvEhQPDZ1GOPdaSNdoIiDz2c"; // Store this securely
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent?key=" + apiKey;
        
        // Escape special characters in the prompt
        prompt = prompt.replace("\"", "\\\"")
                      .replace("\n", "\\n");
        
        String requestBody = String.format(
            "{\"contents\":[{\"parts\":[{\"text\":\"%s\"}]}]}", 
            prompt
        );

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Error: " + response.statusCode());
                System.err.println("Response: " + response.body());
                return "";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }
}
