import java.io.*;
import java.net.URL;
import net.sf.json.JSONObject;

public class StockTest {


    public static void main(String[] args) throws IOException {
        String url = "https://www.twse.com.tw/exchangeReport/STOCK_DAY?response=json&date=20210513&stockNo=2330";

//        String url = "http://192.168.1.106:8080/test/test.json";

        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "utf-8")); //避免中文亂碼問題
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            JSONObject json = JSONObject.fromObject(sb.toString());
            System.out.println(json.get("hello"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
