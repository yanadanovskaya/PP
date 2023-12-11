package Parsing.TXTParsing;

import ArithmeticOperations.ArithmeticProcess;
import Parsing.Singleton;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TxtParser extends Parser {

    private ArrayList<Double> rezuList = new ArrayList<>();

    public TxtParser(String inPath) {
        super(inPath);
    }

    @Override
    public void parse() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(getInPath()))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                ArithmeticProcess parser = new ArithmeticProcess(temp);
                rezuList.add(parser.getResult());
            }

            Singleton.getInstance(rezuList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}