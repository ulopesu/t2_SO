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

    synchronized void inserir (Message message) throws InterruptedException {
        int priority = message.getPriority();
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
            System.out.println("\n"+message.getContent()+" Prioridade: "+message.getPriority()+". Foi INSERIDA do Buffer, pela "+Thread.currentThread().getName()+".");
            notifyAll();
        } else {
            wait(); //BLOQUEAR Producer
            this.inserir(message);
        }
    }

    synchronized Message retirar () throws InterruptedException {
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