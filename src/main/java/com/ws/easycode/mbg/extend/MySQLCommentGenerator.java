package com.ws.easycode.mbg.extend;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @description: 实现注释生成
 * @author: 竹马(王松)
 * @date: 2020-01-15 16:17
 */
public class MySQLCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;

    public MySQLCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @Description " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine("/** " + remarks + " */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {}


    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * @description  ");
        method.addJavaDocLine(" * @author " + author + " " + dateFormatter.format(new Date()));
        String params = new String();
        for (Parameter parameter : method.getParameters()) {
            params += parameter.getType().getFullyQualifiedName() + ",";
        }
        if(params.length() > 0){
            params = params.substring(0, params.length() - 1);
        }
        method.addJavaDocLine(" * @param " + params);
        method.addJavaDocLine(" * @return " + (null == method.getReturnType() ? "" : method.getReturnType().getFullyQualifiedName()));
        method.addJavaDocLine(" */");
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {}

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {}

    @Override
    public void addComment(XmlElement xmlElement) {}
}