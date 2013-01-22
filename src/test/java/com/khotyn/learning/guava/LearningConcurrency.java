package com.khotyn.learning.guava;

import com.google.common.util.concurrent.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * 测试 Guava 对 J.U.C 的封装
 *
 * @author khotyn 13-1-22 PM10:16
 */
public class LearningConcurrency {
    private static boolean success = false;
    private static boolean fail = false;

    @Test
    public void testListenableFuture() {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> listenableFuture = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello, world";
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                success = true;
            }

            @Override
            public void onFailure(Throwable throwable) {
                fail = true;
            }
        });
        Assert.assertEquals(true, success);
        Assert.assertEquals(false, fail);

    }

}
