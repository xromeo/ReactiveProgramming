package com.rivera.callback2;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {

                    @Override
					public void pushData(String data) {
						System.out.println("CallBack data :" + data);
					}

					@Override
					public void pushComplete() {
						System.out.println("Callback done !");
						
					}

					@Override
					public void pushError(Exception ex) {
						System.out.println("Callback Error called, Got an Exception :" + ex);
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
        callBack.pushData("Data1");
		callBack.pushData("Data2");
		callBack.pushData("Data3");
		
		callBack.pushError(new RuntimeException("Oops!"));
		callBack.pushComplete();
    }
}
