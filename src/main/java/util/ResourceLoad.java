package util;

import java.net.URL;

public class ResourceLoad {

    private static final boolean BIN = true;

    public static final String load(String resource) {
        if (!BIN) {
            return resource;
        }
        URL url = ResourceLoad.class.getResource("/");
        String uri = url.getPath().substring(0, url.getPath().lastIndexOf("/bin"));
        if (resource.startsWith("/")) {
            return uri.concat(resource);
        }
        return uri.concat("/").concat(resource);
    }

}
