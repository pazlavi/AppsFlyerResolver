package com.appsflyer.resolver

fun interface AFResolverListener {
    fun onDeepLinkValueResolved(deepLinkValue: String?)
}