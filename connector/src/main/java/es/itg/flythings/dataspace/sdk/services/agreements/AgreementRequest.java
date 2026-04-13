package es.itg.flythings.dataspace.sdk.services.agreements;

import java.util.List;

/**
 * Parameters for the {@link AgreementService#getAgreements(AgreementRequest)} operation.
 *
 * <pre>{@code
 * AgreementRequest request = new AgreementRequest.Builder("my-asset-id").build();
 *
 * // With overrides
 * AgreementRequest request = new AgreementRequest.Builder("my-asset-id")
 *         .context(List.of("https://w3id.org/edc/connector/management/v0.0.1"))
 *         .build();
 * }*</pre>
 */
public final class AgreementRequest {

    private static final List<String> DEFAULT_CONTEXT = List.of(
        "https://w3id.org/edc/connector/management/v0.0.1"
    );

    /**
     * The Agreement id. (Required)
     */
    final String assetId;
    /**
     * The Context. (Optional)
     */
    final List<String> context;

    private AgreementRequest(Builder builder) {
        this.assetId = builder.assetId;
        this.context = builder.context;
    }

    // ------------------------------------------------------------------ //
    //  Builder
    // ------------------------------------------------------------------ //

    /**
     * The type Builder.
     */
    public static final class Builder {

        // Required
        private final String assetId;

        // Optional
        private List<String> context = DEFAULT_CONTEXT;

        /**
         * Instantiates a new Builder.
         *
         * @param assetId the ID of an asset (required)
         */
        public Builder(String assetId) {
            if (assetId == null || assetId.isBlank()) {
                throw new IllegalArgumentException("assetId is required");
            }
            this.assetId = assetId;
        }

        /**
         * Overrides the JSON-LD context. Defaults to the EDC management API v0.0.1 context.
         *
         * @param context the context
         * @return the builder
         */
        public Builder context(List<String> context) {
            this.context = context;
            return this;
        }

        /**
         * Build agreement request.
         *
         * @return the agreement request
         */
        public AgreementRequest build() {
            return new AgreementRequest(this);
        }
    }
}