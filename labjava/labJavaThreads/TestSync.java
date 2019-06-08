public class TestSync {
   public static void main(String [] args  )  {
	 MyMonitor m1= new MyMonitor();
	 MyMonitor m2= new MyMonitor();
	 MyThread t1 = new MyThread(m1,1);
	 MyThread t2 = new MyThread(m2,2);
   }
}

class MyThread extends Thread {
    MyMonitor monitor; 
    int method;

    MyThread(MyMonitor monitor, int method) {
        this.monitor=monitor; this.method = method; start();
    }
    public void run() {
       if(method==1) monitor.method1();
       else if (method==2) monitor.method2();
    }
}

class MyMonitor {   // the 'monitor'
    public synchronized void method1( ) {
       for (int i = 0; i < 1000; i++) {
          System.out.print("1"); 
       }

     } //... 

    public synchronized void method2( ) {
       for (int i = 0; i < 1000; i++){ 
          System.out.print("2");
       }
    }
}
