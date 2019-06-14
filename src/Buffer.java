package src;

import src.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Buffer {
    private static ArrayList <Queue<Message>> messageQueue= new ArrayList<>();

    public Buffer () {
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
        messageQueue.add(new LinkedList<>());
    }

    public ArrayList <Queue<Message>> getMessages () {
        return messageQueue;
    }

    public synchronized void inserir0 (Message message) throws InterruptedException {
        int priority = 0;
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
            //System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA no Buffer, pela "+Thread.currentThread().getName()+".");
            notifyAll();
        } else {
            System.out.println("\nBloqueando Producer: "+Thread.currentThread().getName()+".");
            wait(); //BLOQUEAR Producer
            System.out.println("\nDesbloqueando Producer: "+Thread.currentThread().getName()+".");
            this.inserir0(message);
        }
    }     

    public synchronized void inserir1 (Message message) throws InterruptedException {
        int priority = 1;
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
            //System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA no Buffer, pela "+Thread.currentThread().getName()+".");
            notifyAll();
        } else {
            System.out.println("\nBloqueando Producer: "+Thread.currentThread().getName()+".");
            wait(); //BLOQUEAR Producer
            System.out.println("\nDesbloqueando Producer: "+Thread.currentThread().getName()+".");
            this.inserir1(message);
        }
    }     

    public synchronized void inserir2 (Message message) throws InterruptedException {
        int priority = 2;
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
            //System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA no Buffer, pela "+Thread.currentThread().getName()+".");
            notifyAll();
        } else {
            System.out.println("\nBloqueando Producer: "+Thread.currentThread().getName()+".");
            wait(); //BLOQUEAR Producer
            System.out.println("\nDesbloqueando Producer: "+Thread.currentThread().getName()+".");
            this.inserir2(message);
        }
    }     

    public synchronized void inserir3 (Message message) throws InterruptedException {
        int priority = 3;
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
            //System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA no Buffer, pela "+Thread.currentThread().getName()+".");
            notifyAll();
        } else {
            System.out.println("\nBloqueando Producer: "+Thread.currentThread().getName()+".");
            wait(); //BLOQUEAR Producer
            System.out.println("\nDesbloqueando Producer: "+Thread.currentThread().getName()+".");
            this.inserir3(message);
        }
    }     

    public synchronized Message retirar () throws InterruptedException {
        for (Queue<Message> queue : messageQueue) {
            if(!queue.isEmpty()){
                Message msg = queue.remove();
                System.out.println("\n"+msg.getContent()+" Prioridade: "+msg.getPriority()+". Foi CONSUMIDA, pela "+Thread.currentThread().getName()+".");
                notifyAll();
                return msg;
            }
        }
        System.out.println("\nBloqueando Consumer: "+Thread.currentThread().getName()+".");
        wait(); //BLOQUEAR Consumer
        System.out.println("\nDesbloqueando Consumer: "+Thread.currentThread().getName()+".");
        return this.retirar();
    }
}