package com.appsflyer.resolver;

import static org.junit.Assert.assertEquals;

import androidx.annotation.NonNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UrlResolverJavaTest {
    @Test
    public  void testResolveUsingBitlyAndLambda(){
        AFHttp.INSTANCE.resolveDeepLinkValue("https://bit.ly/38JtcFq", 5 ,
                deepLinkValue -> assertEquals(deepLinkValue , "https://paz.onelink.me/waF3/paz"));
    }

    @Test
    public void testResolveUsingBitlyAndCallback(){
        AFHttp.INSTANCE.resolveDeepLinkValue("https://bit.ly/38JtcFq", 5, new AFResolverListener() {
            @Override
            public void onDeepLinkValueResolved( String deepLinkValue) {
                assertEquals(deepLinkValue , "https://paz.onelink.me/waF3/paz");

            }
        });
    }
}
