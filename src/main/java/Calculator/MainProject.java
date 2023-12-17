package Calculator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProject {

    public class Main {

        public static void main(String[] args) throws InterruptedException {

            ExecutorService exec = Executors.newFixedThreadPool(10);
            int j = 0;

            while (j < 10) {
                j++;
                exec.execute(new ClientTester());
                Thread.sleep(10);
            }

            exec.shutdown();
        }
    }
}