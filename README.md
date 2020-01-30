<h1 align="center">News-API-Android</h1>
<p align="center">
  <a class="badge-align" href="https://www.codacy.com/app/mukeshsolanki/News-API-Android?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/News-API-Android&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/3dc5d577c3a14413b871ee8bb53c6e80"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/News-API-Android"> <img src="https://jitpack.io/v/mukeshsolanki/News-API-Android/month.svg" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/News-API-Android"> <img src="https://jitpack.io/v/mukeshsolanki/News-API-Android.svg" /></a>
  <a href="https://circleci.com/gh/mukeshsolanki/News-API-Android/tree/master"> <img src="https://circleci.com/gh/mukeshsolanki/News-API-Android/tree/master.svg?style=shield" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>
  <br /><br />
News-API-Android is an android/java/kotlin library for accessing News API. https://newsapi.org/
</p>
 <br /><br />

# Support News-API-Android

News-API-Android is an independent project with ongoing development and support made possible thanks to donations made by [these awesome backers](BACKERS.md#sponsors). If you'd like to join them, please consider:

- [Become a backer or sponsor on Patreon](https://www.patreon.com/mukeshsolanki).
- [One-time donation via PayPal](https://www.paypal.me/mukeshsolanki)

<a href="https://www.patreon.com/bePatron?c=935498" alt="Become a Patron"><img src="https://c5.patreon.com/external/logo/become_a_patron_button.png" /></a>

## How to integrate into your app?
Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to use the library. Make the following changes.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```
Step 2. Add the dependency
```java
dependencies {
        implementation 'com.github.mukeshsolanki:News-API-Android:<latest-version>'
}
```

## How to use the library?
Okay seems like you integrated the library in your project but **how do you use it**? Well its really easy just follow the steps below.

```
...
NewsApi.initialize("YOUR_API_KEY")
...

NewsApi.getSources(onSourcesListener = object :
            OnSourcesListener {
            override fun onSourcesResponse(sourcesResponse: SourcesResponse) {
                Log.d("Response=>", sourcesResponse.toString())
            }

            override fun onError(apiError: ApiError?) {
                Log.e("Response=>", apiError.toString())
            }
        })
```

## Method and Parameters
| Method| Use |
| ----------| --- |
| getSources| This endpoint returns the subset of news publishers that top headlines (/v2/top-headlines) are available from. It's mainly a convenience endpoint that you can use to keep track of the publishers available on the API, and you can pipe it straight through to your users. |
| getTopHeadlines | This endpoint provides live top and breaking headlines for a country, specific category in a country, single source, or multiple sources. You can also search with keywords. Articles are sorted by the earliest date published first. This endpoint is great for retrieving headlines for display on news tickers or similar. |
| getEverything | Search through millions of articles from over 30,000 large and small news sources and blogs. This includes breaking news as well as lesser articles. This endpoint suits article discovery and analysis, but can be used to retrieve articles for display, too. |

For more details on these method follow [this](https://newsapi.org/docs/endpoints)
## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/News-API-Android.svg)](https://github.com/mukeshsolanki/News-API-Android/graphs/contributors)

* Bug reports and pull requests are welcome.

## License
```
MIT License

Copyright (c) 2018 Mukesh Solanki

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
