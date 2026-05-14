package es.itg.flythings.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Test config.
 */
public final class TestConfig {

    private static final Properties PROPS = load();

    private TestConfig() {
    }

    private static Properties load() {
        try (InputStream is = TestConfig.class
            .getClassLoader()
            .getResourceAsStream("test.properties")) {
            if (is == null) {
                throw new IllegalStateException("test.properties not found");
            }
            Properties p = new Properties();
            p.load(is);
            return p;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load test.properties", e);
        }
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    public static String get(String key) {
        String value = PROPS.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Missing property: " + key);
        }
        return value;
    }
}
