package src;

import src.Buffer;

class Producer implements Runnable {
    static Buffer buffer;
    static int nMessages;

    public Producer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while(true){
            int min = 0;
            int max = 4;
            int priority = (int) (Math.random() * (max - min)) + min;
            String content = "Messsage: " + (nMessages++) + ".";
            Message msg = new Message(priority, content);
            try {
                buffer.inserir(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            min = 1000;
            max = 5000;
            int timeSleep = (int) ((Math.random() * (max - min)) + min);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}