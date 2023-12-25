package Parsing.TXTParsing;

import ArithmeticOperations.ArithmeticProcess;
import Parsing.Singleton;

import javax.swing.text.html.parser.DTD;
import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class TxtParser extends Parser implements TxtParserr {

    private ArrayList<Double> resultList = new ArrayList<>();
    private String inPath;

    public TxtParser(String inPath) throws IOException {
        super(DTD.getDTD(inPath));
    }

    @Override
    public void parse() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(getInPath()))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                ArithmeticProcess parser = new ArithmeticProcess(temp);
                resultList.add(parser.getResult());
            }

            Singleton.getInstance(resultList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getInPath() {
        return inPath;
    }

    public void setInPath(String inPath) {
        this.inPath = inPath;
    }
}