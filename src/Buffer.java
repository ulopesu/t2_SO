package src;

import src.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;


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
            System.out.println("\n"+message.getContent()+message.getPriority()+" foi inserida no BUFFER!   ");
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
                System.out.println("\n"+msg.getContent()+msg.getPriority()+" foi removida do BUFFER!   ");
                notifyAll();
                return msg;
            }
        }

        wait(); //BLOQUEAR Consumer
        return this.retirar();
    }
    
}