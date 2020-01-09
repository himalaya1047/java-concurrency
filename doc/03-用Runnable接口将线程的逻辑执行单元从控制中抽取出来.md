---
title: 03-用Runnable接口将线程的逻辑执行单元从控制中抽取出来
tags: 新建,模板,小书匠
renderNumberedHeading: true
grammar_cjkRuby: true
---

### 使用Runnable 完善模拟银行叫号

#### Runnable类
```java
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
```

#### 银行类
```java
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
```