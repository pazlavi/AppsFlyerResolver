package com.appsflyer.resolverapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.resolver.AFHttp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AFHttp.debug = true
        AFHttp.init(this)
        AFHttp.resolveDeepLinkValue("dfcd"){ res ->
            res?.let {
                Log.d("TAG", "onCreate: $it")
            }
        }
    }
}