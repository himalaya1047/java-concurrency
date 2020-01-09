package com.chen.concurrency.chapter2;

public class BankVersion2 {

    public static void main(String[] args) {
        final TickWindowRunnable tickWindowRunnable = new TickWindowRunnable();
        Thread threadWindow1 = new Thread(tickWindowRunnable,"一号窗口");
        Thread threadWindow2 = new Thread(tickWindowRunnable,"二号窗口");
        Thread threadWindow3 = new Thread(tickWindowRunnable,"三号窗口");
        threadWindow1.start();
        threadWindow2.start();
        threadWindow3.start();
    }

}
