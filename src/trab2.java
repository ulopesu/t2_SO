package src;
import java.util.ArrayList;

import src.Buffer;

class trab2 {
    public static void main(String args[]) {
        Buffer buffer = new Buffer();
        ArrayList<Thread> producers = new ArrayList<>();
        ArrayList<Thread> consumers = new ArrayList<>();

        createConsumers(consumers, buffer);
        createProducers(producers, buffer);
        startConsumers(consumers);
        startProducers(producers);
    }
    
    private static void createConsumers(ArrayList<Thread> consumers, Buffer buffer) {
        for(int i=0; i<1; i++){
            consumers.add(i, new Thread(new Consumer(buffer)));
        }
    }
    private static void startConsumers(ArrayList<Thread> consumers){
        for(int i=0; i<1; i++){
            consumers.get(i).start();
        }
    }

    public static void createProducers(ArrayList<Thread> producers, Buffer buffer) {
        for(int i=0; i<9; i++){
            producers.add(i, new Thread(new Producer(buffer)));
        }
    }
    public static void startProducers(ArrayList<Thread> producers){
        for(int i=0; i<9; i++){
            producers.get(i).start();
        }
    }
}
