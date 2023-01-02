package com.rivera.callback;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {

                    @Override
                    public void call(String data) {
                        System.out.println("Callback called!!! with data: " + data);
                    }
                    
                });
            }
        };

        Thread thread = new Thread(r);
        thread.start();

        Thread.sleep(2000);
        System.out.println(" Main thread completed.!");
    }

    public void runningAsync(CallBack callBack){
        System.out.println("Running in separate thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {            
            e.printStackTrace();
        }
        callBack.call("Zoe");
    }
}
