package Builder;

import Enum.Types;
//import com.cross_cutting.HelpfulThings.FilePath;
import Parsing.JsonParsing.JsonParser;
import Parsing.JsonParsing.JsonWrite;
import Parsing.TXTParsing.TxtParser;
import Parsing.TXTParsing.TxtWrite;
import Parsing.XMLParsing.XMLParser;
import Parsing.XMLParsing.XmlWrite;

public class ParserFiles {

    private String inPath;
    private String outPath;
    private Types inExtensions;
    private Types outExtensions;

    public ParserFiles (String inPath, String outPath) {

        FilePath filePath = new FilePath(inPath);
        this.inExtensions = filePath.getFileExtension();
        FilePath filePath1 = new FilePath(outPath);
        this.inPath = inPath;
        this.outPath = outPath;
        this.outExtensions = filePath1.getFileExtension();

    }

    public void Create(BuilderParserManager builderParserManager) {

        if(inExtensions.equals(Types.TXT)){
            builderParserManager.setParser(new TxtParser(inPath));
        }
        else if(inExtensions.equals(Types.XML)) {
            builderParserManager.setParser(new XMLParser(inPath));
        }
        else if(inExtensions.equals(Types.JSON)) {
            builderParserManager.setParser(new JsonParser(inPath));
        }
        if(outExtensions.equals(Types.TXT)){
            builderParserManager.setWriter(new TxtWrite(outPath));
        }
        else if(outExtensions.equals(Types.XML)) {
            builderParserManager.setWriter(new XmlWrite(outPath));
        }
        else if(outExtensions.equals(Types.JSON)) {
            builderParserManager.setWriter(new JsonWrite(outPath));
        }

    }

}