package com.tangzq;

import com.tangzq.LloadMyProperties;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;


public class TestMain {




    public TestMain() throws IOException {
//        {
//            try {
//                properties = getProperties();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }



    public static void main(String[] args) throws IOException, URISyntaxException {
        LloadMyProperties lloadMyProperties= new LloadMyProperties();
        Properties properties;
        properties= lloadMyProperties.getProperties();
        lloadMyProperties.getAttributes();
    }
}
