package com.basic.thread;

/**
 * @author htj
 * @since 2019/6/10 9:23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by TF016591 on 2017/11/8.
 */
public class CountTaskTmp extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 500000;
    private int start;
    private int end;
    private List<Integer> list;

    public CountTaskTmp(int start, List<Integer> end) {
        this.start = start;
        this.end = end.size();
        this.list = end;
    }

    // 实现compute 方法来实现任务切分和计算
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <  end; i++)
                sum += list.get(i);
        } else {
            // 如果任务大于阀值，就分裂成两个子任务计算
            int mid = (start + end) / 2;

            CountTaskTmp leftTask = new CountTaskTmp(start, list.subList(start,mid));
            CountTaskTmp rightTask = new CountTaskTmp(mid, list.subList(mid,list.size()));

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完，并得到结果
            int leftResult = (int)leftTask.join();
            int rightResult = (int)rightTask.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = 0;
        int start = 0;
        int end = 1000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            list.add(i);
        }
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        // 使用ForkJoinPool来执行任务
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算资格，负责计算1+2+3+4
        CountTaskTmp task = new CountTaskTmp(start, list);

        Integer r = forkJoinPool.invoke(task);
        System.out.println(r);
        endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        // 或者可以这样写
        // Future<Integer> result = forkJoinPool.submit(task);
        // try {
        // System.out.println(result.get());
        // } catch (Exception e) {
        // }

    }
}
