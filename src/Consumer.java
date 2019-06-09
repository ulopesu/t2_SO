package src;

import src.Buffer;

class Consumer implements Runnable {
    static Buffer buffer;

    public Consumer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while(true){
            try {
                buffer.retirar();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}