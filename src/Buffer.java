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

    void inserir (Message message){
        int priority = message.getPriority();
        if (messageQueue.get(priority).size()<3) {
            messageQueue.get(priority).add(message);
        } else {
            //BLOQUEAR Producer
            this.inserir(message);
        }
    }

    Message retirar () {
        for (Queue<Message> queue : messageQueue) {
            if(!queue.isEmpty()){
                return queue.remove();
            }
        }

        //BLOQUEAR Consumer
        return this.retirar();
    }
    
}