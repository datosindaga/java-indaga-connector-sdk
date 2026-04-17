package es.itg.flythings.dataspace.sdk.services.downloads;

/**
 * The Download result. Retuns the file downloaded and the transfer id
 */
public record DownloadResult(byte[] fileContent, String id) {

}
