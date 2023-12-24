//package Parsing.JsonParsing;
//
//import ArithmeticOperations.ArithmeticProcess;
//import Parsing.Singleton;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.text.html.parser.DTD;
//import javax.swing.text.html.parser.Parser;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class JsonParser extends Parser {
//    private ArrayList<Double> rezuList = new ArrayList<>();
//
//    public JsonParser(String inPath) throws IOException {
//        super(DTD.getDTD(inPath));
//    }
//
//    @Override
//    public void parse() {
//
//        try {
//            FileReader read = new FileReader(getInPath());
//            JSONParser Parser = new JSONParser();
//            JSONObject object = null;
//
//            try {
//                object = (JSONObject) Parser.parse(read);
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//
//            JSONArray array = (JSONArray) object.get("arithmetic");
//
//            var iterator = array.iterator();
//
//            while (iterator.hasNext()) {
//                JSONObject temp = (JSONObject) iterator.next();
//                String result = temp.get("RawString").toString();
//                ArithmeticProcess ariphmeticParser = new ArithmeticProcess(result);
//                rezuList.add(ariphmeticParser.getResult());
//            }
//
//            Singleton.getInstance(rezuList);
//
//        } catch (FileNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        } catch (IOException exp) {
//            System.out.println(exp.getMessage());
//        } catch (NullPointerException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//    }
//
//}