package Decorator;

import Enum.Types;
import PathStrings.PathToFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archival extends DataDecorator {

    public static String archivePath;

    public Archival(DecoratorInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {

        System.out.println(FileSource.getFilePath().getPath());
        File file = new File(FileSource.getFilePath().getPath());

        System.out.println(FileSource.getFirstPath().getPath());
        System.out.println(FileSource.getFilePath().getPath());

        if (FileSource.getArchiveExtensions().equals(Types.ZIP)) {
            ZipArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Types.JAR)) {
            JarArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Types.RAR)) {
            RarArchiving();
        }


        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipArchiving() {

        try (ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".zip"));
             FileInputStream fis  = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".zip"));

            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void RarArchiving() {
        try (ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".rar"));
             FileInputStream fis  = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new PathToFile(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()));

            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void JarArchiving() {

        try (JarOutputStream jarOutputStream = new JarOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".jar"));
             FileInputStream fis = new FileInputStream(FileSource.getFilePath().getPath());) {

            JarEntry jarEntry = new JarEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".jar"));

            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getArchivePath() {
        return archivePath;
    }

    public static void setArchivePath(String archivePath) {
        Archival.archivePath = archivePath;
    }

}