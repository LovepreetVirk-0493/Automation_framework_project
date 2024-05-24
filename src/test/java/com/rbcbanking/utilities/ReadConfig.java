package com.rbcbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("./configuration/config.properties");

        try {
            FileInputStream FIS = new FileInputStream(src);
            pro = new Properties();
            pro.load(FIS);
        } catch (IOException e) {
            System.out.println("Error is " + e);
        }
    }

    public String getwebURL() {
        return pro.getProperty("baseURL");
    }

    public String getUserName() {
        return pro.getProperty("Username");
    }

    public String getPassword() {
        return pro.getProperty("Password");
    }
}
