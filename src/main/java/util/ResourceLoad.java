package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class ResourceLoad {


    private static Properties properties;

    public static final URL load(String resource) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResource(resource);
    }

    public static Properties properties(String property) throws URISyntaxException, IOException {
        if (null != properties) {
            return properties;
        }
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = new FileInputStream(new File(loader.getResource(property).toURI()));
        properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
