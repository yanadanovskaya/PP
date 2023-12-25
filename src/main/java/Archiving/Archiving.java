package Archiving;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiving {

    private final String path;
    private final String name;

    public Archiving(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.path = path;
    }

    public void ZipArchiving() {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\work\\untitled\\" + name + ".zip"));
             FileInputStream fis = new FileInputStream("C:\\work\\untitled\\" + path)) {

            ZipEntry entry1 = new ZipEntry(path);
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

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\work\\untitled\\" + name + ".rar"));
             FileInputStream fis = new FileInputStream("C:\\work\\untitled\\" + path)) {

            ZipEntry entry1 = new ZipEntry(path);
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

        try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream("C:\\work\\untitled\\" + name + ".jar"));
             FileInputStream fis = new FileInputStream("C:\\work\\untitled\\" + path)) {

            JarEntry jarEntry = new JarEntry(path);
            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Archiving archiving = new Archiving("src/res/orderout.zip");
        archiving.ZipArchiving();
    }

}
