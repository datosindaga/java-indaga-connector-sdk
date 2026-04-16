package es.itg.flythings.dataspace.sdk.config;

/**
 * Marker interface for all SDK services. Every implementation must expose a public single-argument
 * constructor that accepts a {@link SdkConfig}.
 *
 * <pre>{@code
 * public final class EdrService implements SdkService {
 *     public EdrService(SdkConfig config) { ... }
 * }
 * }</pre>
 */
public interface SdkService {

}
