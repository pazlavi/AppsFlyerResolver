package com.appsflyer.resolver

import android.util.Log
import kotlinx.coroutines.runBlocking
import java.net.CookieHandler
import java.net.CookieManager
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit

class URLResolver(var debug: Boolean) {
    constructor() : this(false)

    init {
        CookieHandler.setDefault(CookieManager())
    }

    suspend fun resolve(
        url: String?,
        maxRedirections: Int = 10,
    ): String? {
        if (url == null) {
            return null
        }
        afDebugLog("resolving $url")
        return if (url.isValidURL()) {
            val redirects = ArrayList<String>().apply {
                add(url)
            }
            var res: AFHttpResponse? = null
            for (i in 0 until maxRedirections) {
                // resolve current URL - check for redirection
                res = resolveInternal(redirects.last())
                res.redirected?.let { // if redirected to another URL
                    redirects.add(it)
                } ?: break
            }

            if (res?.error == null) {
                afDebugLog("found link: ${redirects.last()}")
                redirects.last()
            } else null
        } else {
            url
        }

    }

    private fun resolveInternal(uri: String): AFHttpResponse {
        val res = AFHttpResponse()
        try {
            (URL(uri).openConnection() as HttpURLConnection).run {
                instanceFollowRedirects = false
                readTimeout = TimeUnit.SECONDS.toMillis(2).toInt()
                connectTimeout = TimeUnit.SECONDS.toMillis(2).toInt()
                val responseCode = responseCode
                res.status = responseCode
                if (responseCode in 300..308) {
                    // redirect
                    res.redirected = getHeaderField("Location")
                    afDebugLog("redirecting to ${res.redirected}")
                }
                disconnect()
            }
        } catch (e: Throwable) {
            res.error = e.localizedMessage
            afErrorLog(e.message, e)
        }
        return res
    }

    fun resolveSync(
        url: String?,
        maxRedirections: Int = 10,
    ) = runBlocking { resolve(url, maxRedirections) }

    private fun afDebugLog(msg: String) {
        if (debug) Log.d("AppsFlyer_Resolver", msg)
    }

    private fun afErrorLog(msg: String?, e: Throwable) {
        if (msg != null) Log.d("AppsFlyer_Resolver", msg)
        e.printStackTrace()
    }

    private fun String.isValidURL(): Boolean {
        val regex =
            Regex("^(http|https)://(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(/|/([\\w#!:.?+=&%@\\-/]))?")
        return regex.matches(this)
    }
}