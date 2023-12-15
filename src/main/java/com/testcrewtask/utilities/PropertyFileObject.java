package com.testcrewtask.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileObject {
    private Properties properties;
    public PropertyFileObject() throws Exception {
        try{
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/TestCrewTask.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
            throw new Exception("Property file is missing",e);
        }
    }

    public Properties getProperties(){
        return properties;
    }
}
