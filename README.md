## About The Project

This is the SDK of the Flythings Connector Project.

## Index

## Build

```shell
mvn clean install
```

## Content

- Auth: This module includes all the authentication logic
- Connector: This module includes all the clients and services that interface with Flythings
  Connector
- Util: This module contains miscellaneous files used on the whole project like exceptions

## Usage

Include the dependency

```xml

<dependency>
    <groupId>es.itg.flythings.dataspace</groupId>
    <artifactId>connector</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Example of downloading file from an agreement id

Build SdkConfig with credentials

```java

var config = SdkConfig.builder()
    .apiUrl("sdk.api.url")
    .authApiUrl("sdk.auth.url")
    .credentials(
        "sdk.auth.username",
        "sdk.auth.password"
    )
    .build();

```

or with token (be aware that tokens may expire while credentials are used to auto renew the token)

```java
var config = SdkConfig.builder()
    .apiUrl("sdk.api.url")
    .authApiUrl("sdk.auth.url")
    .token("sdk.auth.token")
    .build();
```

Then use the download service

```java

var downloadService = new DownloadService(config);

var result = downloadService.download(new DownloadRequest.Builder(agreementId)
    .build());

```

## Contact

TODO