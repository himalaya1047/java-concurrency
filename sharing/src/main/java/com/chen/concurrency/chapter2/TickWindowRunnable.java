package com.chen.concurrency.chapter2;

public class TickWindowRunnable implements Runnable {

    private int index = 1;

    private static final int max = 50;

    @Override
    public void run() {

        while (index <= max){

            System.out.println(Thread.currentThread() + "柜台号码是：" + (index++) );

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
