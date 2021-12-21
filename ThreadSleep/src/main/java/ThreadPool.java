import java.util.concurrent.*;

public class ThreadPool {
    /**
     * 自从Java1.5之后，Java 提供了自己的线程池ThreadPoolExecutor和ScheduledThreadPoolExecutor
     */
    public static void main(String[] args) {
        /**
         *   public ThreadPoolExecutor(int corePoolSize,
         *                                  int maximumPoolSize,
         *                                  long keepAliveTime,
         *                                  TimeUnit unit,
         *                                  BlockingQueue<Runnable> workQueue,
         *                                  ThreadFactory threadFactory,
         *                                RejectedExecutionHandler handler)
         *corePoolSize：线程池维护线程的最少数量
         * maximumPoolSize：线程池维护线程的最大数量
         * keepAliveTime：线程池维护线程所允许的空闲时间 ，所以如果任务很多，并且每个任务执行的时间比较短，可以适当调大这个参数来提高线程的利用率。
         * unit： keepAliveTime 参数的单位，可选的单位：天（DAYS），小时（HOURS），分钟（MINUTES），毫秒(MILLISECONDS)，微秒(MICROSECONDS)和纳秒(NANOSECONDS)
         * workQueue：任务队列，用来存放我们所定义的任务处理线程，BlockingQueue是一种带锁的阻塞队列，我们将在后面专门讲解这种数据结构，BlockingQueue有四种选择：
         * （1）ArrayBlockingQueue，是一种基于数组的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行操作；
         * （2）LinkedBlockingQueue，是一个基于链表的阻塞队列，此队列也按FIFO （先进先出）对元素进行操作，吞吐量通常要高于ArrayBlockingQueue， Executors.newFixedThreadPool()使用了这种队列；
         * （3）SynchronousQueue；是一种不存储元素的阻塞队列，每个插入操作必须等另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，Executors.newCachedThreadPool使用了这个队列；
         * （4）PriorityBlockingQueue，是一种具有优先权的阻塞队列，优先级大的任务可以先执行，用户由此可以控制任务的执行顺序。这四种阻塞队列都有自己的使用场景，用户可以根据需要自己决定使用。
         * threadFactory：创建新线程时使用的工厂，threadFactory有两种选择：
         * （1）DefaultThreadFactory，将创建一个同线程组且默认优先级的线程；
         * （2）PrivilegedThreadFactory，使用访问权限创建一个权限控制的线程。ThreadPoolExecutor默认采用DefaultThreadFactory。
         * handler 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理策略，handler有四个选择：
         * （1）ThreadPoolExecutor.AbortPolicy()，将抛出RejectedExecutionException异常；
         * （2）ThreadPoolExecutor.CallerRunsPolicy()，将重试添加当前的任务，重复调用execute()方法；
         * （3）ThreadPoolExecutor.DiscardOldestPolicy()，将抛弃旧任务；
         * （4）ThreadPoolExecutor.DiscardPolicy，将直接抛弃任务。ThreadPoolExecutor默认采用AbortPolicy。
         */
        // 创建线程池 最原始的方法. Method 1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        });
        // ···  thread
        threadPool.execute(thread1);

        // Method 2 其实Executors.newFixedThreadPool就是封装了一下ThreadPoolExecutor的构造方法.
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(thread1);

    }
}
