package com.rivera.flowable;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure2 {
    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is : " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(
                    new Subscriber<Integer>() {

                        Subscription s;
                        AtomicInteger count = new AtomicInteger(0);
                        @Override
                        public void onComplete() {
                         System.out.println("Completed");
                        }

                        @Override
                        public void onError(Throwable t) {
                            t.printStackTrace();
                        }

                        @Override
                        public void onNext(Integer t) {
                            
                            if(count.getAndIncrement() % 20 == 0){
                                System.out.println("Asking for next 20 items ");
                                s.request(20);
                            }
                            sleep(100);
                        }

                        @Override
                        public void onSubscribe(Subscription s) {
                            this.s = s;
                            System.out.println("Asking for 20 items ");
                            s.request(20);
                            
                        }
                        
                    }
                );

        sleep(1000000000);

    }

    private static void sleep(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
