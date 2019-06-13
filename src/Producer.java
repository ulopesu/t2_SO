package src;

import src.Buffer;

class Producer implements Runnable {
    static Buffer buffer;
    static int nMessages;

    public Producer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while (true) {
            try {
                insertMsg(createMsg());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            int min = 1000;
            int max = 5000;
            int timeSleep = (int) ((Math.random() * (max - min)) + min);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized Message createMsg() {
        int min = 0;
        int max = 4;
        int priority = (int) (Math.random() * (max - min)) + min;
        String content = "Messsage: " + (nMessages++) + ".";
        Message msg = new Message(priority, content);
        System.out.println("\n"+msg.getContent()+" Prioridade: "+msg.getPriority()+". Foi PRODUZIDA, pela "+Thread.currentThread().getName()+".");
        return msg;
    }

    private void insertMsg(Message msg) throws InterruptedException {
        int priority = msg.getPriority();
        switch (priority) {
            case 0:
                inserir0(msg);
                break;
            case 1:
                inserir1(msg);
                break;
            case 2:
                inserir2(msg);
                break;
            case 3:
                inserir3(msg);
                break;
        }
    }

    private static synchronized void inserir0(Message msg) throws InterruptedException {
        buffer.inserir(msg);
    }

    private static synchronized void inserir1(Message msg) throws InterruptedException {
        buffer.inserir(msg);
    }

    private static synchronized void inserir2(Message msg) throws InterruptedException {
        buffer.inserir(msg);
    }

    private static synchronized void inserir3(Message msg) throws InterruptedException {
        buffer.inserir(msg);
    }
}