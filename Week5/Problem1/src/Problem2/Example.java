package Problem2;

public class Example {
    public void tic() throws InterruptedException {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print("\nTic");
//                System.out.print("\nTic"+Thread.currentThread().getName());
                wait();
                notify();
            }
        }
    }

    public void toc() throws InterruptedException {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print("-Toc");
//                System.out.print("-Toc"+Thread.currentThread().getName());
                notify();
                wait();
//                Thread.sleep(2000);
            }
        }
    }
}
