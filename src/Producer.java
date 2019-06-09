package src;

import src.Buffer;

class Producer implements Runnable {
    static Buffer buffer;
    static int nMessages;

    public Producer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        int min = 0, max = 4;
        while(true){
            int priority = (int) (Math.random() * (max - min)) + min;
            String content = "Messsage: " + (nMessages++) + ".";
            Message msg = new Message(priority, content);
            try {
                buffer.inserir(msg);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}