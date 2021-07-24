import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    static List<String> col01 = new ArrayList<>();
    static List<String> col02 = new ArrayList<>();
    static String urlData = null;

    public static void main(String[] args) throws IOException {
        String httpsURL = "https://tw.stock.yahoo.com/class-quote?sectorId=1&exchange=TAI";

        URL myurl = new URL(httpsURL);
        HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
        con.setRequestProperty ( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0" );
        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr, 50);
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
//        urlData = in.toString();
//        Parser(urlData);
//        System.out.println("股票代號\t成交");
//        for (int i = 0; i < col01.size(); i++){
//            System.out.println(col01.get(i).toString() + "\t" + col02.get(i));
//        }
    }

    public static void Parser(String urlData){
        String temp = null;
        int start = 0, end = 0, counter = 0;
        do {
            start = urlData.indexOf("<div class=\"Lh(20px) Fw(600) Fz(16px) Ell\">", end + 1);
            end = urlData.indexOf("</div>", start + 1);
            temp = urlData.substring(start + 63, end);
            col01.add(temp);
            counter++;
        } while (counter < 7);
    }
}
