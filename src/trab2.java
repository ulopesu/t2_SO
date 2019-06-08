package src;
import java.util.ArrayList;

import src.Buffer;

class trab2 {
    public static void main(String args[]) {
        Buffer buffer = new Buffer();
        ArrayList<Thread> producers = new ArrayList<>();
        ArrayList<Thread> consumers = new ArrayList<>();

        this.createProducers(producers);
        this.createConsumers(consumers);

        this.startProducers(producers);
        this.startConsumers(consumers);
        


        /* 
        buffer.inserir(new Message(3, "HEHEEH"));
        System.out.println(buffer.getMessages());
        buffer.retirar();
        System.out.println(buffer.getMessages());
        */
    }
    private void createConsumers(ArrayList<Thread> consumers, Buffer buffer) {
        for(int i=0; i<9; i++){
            consumers.add(i, new Thread(new Consumer(buffer)));
        }

    }
    private void createProducers(ArrayList<Thread> producers, Buffer buffer) {
        for(int i=0; i<9; i++){
            producers.add(i, new Thread(new Producer(buffer)));
        }
    }

    private void startConsumers(ArrayList<Thread> consumers){
        for(int i=0; i<9; i++){
            consumers.get(i).start();
        }
    }
    private void startProducers(ArrayList<Thread> producers){
        for(int i=0; i<9; i++){
            producers.get(i).start();
        }
    }
}
