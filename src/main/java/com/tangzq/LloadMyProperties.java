package com.tangzq;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class LloadMyProperties {
    private static Properties properties;
    public static Properties getProperties() throws IOException, URISyntaxException {
        Properties properties =new Properties();
        String path = new File(".").getCanonicalPath();
        String path2 =  System.getProperty("user.dir");
        String propertiesPath=System.getProperty("/classes/application.properties");
        String path3 = new File(TestMain.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
        URL resUri= new TestMain().getClass().getResource(path3+"/application.properties");
        FileInputStream inputStream= new FileInputStream(path3+"/classes/application.properties");
        //  properties.load( new TestMain().getClass().getResourceAsStream(path3+"/application.properties"));
        // properties.load(resUri.openStream());
        properties.load(inputStream);
        return properties;
    }
    public static void getAttributes( ){
        String pp1= properties.getProperty("spring.mvc.view.prefix");
    }
}
