import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class ObjectToJson  {

    public void addUserObjectToJson(String userName, String userEmail) throws IOException {
        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonArray.add("Name: "+userName);
        jsonArray.add("Email: "+userEmail);
        obj.put("userList",jsonArray);
        FileWriter file = new FileWriter("userList.json");
        try {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("JSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            file.flush();
            file.close();
        }
    }
    public void addPaymentObjectToJson(String userEmail,String dueDate,int expectedAmount,String actualDate,int actualAmount,int numberOfPayments ) throws IOException {
        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();


        jsonArray.add("Due date: "+dueDate);
        jsonArray.add("Expected amount: "+expectedAmount);
        jsonArray.add("Actual date: "+actualDate);
        jsonArray.add("Actual amount: "+actualAmount);
        jsonArray.add("Actual amount: "+actualAmount);
        jsonArray.add("Number of payments: "+numberOfPayments);

        obj.put(userEmail,jsonArray);
        FileWriter file = new FileWriter("paymentList.json");
        try {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("JSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            file.flush();
            file.close();
        }
    }

    public void readJsonFile(String userEmail) {
        JSONParser parser = new JSONParser();

        try {
            File file = new File("paymentList.json");
            String path = file.getPath();

            Object obj = parser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray payments = (JSONArray) jsonObject.get(userEmail);

            System.out.println(userEmail+": ");
            Iterator<String> iterator = payments.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
