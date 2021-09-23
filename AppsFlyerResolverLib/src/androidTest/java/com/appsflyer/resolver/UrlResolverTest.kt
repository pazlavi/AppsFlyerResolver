package com.appsflyer.resolver

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UrlResolverTest {

    @Test
    fun  testResolveUsingBitlyAndLambda(){
        runBlocking{
            val res =  URLResolver().resolve("https://bit.ly/38JtcFq", 5)
            assertEquals(res , "https://paz.onelink.me/waF3/paz")
        }


    }

    @Test
    fun  testResolveMILink(){
        runBlocking{
            val res =  URLResolver().resolve( "https://mi.gap.com/p/cp/d46c31d50872e4b3/c?mi_u=51635872&EV=GPUSCPATHTSTPC4048593PERST1_WMNNLPSPRP04162021&DI=51635872&CD=GPNC_GPR&cvosrc=email.exacttarget.GPUS04162021&EV_Segment1=GPUSGWMET&url=https%3A%2F%2Fmi.gap.com%2Fp%2Frp%2F6d2aa0caedfe8322%2Furl&mi_u=%%email_key%%&EV=%%EV_value%%&DI=%%DI_value%%&CD=%%CD_value%%", 5)
            assertEquals(res , "https://www.gap.com/?mi_u=%25%25email_key%25%25&EV=%25%25EV_value%25%25&DI=%25%25DI_value%25%25&CD=%25%25CD_value%25%25&cvosrc=email.exacttarget.GPUS04162021")
        }

    }

    @Test
    fun  testResolveUsingBitlyAndCallback(){
          runBlocking{
              val res = URLResolver().resolve("https://bit.ly/38JtcFq", 5)
            assertEquals(res , "https://paz.onelink.me/waF3/paz")

        }


    }

    @Test
    fun  testResolveUsingBitlyAndCallbackObject(){
        runBlocking{
            val res =  URLResolver().resolve("https://bit.ly/38JtcFq", 5)
            assertEquals(res , "https://paz.onelink.me/waF3/paz")
        }


    }

    @Test
    fun  testNullURL(){
        runBlocking{
            val res =  URLResolver().resolve(null, 5)
            assertEquals(res , null)
        }

    }

    @Test
    fun  testNotaURL(){
        runBlocking{
            val res =  URLResolver().resolve("abcd", 5)
            assertEquals(res , "abcd")
        }

    }

    @Test
    fun  testEmptyString(){
        runBlocking{
            val res =  URLResolver().resolve("", 5)
            assertEquals(res , "")
        }

    }

    @Test
    fun  testWhenURLisEncoded(){
        runBlocking{
            val res =  URLResolver().resolve("https%3A%2F%2Fmi.gap.com%2Fp%2Fcp%2Fd46c31d50872e4b3%2Fc%3Fmi_u%3D51635872%26EV%3DGPUSCPATHTSTPC4048593PERST1_WMNNLPSPRP04162021%26DI%3D51635872%26CD%3DGPNC_GPR%26cvosrc%3Demail.exacttarget.GPUS04162021%26EV_Segment1%3DGPUSGWMET%26url%3Dhttps%253A%252F%252Fmi.gap.com%252Fp%252Frp%252F6d2aa0caedfe8322%252Furl%26mi_u%3D%25%25email_key%25%25%26EV%3D%25%25EV_value%25%25%26DI%3D%25%25DI_value%25%25%26CD%3D%25%25CD_value%25%25\"", 5)
            assertEquals(res , "https%3A%2F%2Fmi.gap.com%2Fp%2Fcp%2Fd46c31d50872e4b3%2Fc%3Fmi_u%3D51635872%26EV%3DGPUSCPATHTSTPC4048593PERST1_WMNNLPSPRP04162021%26DI%3D51635872%26CD%3DGPNC_GPR%26cvosrc%3Demail.exacttarget.GPUS04162021%26EV_Segment1%3DGPUSGWMET%26url%3Dhttps%253A%252F%252Fmi.gap.com%252Fp%252Frp%252F6d2aa0caedfe8322%252Furl%26mi_u%3D%25%25email_key%25%25%26EV%3D%25%25EV_value%25%25%26DI%3D%25%25DI_value%25%25%26CD%3D%25%25CD_value%25%25\"")
        }

    }
}