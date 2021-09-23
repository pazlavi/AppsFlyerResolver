# AppsFlyer URL Resolver

## Integration  
  
Add it in your root build.gradle at the end of repositories:  
```css  
   allprojects {  
      repositories {  
         ...  
         maven { url 'https://jitpack.io' }  
      }  
   }  
```  
Add the dependency  
  
```css  
   dependencies {  
	     implementation 'com.github.pazlavi:AppsFlyerResolver:0.0.1-V6'
   }  
```

## Kotlin
```kotlin
   override fun onDeepLinking(deepLinkResult: DeepLinkResult) {
        if (deepLinkResult.status == DeepLinkResult.Status.FOUND) {
            runBlocking(Dispatchers.IO) {
                val url = URLResolver().resolve(deepLinkResult.deepLink?.deepLinkValue, 7)
                Log.d(TAG, "final URL: $url")
            }
        }
    }
```

## Java

```java
        @Override
        public void onDeepLinking(@NonNull DeepLinkResult deepLinkResult) {
            if (deepLinkResult.getStatus() == DeepLinkResult.Status.FOUND) {
                String url = new URLResolver().resolveSync(deepLinkResult.getDeepLink().getDeepLinkValue(), 8);
                Log.d(TAG, "final URL: " + url);

            }
        }
```
