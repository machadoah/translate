import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FunTranslationsApiClient {

    public static void main(String[] args) {
        try {
            String textToTranslate = "Hello, world. How are you? my friend!".replace(" ","%20");

            URL url = new URL("https://api.funtranslations.com/translate/pirate.json?text=" + textToTranslate);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                StringBuilder response = new StringBuilder();

                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }

                System.out.println("Tradução : " + response.toString());

            }
            catch(Exception e){
                System.out.println("Erro : " + e.getMessage());
            }

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
    }
}
