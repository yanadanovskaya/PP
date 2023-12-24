package Parsing.XMLParsing;

import ArithmeticOperations.ArithmeticProcess;
import Parsing.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser extends Parser {
    private static final ArrayList<Double> resuList = new ArrayList<>();

    public XMLParser(String inPath) {
        super(inPath);
    }


    @Override
    public String parse(String s) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HEXParse par = new HEXParse();
        System.out.println(getInPath());
        parser.parse(new File(getInPath()), par);
        return s;
    }

    @Override
    public void write(String s, String text) throws ParserConfigurationException, SAXException, IOException {

    }

    private static class HEXParse extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("RawString")) {
                String str = attributes.getValue("str");
                ArithmeticProcess arithmeticProcess = new ArithmeticProcess(str);
                resuList.add((Double) arithmeticProcess.getResult());
            }
        }

    }

}