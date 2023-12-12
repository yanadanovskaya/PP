//package Builder;
//
//import Parsing.TXTParsing.TxtParser;
//import Parsing.TXTParsing.TxtWrite;
//import Parsing.XMLParsing.XMLParser;
//
//public class ParserAndWriter  implements BuilderParserManager {
//
//        private XMLParser parser;
//        private TxtWrite writer;
//        private String inPath;
//        private String outPath;
//
//        @Override
//        public void setParser(TxtParser parser) {
//            this.parser = parser;
//        }
//
//        @Override
//        public void setWriter(TxtWrite writer) {
//            this.writer = writer;
//        }
//
//        @Override
//        public void setInPath(String inPath) {
//            this.inPath = inPath;
//        }
//
//        @Override
//        public void setOutPath(String outPath) {
//            this.outPath = outPath;
//        }
//
//        public XMLParser getParser() {
//            return parser;
//        }
//
//        public TxtWrite getWriter() {
//            return writer;
//        }
//
//    }
//
