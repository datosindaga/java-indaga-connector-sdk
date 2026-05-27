package es.itg.flythings.dataspace.sdk.services.edrs;

import java.util.List;

/**
 * Parameters for the {@link EdrService#getEdrs(EdrRequest)} operation.
 *
 * <pre>{@code
 * EdrRequest request = new EdrRequest.Builder("my-agreement-id").build();
 *
 * // With overrides
 * EdrRequest request = new EdrRequest.Builder("my-agreement-id")
 *         .context(List.of("https://w3id.org/edc/connector/management/v0.0.1"))
 *         .build();
 * }*</pre>
 */
public final class EdrRequest {

    private static final List<String> DEFAULT_CONTEXT = List.of(
        "https://w3id.org/edc/connector/management/v0.0.1"
    );

    /**
     * The Agreement id. (Required)
     */
    final String agreementId;
    /**
     * The Context. (Optional)
     */
    final List<String> context;

    private EdrRequest(Builder builder) {
        this.agreementId = builder.agreementId;
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
        private final String agreementId;

        // Optional
        private List<String> context = DEFAULT_CONTEXT;

        /**
         * Instantiates a new Builder.
         *
         * @param agreementId the ID of a previously negotiated contract agreement (required)
         */
        public Builder(String agreementId) {
            if (agreementId == null || agreementId.isBlank()) {
                throw new IllegalArgumentException("agreementId is required");
            }
            this.agreementId = agreementId;
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
         * Build download request.
         *
         * @return the download request
         */
        public EdrRequest build() {
            return new EdrRequest(this);
        }
    }
}
