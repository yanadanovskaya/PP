import Parsing.XMLParsing.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Scanner in = new Scanner(System.in);
        System.out.print("Input filename in ('input', 'file'): ");
        String filename = in.nextLine();

        System.out.print("Input type of the file in (txt, xml, json): ");
        String filetype = in.nextLine();

        System.out.print("Input text in: ");
        String text = in.nextLine();

        XMLParser xmlParser = new XMLParser();

        xmlParser.write(filename+"."+filetype, text);

        String f = xmlParser.parse(filename+"."+filetype);
        System.out.print(f);
    }
}
