package Decorator;

import PathStrings.PathToFile;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class FileEncrypt extends DataDecorator {

    private static Key key;

    public FileEncrypt(DecoratorInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {
        Encrypt();
        System.out.println("Encrypt part");
        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void Encrypt() throws Exception {

        try {
            Cipher cipher_encrypted   = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            key                       = keyGenerator.generateKey();

            cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);

            byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream(FileSource.getFilePath().getPath()).readAllBytes());
            FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/encrypted_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());
            FileSource.setPath(new PathToFile("src/res/archiveAndEncrypt/encrypted_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()));
            fileOutputStream.write(cipherText);
            fileOutputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

}