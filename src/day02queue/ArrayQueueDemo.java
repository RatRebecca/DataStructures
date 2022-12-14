package day02queue;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.Scanner;

/**
 * 使用数组模拟队列
 *
 * @Author weipeng
 * @Date 2022/12/14 21:37
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (true){

        }
    }
}

class ArrayQueue {
    private int maxSize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据,模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾部
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满,不能添加数据");
            return;
        }
        rear++; //rear 后移
        arr[rear] = n;
    }

    //获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        return arr[front + 1];
    }
}
