package src;

import src.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Buffer {
    private static ArrayList <Queue<Message>> messageQueue= new ArrayList<>();
    private static int globalOrd=0;
    private static int currentOrd=0;
    private int myOrd;
    

    public Buffer () {
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
    }

    public ArrayList <Queue<Message>> getMessages () {
        return messageQueue;
    }

    private synchronized void setMyOrd(){
        this.myOrd = globalOrd++;
    }

    private synchronized void setCurrentOrd(){
        currentOrd++;
    }

    public synchronized void inserir (Message message) throws InterruptedException {
        setMyOrd();
        int priority = message.getPriority();
        if (messageQueue.get(priority).size()<3 && (this.myOrd == currentOrd)) {
            messageQueue.get(priority).add(message);
            System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA no Buffer, pela "+Thread.currentThread().getName()+".");
            setCurrentOrd();
            notifyAll();
        } else {
            System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". "+Thread.currentThread().getName()+": DORMINDO!!!.");
            wait(); //BLOQUEAR Producer
            this.inserir(message);
        }
    }        

    public synchronized Message retirar () throws InterruptedException {
        for (Queue<Message> queue : messageQueue) {
            if(!queue.isEmpty()){
                Message msg = queue.remove();
                System.out.println("\n"+msg.getContent()+" Prioridade: "+msg.getPriority()+". Foi REMOVIDA do Buffer, pela "+Thread.currentThread().getName()+".");
                notifyAll();
                return msg;
            }
        }
        wait(); //BLOQUEAR Consumer
        return this.retirar();
    }
}