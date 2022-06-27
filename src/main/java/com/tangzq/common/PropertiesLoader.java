package com.tangzq.common;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Properties文件載入工具類. 可載入多個properties檔, 相同的屬性在最後載入的檔中的值將會覆蓋之前的值，但以System的Property優先.
 * @author tangzhiqiang
 */
public class PropertiesLoader {

    private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private final Properties properties;

    public PropertiesLoader(String... resourcesPaths) {
        properties = loadProperties(resourcesPaths);
    }

    public Properties getProperties() {
        return properties;
    }

    /**
     * 取出Property，但以System的Property優先,取不到返回空字串.
     *
     * @param key
     * @return
     */
    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return "";
    }

    /**
     * 取出String類型的Property，但以System的Property優先,如果都為Null則拋出異常.
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * 取出String類型的Property，但以System的Property優先.如果都為Null則返回Default值.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getProperty(String key, String defaultValue) {
        String value = getValue(key);
        return value != null ? value : defaultValue;
    }

    /**
     * 取出Integer類型的Property，但以System的Property優先.如果都為Null或內容錯誤則拋出異常.
     *
     * @param key
     * @return
     */
    public Integer getInteger(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Integer.valueOf(value);
    }

    /**
     * 取出Integer類型的Property，但以System的Property優先.如果都為Null則返回Default值，如果內容錯誤則拋出異常
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public Integer getInteger(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Integer.valueOf(value) : defaultValue;
    }

    /**
     * 取出Double類型的Property，但以System的Property優先.如果都為Null或內容錯誤則拋出異常.
     *
     * @param key
     * @return
     */
    public Double getDouble(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Double.valueOf(value);
    }

    /**
     * 取出Double類型的Property，但以System的Property優先.如果都為Null則返回Default值，如果內容錯誤則拋出異常
     */
    public Double getDouble(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Double.valueOf(value) : defaultValue;
    }

    /**
     * 取出Boolean類型的Property，但以System的Property優先.如果都為Null拋出異常,如果內容不是true/false則返回false.
     *
     * @param key
     * @return
     */
    public Boolean getBoolean(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Boolean.valueOf(value);
    }

    /**
     * 取出Boolean類型的Property，但以System的Property優先.如果都為Null則返回Default值,如果內容不為true/false則返回false.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public Boolean getBoolean(String key, boolean defaultValue) {
        String value = getValue(key);
        return value != null ? Boolean.valueOf(value) : defaultValue;
    }

    /**
     * 載入多個檔, 檔路徑使用Spring Resource格式.
     *
     * @param resourcesPaths
     * @return
     */
    private Properties loadProperties(String... resourcesPaths) {
        Properties props = new Properties();

        for (String location : resourcesPaths) {
            logger.debug("Loading properties file from:" + location);
            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                props.load(is);
            } catch (IOException ex) {
                logger.info("Could not load properties from path:" + location + ", " + ex.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return props;
    }
}


