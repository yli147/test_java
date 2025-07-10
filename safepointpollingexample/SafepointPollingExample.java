public class SafepointPollingExample {
    public static void main(String[] args) {
        int numThreads = 100;
        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker()).start();
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                // Simulate work by allocating objects
                for (int i = 0; i < 1000; i++) {
                    Object obj = new Object();
                    Math.sqrt(i); // Simulate some computation
                }
                // Force garbage collection
                System.gc();
            }
        }
    }
}
