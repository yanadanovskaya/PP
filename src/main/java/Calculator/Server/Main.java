package Calculator.Server;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/res/test.txt");

        Client clientSend = new Client();
        clientSend.connectSocketServer(7890);

        System.out.println("zzz");

        String flag = "";
        clientSend.sendFile(file, flag);
        clientSend.clientStop();

        System.out.println("zzz");

        Client clientGet = new Client();
        clientGet.connectSocketServer(7891);
        System.out.println("Please wait");
        clientGet.getFile();

        System.out.println("Done!");
        clientGet.clientStop();
    }

}
