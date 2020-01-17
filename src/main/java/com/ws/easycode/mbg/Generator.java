package com.ws.easycode.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 竹马(王松)
 * @date: 2020-01-15 16:21
 */
public class Generator {

    public static void main( String[] args ) throws Exception {
        List<String> warnings = new ArrayList<>();
        File f = new File(Generator.class.getResource("/").getPath());
        String systemConfigPath = f.getAbsolutePath().replace("\\", "/");
        File configFile = new File(systemConfigPath + "/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
