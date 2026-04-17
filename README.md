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

## Installation

Include the dependency

```xml

<dependency>
    <groupId>es.itg.flythings.dataspace</groupId>
    <artifactId>connector</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Requirements

| Tool | Version |
|------|---------|
| Java | 21+     |

## Dependencies

The SDK has a single required external dependency. Testing utilities are only needed if you are
running the test suite.

### Runtime

| Artifact                                                                                | Version  | Description                        |
|-----------------------------------------------------------------------------------------|----------|------------------------------------|
| [`feign-jackson`](https://mvnrepository.com/artifact/io.github.openfeign/feign-jackson) | `13.9.2` | JSON serialization for HTTP client |

### Test

| Artifact                                                                              | Version  | Description            |
|---------------------------------------------------------------------------------------|----------|------------------------|
| [`junit-jupiter`](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter) | `5.14.3` | JUnit 5 test framework |

## Authentication

Authentication is configured via the `DataspaceClient` class, which serves as the central entry
point for
the SDK. It supports two authentication strategies: **static token** and **credentials-based**.

> **Note:** Static tokens may expire during long-running operations. If your use case requires
> uninterrupted access, prefer credentials-based authentication, which handles token renewal
> automatically.

### Static Token

java

```java
DataspaceClient config = DataspaceClient.builder()
    .apiUrl("sdk.api.url")
    .authApiUrl("sdk.auth.url")
    .token("sdk.auth.token")
    .build();
```

### Credentials (Recommended)

java

```java
DataspaceClient config = DataspaceClient.builder()
    .apiUrl("sdk.api.url")
    .authApiUrl("sdk.auth.url")
    .credentials(
        "sdk.auth.username",
        "sdk.auth.password"
    )
    .build();
```

When built with credentials, `DataspaceClient` automatically acquires and refreshes tokens as
needed,
ensuring requests remain authenticated without manual intervention.

---

## Clients and Services

`DataspaceClient` acts as a factory for both **clients** and **services**, the two main building
blocks
for interacting with the Flythings Connector.

### Clients

Clients map closely to individual API resources. Each client exposes typed methods for a specific
domain (e.g., transfers, policies, contract negotiations).

java

```java
TransferClient client = config.buildClient(TransferClient.class);
```

Once instantiated, the client can be used to issue requests:

java

```java
TransferProcessDTO transfer = client.getById("my-transfer-id");
```

### Services

Services are higher-level abstractions that either orchestrate multiple clients or encapsulate more
complex workflows. They can be instantiated in two equivalent ways:

java

```java
// Via factory method
DownloadService service = config.buildService(DownloadService.class);

// Via constructor
DownloadService service = new DownloadService(config);
```

Both produce an identical instance.

---

## Usage

### DownloadService

`DownloadService` downloads the contents of an asset identified by a contract agreement. The
response is returned as a `byte[]`.

**Minimal usage** — only the `agreementId` is required:

java

```java
DownloadService downloadService = new DownloadService(config);

byte[] content = downloadService.download(
    new DownloadRequest.Builder("my-agreement-id")
        .build()
);
```

> **Note:**  You can retrieve the `agreementId` from the web interface. Navigate to **Contracts**,
> select a contract for your desired asset, click **View Details**, and locate the **Agreement ID**
> in
> the Agreement section. ![agreement](.docs/agreement.png)

**Full configuration** — the following shows all available parameters with their defaults:

java

```java
DownloadRequest request = new DownloadRequest.Builder("my-agreement-id")
    .transferType("HttpData-PUSH")      // Transfer mechanism
    .dataAddressType("HttpProxy")       // Target address type
    .protocol("dataspace-protocol-http") // Dataspace protocol
    .context(List.of("https://w3id.org/edc/connector/management/v0.0.1")) // JSON-LD context
    .build();
```

| Parameter         | Default                   | Description                                                                   |
|-------------------|---------------------------|-------------------------------------------------------------------------------|
| `transferType`    | `HttpData-PUSH`           | The transfer mechanism used to move the data                                  |
| `dataAddressType` | `HttpProxy`               | Specifies how the asset's data address is resolved                            |
| `protocol`        | `dataspace-protocol-http` | The dataspace protocol used for the transfer negotiation                      |
| `context`         | EDC management v0.0.1     | JSON-LD `@context` — override when using a custom or domain-specific ontology |

The default configuration assumes an HTTP-based transfer. For non-HTTP assets (e.g., S3, Azure
Blob), adjust `transferType`, `dataAddressType`, and `protocol` accordingly.




