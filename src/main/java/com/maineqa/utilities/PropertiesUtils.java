package com.maineqa.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties configurationProperties() {

        Properties props = new Properties();
        try {

            try(InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties")) {
                props.load(is);
                return props;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
