package Archiving;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchiving {

    private final String path;
    private final String name;

    public DeArchiving(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.path = path;
    }

    public void RarDeArchivation() {

        try (ZipInputStream zout = new ZipInputStream(new FileInputStream(this.name + ".rar"));
             FileOutputStream fout = new FileOutputStream("C:\\work\\untitled\\" + path)) {

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

                FileOutputStream fout = new FileOutputStream("C:\\work\\untitled\\" + Name);

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
             FileInputStream fis = new FileInputStream("resourses/" + path)) {
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
        DeArchiving deArchiving = new DeArchiving("src/res//orderout.zip");
        deArchiving.ZipDeArchiving();
    }


}