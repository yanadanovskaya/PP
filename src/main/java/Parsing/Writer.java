package Parsing;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Writer {

    private static final ArrayList<Double> resultList = new ArrayList<>();
    private final String outPath;

    public Writer(String outPath) {
        this.outPath = outPath;
    }

    public abstract void write() throws IOException;

    public String getOutPath() {
        return outPath;
    }
}