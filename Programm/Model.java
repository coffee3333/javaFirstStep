package Programm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Model {
    View view;

    Model(View view){
        this.view = view;
    }

    public String getRequest(String data){
        String url = "http://172.104.248.42:8080/api/hello";
        String postData = String.format("{\"name\": \"%s\"}",data);
        String answer = "Network problem";

        try {
            URL urlObject = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(postDataBytes);
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response Code: " + responseCode);
                answer = response.toString();
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answer;
    }

    public void setEventView() {
        view.textField.setText(getRequest(view.textField.getText()));
    }
    
}
