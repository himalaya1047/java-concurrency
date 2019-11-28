package com.chen.concurrency.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {

        Thread t = new Thread("READ-Thread"){
            @Override
            public void run() {
                printIn(Thread.currentThread().getName()); //main
                readFromDataBase();
            }
        };

        t.run();

//        new Thread("WRITE-Thread"){
//            @Override
//            public void run() {
//                writeDataToFile();
//            }
//        }.start();

//        try {
//            Thread.sleep(1000 * 300L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        readFromDataBase();
//        writeDataToFile();
    }

    private static void readFromDataBase(){
        try {
            printIn("Begin read data from db");
            Thread.sleep(1000 * 30L);
            printIn("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printIn("处理完并且是成功的");
    }

    private static void writeDataToFile(){
        try {
            printIn("Begin write data to File");
            Thread.sleep(1000 * 20L);
            printIn("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printIn("处理完并且是成功的");
    }

    private static void printIn(String msg){
        System.out.println(msg);
    }
}
