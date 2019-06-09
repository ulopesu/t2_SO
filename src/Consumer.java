package src;

import src.Buffer;

class Consumer implements Runnable {
    static Buffer buffer;

    public Consumer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while (true) {
            try {
                buffer.retirar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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