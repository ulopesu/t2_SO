package src;
import java.util.ArrayList;

import src.Buffer;

class trab2 {
    public static void main(String args[]) {
        // CRIA O BUFFER.
        Buffer buffer = new Buffer();
        ArrayList<Thread> producers = new ArrayList<>();
        ArrayList<Thread> consumers = new ArrayList<>();

        // CRIA OS PRODUTORES E CONSUMIDORES.
        createConsumers(consumers, buffer, 10);
        createProducers(producers, buffer, 10);

        // INICIA OS PRODUTORES E CONSUMIDORES.
        startConsumers(consumers, 10);
        startProducers(producers, 10);
    }
    
    // CRIA N CONSUMIDORES.
    private static void createConsumers(ArrayList<Thread> consumers, Buffer buffer, int n) {
        for(int i=0; i<n; i++){
            consumers.add(i, new Thread(new Consumer(buffer)));
        }
    }

    // INICIA N CONSUMIDORES.
    private static void startConsumers(ArrayList<Thread> consumers, int n){
        for(int i=0; i<n; i++){
            consumers.get(i).start();
        }
    }

    // CRIA N CONSUMIDORES.
    public static void createProducers(ArrayList<Thread> producers, Buffer buffer, int n) {
        for(int i=0; i<n; i++){
            producers.add(i, new Thread(new Producer(buffer)));
        }
    }

    // INICIA N PRODUTORES.
    public static void startProducers(ArrayList<Thread> producers, int n){
        for(int i=0; i<n; i++){
            producers.get(i).start();
        }
    }
}
