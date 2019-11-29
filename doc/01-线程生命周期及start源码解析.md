---
title: 01-线程生命周期及start源码解析
renderNumberedHeading: true
grammar_cjkRuby: true
---

### 线程的生命周期
![enter description here](http://m.qpic.cn/psb?/V127THue4SJ8gD/mZjvIrdwacFhbW7bNzFQvHHLlJOj00d9pJXsM08UWkc!/b/dL8AAAAAAAAA&bo=zgTKAQAAAAADByM!&rf=viewer_4)

### 线程的启动 start()

```java
        new Thread("READ-Thread"){
            @Override
            public void run() {
                printIn(Thread.currentThread().getName()); //READ-Thread
                readFromDataBase();
            }
        }.start();
			
// 调用 start() 会开启两个线程 一个main 一个READ-Thread
```
#### 直接调用 run()
```java
        Thread t = new Thread("READ-Thread"){
            @Override
            public void run() {
                printIn(Thread.currentThread().getName()); //main
                readFromDataBase();
            }
        };

        t.run();
		
// 直接调用run() 只会开启一个线程 就是main
```
#### Thread 设计直接调用 run() 的好处
```java
package com.chen.concurrency.chapter1;

import sun.applet.resources.MsgAppletViewer;

public class TemplateMethod {

    public final void print(String msg){

        System.out.println("##################");
        wrapPrint(msg);
        System.out.println("##################");
    }

    protected void wrapPrint(String msg){

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("*" + msg + "*");
            }
        };

        t1.print("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("@" + msg + "@");
            }
        };

        t2.print("Hello Thread");
    }
}

```
**运行结果**
```javascript
##################
*Hello Thread*
##################
##################
@Hello Thread@
##################
```

### 总结
#### java应用程序的main函数是一个线程，是被JVM启动的时候调用，线程的名字叫main
#### 实现一个线程，必须创建Thread实例，override run方法，并且调用start方法
#### 在JVM启动后，实际上有多个线程，但是至少有一个非守护线程
#### 当你调用一个线程start方法的时候，此时至少有两个线程，一个是调用你的线程，还有一个是执行run方法的线程
#### 线程的生命周期分为new runnable running block termate

