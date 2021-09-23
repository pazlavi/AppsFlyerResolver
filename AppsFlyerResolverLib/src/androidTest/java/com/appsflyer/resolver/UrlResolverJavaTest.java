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
       String res =  new AFHttp().resolveDeepLinkValueSync("https://bit.ly/38JtcFq", 5 );
                assertEquals(res , "https://paz.onelink.me/waF3/paz");
    }

    @Test
    public void testResolveUsingBitlyAndCallback(){
        String res =  new AFHttp().resolveDeepLinkValueSync("https://bit.ly/38JtcFq", 5 );
        assertEquals(res , "https://paz.onelink.me/waF3/paz");
    }
}
