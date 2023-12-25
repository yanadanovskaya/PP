package Calculator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProject {

    public static class Main {

        public static void main(String[] args) throws InterruptedException {

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int j = 0;

            while (j < 10) {
                j++;
                executorService.execute(new ClientTester());
                Thread.sleep(10);
            }

            executorService.shutdown();
        }
    }
}
