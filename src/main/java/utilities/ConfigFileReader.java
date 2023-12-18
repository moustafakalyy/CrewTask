package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream("configs/Configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new Exception("Property file is missing", e);
        }
    }

    public String getUrl() {
        return properties.getProperty("Url");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public Long getImplicitTimeOut() {
        String timeOut = properties.getProperty("ImplicitTimeOut");
        return Long.parseLong(timeOut);
    }

}
