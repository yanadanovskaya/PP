package PathStrings;
import Enum.Types;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PathToFile {

    private static String name;
    private static String path;
    private static String extension;
    private static String firstExtension;
    private static String firstName;
    private static Types fileExtension;

    public PathToFile(String path) {

        StringTokenizer tokenizer = new StringTokenizer(path, "/\\");
        ArrayList<String> temp = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            temp.add(tokenizer.nextToken());
        }

        String[] NameAndExtension = temp.get(temp.size() - 1).replace(".", " ").split(" ");

        this.path = path;
        this.name = NameAndExtension[0];
        this.extension = NameAndExtension[1];
        this.firstExtension = this.extension;


        if(extension.equals("txt")){
            this.fileExtension = Types.TXT;
        }
        else if(extension.equals("json")) {
            this.fileExtension = Types.JSON;
        }
        else if(extension.equals("xml")) {
            this.fileExtension = Types.XML;
        }

        System.out.println(fileExtension);

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFirstExtension() {
        return firstExtension;
    }

    public void setFirstExtension(String firstExtension) {
        this.firstExtension = firstExtension;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Types getFileExtension() {
        return fileExtension;
    }
}