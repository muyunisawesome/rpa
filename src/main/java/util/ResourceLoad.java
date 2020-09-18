package util;

import java.net.URL;

public class ResourceLoad {

    private static final boolean BIN = true;

    public static final URL load(String resource) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResource(resource);
    }

}
