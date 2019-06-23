public class Consumer implements Runnable {
    static Buffer buffer;

    // CONSTRUTOR DA CLASSE CONSUMER.
    public Consumer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while (true) {
            try {
                // RETIRA MENSAGEM DO BUFFER.
                buffer.retirar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // GERA UM TEMPO DE SLEEP DE 1 ATÉ 5 SEGUNDOS, E SLEEP ESSE TEMPO.
            int min = 1000, max = 5000;
            int timeSleep = (int) ((Math.random() * (max - min)) + min);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}