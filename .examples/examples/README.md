# Flythings Dataspace SDK — Java Examples

Standalone Maven project demonstrating all SDK operations.

## Setup

Edit credentials in each example file (search `changeme`):

```java
DataspaceClient.builder()
    .apiUrl("https://devdsconnector.flythings.io/connector/api")
    .authApiUrl("https://devdsconnector.flythings.io/auth/api")
    .credentials("your-username", "your-password")
    .build();
```

Or use a static token:

```java
DataspaceClient.builder()
    .apiUrl("https://devdsconnector.flythings.io/connector/api")
    .token("eyJhbGci...")
    .build();
```

## Build

```bash
# Install SDK to local Maven repo first (from repo root)
mvn install

# Then compile examples
cd .examples/examples
mvn compile
```

## Run

```bash
mvn exec:java -Dexec.mainClass="es.itg.flythings.dataspace.sdk.examples.resources.assets.CreateAsset"
```

## Structure

```
resources/        Low-level: one HTTP call per file
  assets/         Asset CRUD
  catalog/        Catalog queries
  contracts/      Contract definition CRUD
  negotiations/   Contract negotiation lifecycle
  policies/       Policy definition CRUD + eval/validate
  edrs/           EDR cache operations
  transfers/      Transfer process lifecycle
  agreements/     Contract agreement queries

services/         High-level: orchestrated multi-step flows
  agreement/      Get agreements by asset
  download/       Full download flow (negotiate → transfer → download)
  edrs/           Get EDRs by agreement
  transfer/       Start a transfer by agreement
```
