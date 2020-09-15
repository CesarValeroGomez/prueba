package helper;

import com.google.gson.Gson;
import entities.DatosRequest;
import java.io.*;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadPropertiData {

    private DatosRequest datosRequest;
    private TestEnviron testEnv;

    public ReadPropertiData() { }

    public DatosRequest LoadRequestData(Object token)
    {

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/requestData.properties");

            Properties prop = new Properties();
            prop.load(fis);

            datosRequest = new DatosRequest(prop.getProperty("user"),
                    prop.getProperty("password"),token);

        } catch (FileNotFoundException ex) {
            System.out.println("error Archivo");
        //    Logger.getLogger(ReadPropertiData.class.getName()).log( Level.SEVERE, null, ex);
        } catch (IOException e) {  e.printStackTrace();       }
        return datosRequest;
    }

    public TestEnviron LoadMainData(String link, Object sessionId)
    {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/mainData.properties");

            Properties prop = new Properties();
            prop.load(fis);

            testEnv = new TestEnviron(prop.getProperty("domain"),prop.getProperty("apiKey"),link,sessionId);

        } catch (FileNotFoundException ex) {
            System.out.println("error Archivo");
        //    Logger.getLogger(ReadPropertiData.class.getName()).log( Level.SEVERE, null, ex);
        } catch (IOException e) {  e.printStackTrace();       }
        return testEnv;
    }

    public Object readJson() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/test/resources/descriptionList.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      //  System.out.println(json.getClass());
      //  System.out.println(json.toString());
        Gson gson = new Gson();
        Object json = gson.fromJson(bufferedReader, Object.class);
        return json;
    }

    public Object readJsonRating() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/test/resources/rating.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Object json = gson.fromJson(bufferedReader, Object.class);
        return json;
    }
}
