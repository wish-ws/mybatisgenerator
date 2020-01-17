# 欢迎使用mybatis generator的功能集成demo

<br />

### 在基础功能上，集成了以下特性

- 支持自动生成java类注释，字段注释，方法注释 ，实现序列化接口，生成序列化id  （默认开启)  
- 支持自动生成Lombok注解  （默认关闭）  
- 支持自定义mysql字段类型转换java数据类型，例如：避免tinyint smallint 转成Byte （指定转换为Integer）   （默认开启）  
- 支持扩展生成sql，目前增加queryByObject, queryXxxxBoList, queryXxxxxBoPage 这些sql  （默认关闭)  
  
<br />

### 接入指南：
简单修改下generatorConfig.xml就能使用，需要修改的地方如下:  

```
<commentGenerator type="com.ws.easycode.mbg.MySQLCommentGenerator">
    ……
    <!-- 此处名字可改成自己的 -->
    <property name="author" value="wangsong@yunjiglobal.com"/>
    ……
</commentGenerator>
```


```
<!-- 此处修改db连接属性 -->
<jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://******/******" userId="*****"
                        password="****">

            <!-- 设置 useInformationSchema 属性为 true -->
            <property name="useInformationSchema" value="true" />
        </jdbcConnection>
```


```
<!-- 根据需要添加自己要使用的表 -->
<table tableName="******" domainObjectName="*****"
               enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false" />  
```
  
    
<br /><br />

#### 更多sql扩展需要自行实现：  
com.ws.easycode.mbg.extend.CustomAbstractXmlElementGenerator#addElements方法中，增加新sql的xml拼接实现  
CustomJavaMapperMethodGenerator中增加mapper(dao)方法  

