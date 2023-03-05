package practice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NapTask implements Runnable, Callable<Integer> {
    int id;
    public NapTask(int i) {
        id=i;
    }

    @Override
    public void run() {
        try {
            new Nap(id);
            System.out.println(Thread.currentThread().getName() + " " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() {
        try {
            new Nap();
            System.out.println(Thread.currentThread().getName() + " " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int notCall(int i) {
        System.out.println(i);
        return i;
    }

    public static void main(String[] args) throws InterruptedException {

        // 单线程
        System.out.println("single thread");
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).mapToObj(NapTask::new).forEach(exec::execute);
        exec.shutdown();

        // 多线程
        System.out.println("multi thread");
        exec = Executors.newCachedThreadPool();
        List<NapTask> collect = IntStream.range(0, 10).mapToObj(NapTask::new).toList();
        List<Future<Integer>> futures = exec.invokeAll(collect);
        exec.shutdown();

        IntStream.range(0, 10).parallel().forEach(i->new NapTask(i).notCall(i));
    }
}
