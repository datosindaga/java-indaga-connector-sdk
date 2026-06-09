## [1.1.0](https://github.com/datosindaga/java-indaga-connector-sdk/releases/tag/v1.1.0) (09/06/2026)

#### New

- Added `AssetClient` (create, get, update, delete, request)
- Added `CatalogClient` (get catalog, get dataset, get contact catalogs)
- Added `ContractDefinitionClient` (create, get, update, delete, request, change state)
- Added `ContractNegotiationClient` (create, get, get state, get agreement, terminate, hide, delete)
- Added `PolicyClient` (create, get, update, delete, request, evaluate, validate)
- Added full examples module covering all clients and services
- Added paginated result support

#### Fixed

- `changeState` sending quoted string — replaced raw body with `@Body` template to bypass
  `JacksonEncoder`
- `SuspendTransfer` missing `@context` and `@type` fields
- `TerminateTransfer` missing body — created `TerminateTransferDTO`, updated client and example
- `TerminateNegotiation` missing body — wired `TerminationNegotiationDTO` into client and example

## [1.0.0](https://github.com/datosindaga/java-indaga-connector-sdk/releases/tag/v1.0.0) (17/04/2026)

#### New

- Added Authentication
- Added Client for transfers
- Added Client for contract agreements
- Added Client for EDR Caches
- Added Download Service
