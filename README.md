Chamberlain MyQ SDK
======================

This is a simple Java wrapper around all the api calls used to login, and retreive and set device attributes.

Building and Including
-----
This library and the included example are built using Gradle.

This library is available on Maven. To include it in your project, add the following to your root build.gradle

    repositories {
        mavenCentral()
        maven {
            url "https://oss.sonatype.org/content/repositories/snapshots"
        }
    }
    
And add the following to your app build.gradle

```compile 'com.t3hh4xx0r:chamberlain-myq-sdk:0.0.1-SNAPSHOT@aar'```

