package Decorator;

import Enum.Types;
import PathStrings.PathToFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSource implements DecoratorInterface {

    private static PathToFile path;
    private static PathToFile firstPath;
    private static Types archiveExtensions;

    public FileSource(String path, Types archiveExtensions) {
        this.path             = new PathToFile(path);
        this.archiveExtensions = archiveExtensions;
        this.firstPath = new PathToFile(path);
    }

    public static PathToFile getFirstPath() {
        return firstPath;
    }

    public static void setExtension(String extension) {
        FileSource.path.setExtension(extension);
    }

    public static PathToFile getFilePath() {
        return path;
    }

    public static void setPath(PathToFile path) {
        FileSource.path = path;
    }


    public static Types getArchiveExtensions() {
        return archiveExtensions;
    }

    @Override
    public void writeData() {
        System.out.println("Finish");
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(path.getPath());
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }


}