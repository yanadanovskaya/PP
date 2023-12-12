package Decorator;

import PathStrings.PathToFile;
import Enum.Types;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchival extends DataDecorator {

    public DeArchival(DecoratorInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {

        if (FileSource.getArchiveExtensions().equals(Types.ZIP)) {
            ZipDeArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Types.JAR)) {
            JarDeArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Types.RAR)) {
            RarDeArchiving();
        }

        System.out.println("DeArchiving part");

        super.writeData();

    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipDeArchiving() {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {

            ZipEntry entry;
            String Name;

            while ((entry = zin.getNextEntry()) != null) {

                Name = entry.getName();

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/new_" + Name);

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/new_" + Name));

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    public void RarDeArchiving() {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {
            ZipEntry entry;
            String Name;

            while ((entry = zin.getNextEntry()) != null) {

                Name = entry.getName();

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/new_" + Name);

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/new_" + Name));

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void JarDeArchiving() {

        try (JarInputStream zin = new JarInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {
            JarEntry entry;
            String Name;

            while ((entry = (JarEntry) zin.getNextEntry()) != null) {

                Name = entry.getName();

                FileOutputStream fout = new FileOutputStream( "src/res/archiveAndEncrypt/new_" + Name);
                FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/new_" + Name));

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}