package com.appsflyer.resolverapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.resolver.AFHttp
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       runBlocking {
           AFHttp()
               .resolveDeepLinkValue("dfcd")
               }

        val a = AFHttp().resolveDeepLinkValueSync("d",5)
       }

    }
