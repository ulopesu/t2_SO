package src;

import src.Buffer;

class Producer implements Runnable {
    static Buffer buffer;
    static int nMessages;

    // CONSTRUTOR DA CLASSE PRODUCER.
    public Producer(Buffer buff) {
        buffer = buff;
    }

    public void run() {
        while (true) {
            try {
                // CRIA A MENSAGEM E JA INSERE NO BUFFER.
                buffer.inserir(createMsg());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            // GERA UM TEMPO DE SLEEP DE 1 ATÉ 5 SEGUNDOS, E SLEEP ESSE TEMPO.
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

    // CRIA A MENSAGEM
    private synchronized Message createMsg() {
        int min = 0;
        int max = 4;
        int priority = (int) (Math.random() * (max - min)) + min;
        String content = "Messsage: " + (nMessages++) + ".";
        Message msg = new Message(priority, content);
        //System.out.println("\n"+msg.getContent()+" Prioridade: "+msg.getPriority()+". Foi PRODUZIDA, pela "+Thread.currentThread().getName()+".");
        return msg;
    }

}