package Problem2;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        final Example example = new Example();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    example.tic();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    example.toc();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
    }
}
