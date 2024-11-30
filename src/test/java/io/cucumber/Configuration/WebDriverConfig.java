package io.cucumber.Configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

public class WebDriverConfig {
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        return options;
    }

    public String getProperties(String keyword) {
        Configurations configs = new Configurations();
        Configuration config;

        try {
            config = configs.properties(new File("webconfig.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        return config.getString(keyword);
    }

    public String getDriverUrl() {
//        return LocalDate.now().getDayOfWeek().getValue() == 3 ? getProperties("stg_product.url") : getProperties("product.url");
//        return "https://display.cjonstyle.com";
            return getProperties("product.url");
    }
}
