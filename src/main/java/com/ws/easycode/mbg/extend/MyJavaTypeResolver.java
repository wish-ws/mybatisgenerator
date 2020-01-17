package com.ws.easycode.mbg.extend;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * @description: db字段类型转换java数据类型
 * @author: 竹马(王松)
 * @date: 2020-01-15 20:06
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public MyJavaTypeResolver() {
        super();
        this.typeMap.put(5, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
