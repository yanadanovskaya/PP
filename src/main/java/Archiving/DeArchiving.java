package Archiving;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchiving {

    private String path;
    private String name;
    private String extension;

    public DeArchiving(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.extension = arr[1];
        this.path = path;
    }

    public void RarDeArchivation() {

        try (ZipInputStream zout = new ZipInputStream(new FileInputStream(this.name + ".rar"));
             FileOutputStream fout = new FileOutputStream("src/res/" + path);) {

            for (int c = zout.read(); c != -1; c = zout.read()) {
                fout.write(c);
            }
            fout.flush();
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void ZipDeArchiving() {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(path))) {

            ZipEntry entry;
            String Name;

            while ((entry = zin.getNextEntry()) != null) {

                Name = entry.getName();

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/" + Name);

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


    public void JarDeArchiving() {

        try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(this.name + ".jar"));
             FileInputStream fis = new FileInputStream("resourses/" + path);) {
            JarEntry jarEntry = new JarEntry(path);
            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        DeArchiving deArchiving = new DeArchiving("src/res/archiveAndEncrypt/archived_res.zip");
        deArchiving.ZipDeArchiving();
    }


}