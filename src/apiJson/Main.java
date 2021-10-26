package apiJson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String output = getUrl("http://api.currencylayer.com/live?access_key=0bf99be7ef0f58cfacd22767c59f9458&format=1");

        Scanner scanner = new Scanner(System.in);
        int usd = scanner.nextInt();
        JSONObject jsonObject = new JSONObject(output);
        int kzAmount = (int)jsonObject.getJSONObject("quotes").getDouble("USDKZT");
        System.out.println(output);
        System.out.println();
        System.out.println("Result: " + (kzAmount * usd));
    }

    private static String getUrl(String url){
        String output = "";

        try{
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));


            String data;

            while ((data = bufferedReader.readLine())!=null){
                output += data + "\n";
            }

            bufferedReader.close();

        }catch (Exception e){
           e.printStackTrace();
            System.out.println("Что то пошло не так");
        }

        return output;
    }
}
