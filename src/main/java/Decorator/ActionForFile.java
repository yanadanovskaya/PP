package Decorator;

import java.io.File;
import java.io.IOException;
import Enum.Types;
import Enum.Actions;

public class ActionForFile {
    private final String path;
    private final Actions actions;
    private final Types archiveExtension;
    private DataDecorator dec;
    private File tempFile;

    public ActionForFile(String path, Actions actions, Types archiveExtension) {
        this.path = path;
        this.actions = actions;
        this.archiveExtension = archiveExtension;
    }

    public void CreateAction() throws IOException {

        tempFile = new File(path);

        if (actions.equals(Actions.ARCHIVING)) {
            dec = new Archival(
                    new FileSource(path, archiveExtension));
        }
        else if (actions.equals(Actions.ENCRYPT)) {
            dec = new FileEncrypt(
                    new FileSource(path, archiveExtension));
        }
        else if (actions.equals(Actions.ARCHIVING_AND_ENCRYPT)) {
            dec = new Archival(
                    new FileEncrypt(
                            new FileSource(path, archiveExtension)));
        }
        else if (actions.equals(Actions.ENCRYPT_AND_ARCHIVING)) {
            dec = new FileEncrypt(
                    new Archival(
                            new FileSource(path, archiveExtension)));
        }

    }

    public void start() throws Exception {
        dec.readData();
        dec.writeData();
        tempFile.createNewFile();
    }

}