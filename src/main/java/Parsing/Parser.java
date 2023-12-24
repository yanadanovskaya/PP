package Parsing;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Parser {

    private static final ArrayList<Double> resuList = new ArrayList<>();

    private final String inPath;

    public Parser(String inPath) {
        this.inPath = inPath;
    }

    public abstract String parse(String s) throws ParserConfigurationException, SAXException, IOException;
    public abstract void write(String s, String text) throws ParserConfigurationException, SAXException, IOException;

    public String getInPath() {
        return inPath;
    }

    public static ArrayList<Double> getResList() {
        return resuList;
    }

}