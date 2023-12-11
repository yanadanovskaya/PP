package Parsing.TXTParsing;

import Parsing.Singleton;
import Parsing.Writer;

import javax.annotation.processing.FilerException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWrite extends Writer {

    public TxtWrite(String outPath) {
        super(outPath);
    }

    @Override
    public void write() throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(getOutPath()));) {

            for (var id : Singleton.Data) {
                buffer.write(id.toString() + "\n");
            }

        } catch (FilerException e) {
            System.out.println(e.getMessage());
        }
    }

}