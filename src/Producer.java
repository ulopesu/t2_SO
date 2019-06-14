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
                buffer.inserir0(msg);
                break;
            case 1:
                buffer.inserir1(msg);
                break;
            case 2:
                buffer.inserir2(msg);
                break;
            case 3:
                buffer.inserir3(msg);
                break;
        }
    }

}