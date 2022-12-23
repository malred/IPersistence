![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1661956783477-8222ec7d-2a2d-48b3-9f48-12619b89285d.png#averageHue=%23f0f0f0&clientId=u6f993ed6-2772-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=519&id=u0bbf6a30&margin=%5Bobject%20Object%5D&name=image.png&originHeight=649&originWidth=832&originalType=binary&ratio=1&rotation=0&showTitle=false&size=317797&status=done&style=none&taskId=u4f626f69-a66c-498c-b4df-693ea6f3cd0&title=&width=665.6)
# 创建项目,并尝试读取配置文件
![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1661956943283-b6e5992d-cffa-4e38-b7e5-665379d673bf.png#averageHue=%232e2b2f&clientId=u6f993ed6-2772-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=325&id=ue2a41f9f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=406&originWidth=650&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17450&status=done&style=none&taskId=uabbb1e5e-77a9-4c6d-bc6e-3c5b7079043&title=&width=520)![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1661958093316-2ba3a1e7-d0fe-47df-97ca-7663952851e2.png#averageHue=%23272831&clientId=ub5303579-82c4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=198&id=uc50badcc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=248&originWidth=349&originalType=binary&ratio=1&rotation=0&showTitle=false&size=100503&status=done&style=none&taskId=uad7a1717-c019-4633-a9db-556c0ea1c1a&title=&width=279.2)
```java
public class Resources {
    /**
     * 根据路径,加载文件为字节输入流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        InputStream resourceAsStream=
                Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}

```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.malguy</groupId>
    <artifactId>IPersistence</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
        <java.version>8</java.version>
    </properties>

</project>
```
## IPersistence_test模块 (IPersistence模块先打包(maven生命周期的install),才能被依赖)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.malguy</groupId>
    <artifactId>IPersistence_test</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
        <java.version>8</java.version>
    </properties>
    <!--引入自定义持久层框架的依赖-->
    <dependencies>
        <dependency>
            <groupId>org.malguy</groupId>
            <artifactId>IPersistence</artifactId> 
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
## 点击加号,选择想引入的maven工程的pom文件,就可以在maven项目里引入对应工程
![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1661958638360-a89f1b36-64ee-46a4-83cf-26b8ee44d00d.png#averageHue=%23272730&clientId=ub5303579-82c4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=230&id=u628a3216&margin=%5Bobject%20Object%5D&name=image.png&originHeight=288&originWidth=368&originalType=binary&ratio=1&rotation=0&showTitle=false&size=143299&status=done&style=none&taskId=u3792c56b-f4e5-45fa-ad14-7ca0ea3a049&title=&width=294.4)![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1661958647119-72f15352-4b5b-4edf-8296-fae9373d5a2c.png#averageHue=%23282c36&clientId=ub5303579-82c4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=471&id=ua2a03a40&margin=%5Bobject%20Object%5D&name=image.png&originHeight=589&originWidth=311&originalType=binary&ratio=1&rotation=0&showTitle=false&size=269468&status=done&style=none&taskId=uafb5f5ab-0a1b-4666-8efd-4e65a4cc8f2&title=&width=248.8)
# 创建两个javaBean
![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1662014510497-4f834cee-f271-4021-b93c-543ef0bd30f3.png#averageHue=%23282b35&clientId=u01fc8e8e-cbc4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=402&id=ub074b763&margin=%5Bobject%20Object%5D&name=image.png&originHeight=503&originWidth=320&originalType=binary&ratio=1&rotation=0&showTitle=false&size=224679&status=done&style=none&taskId=ud729c3d1-e425-4185-bd7a-143af0773eb&title=&width=256)
```java
public class MappedStatement {
    //id标识
    private String id;
    //返回值类型
    private String resultType;
    //参数值设置
    private String parameterType;
    //sql语句
    private String sql;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String paramterType) {
        this.parameterType = paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
```
```java
public class Configuration {
    private DataSource dataSource;

    //key: 唯一标识id value: MappedStatement对象
    private Map<String,MappedStatement> mappedStatementMap=new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "dataSource=" + dataSource.toString() +
                ", mappedStatementMap=" + mappedStatementMap.toString() +
                '}';
    }
}
```
# 解析配置文件
## 引入依赖
```xml
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <dependency>
            <groupId>c3p0</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.1.2</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>dom4j</groupId>
            <artifactId>dom4j</artifactId>
            <version>1.6.1</version>
        </dependency>
        <dependency>
            <groupId>jaxen</groupId>
            <artifactId>jaxen</artifactId>
            <version>1.1.6</version>
        </dependency>
    </dependencies>
```
```java
public class XMLConfigBuilder {
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration=new Configuration();
    }

    /**
     * 对配置进行解析(dom4j),封装到Configuration
     * @param in 配置文件输入流
     * @return 返回总配置类
     * @throws Exception
     */
    public Configuration parseConfig(InputStream in) throws Exception{
        Document dom = new SAXReader().read(in);
        //拿到xml的根对象 <configuration>
        Element rootElement = dom.getRootElement();
        //找到所有property
        List<Element> list = rootElement.selectNodes("//property");
        //标签的值存到配置类
        Properties properties = new Properties();
        for (Element element : list) {
            String name=element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }
        //创建数据库连接池配置类
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));
        //存入总配置类
        configuration.setDataSource(comboPooledDataSource);
        //解析mapper.xml ->路径->字节输入流->解析
        List<Element> mappers = rootElement.selectNodes("//mapper");
        for (Element mapper : mappers) {
            String mapperPath = mapper.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return configuration;
    }
}
```
## 解析mapper文件
```java
public class XMLMapperBuilder {
    private Configuration configuration;
    public XMLMapperBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    /**
     * 解析mapper.xml
     * @param inputStream mapper.xml的字节输入流
     */
    public void parse(InputStream inputStream) throws Exception{
        Document dom = new SAXReader().read(inputStream);
        Element root = dom.getRootElement();//mapper标签
        String namespace = root.attributeValue("namespace");
        List<Element> selectNodes = root.selectNodes("//select");
        List<Element> updateNodes = root.selectNodes("//update");
        List<Element> deleteNodes = root.selectNodes("//delete");
        List<Element> insertNodes = root.selectNodes("//insert");
        fill(selectNodes,namespace,true);
        fill(updateNodes,namespace,false);
        fill(deleteNodes,namespace,false);
        fill(insertNodes,namespace,false);
    }
    public void fill(List<Element> nodes,String namespace,boolean haveRes){
        for (Element node : nodes) {
            String id = node.attributeValue("id");
            String resultType = node.attributeValue("resultType");
            String parameterType = node.attributeValue("parameterType");
            String sqlText = node.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            if(haveRes) mappedStatement.setResultType(resultType);
            else mappedStatement.setResultType(null);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sqlText);
            //存入配置类,key应为mapper对应方法的全类名
            String key= namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
//            System.out.println(configuration.toString());//有获得属性
        }
    }
}
```
# SqlSessionFactoryBuilder
```java
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) throws Exception {
        //1,dom4j解析xml,封装到configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);
//        System.out.println(configuration);//有数据
        //2,创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =
                new DefaultSqlSessionFactory(configuration);
        sqlSessionFactory.openSession();
        return sqlSessionFactory;
    }
}

```
# SqlSessionFactory
```java
public interface SqlSessionFactory {
    public SqlSession openSession();
}
```
```java
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
```
# sqlsession
```java
public interface SqlSession {
    /**
     * 查询所有
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <E> 泛型
     * @return 返回查询的对象的集合
     */
    public <E> List<E> selectList(String statementid,Object...params);

    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <T> 泛型
     * @return 返回一个类
     */
    public <T> T selectOne(String statementid,Object...params);

    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int deleteOne(String statementid,Object...params);

    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int updateOne(String statementid,Object...params);
    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int insertOne(String statementid,Object...params);
}
```
```java
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public <E> List<E> selectList(String statementid, Object... params) {
        //对simpleExecutor里的方法的调用
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
//        System.out.println(mappedStatement);//yes
//        System.out.println(statementid);//yes
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementid, Object... params) {
        List<Object> objects = selectList(statementid, params);
        if(objects.size()==1){
            return (T)objects.get(0);
        }else{
            throw new RuntimeException("查询结果为空或返回结果过多");
        }
    }

    @Override
    public int deleteOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement,params);
    }

    @Override
    public int updateOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement,params);
    }

    @Override
    public int insertOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement,params);
    }
}
```
# executor
```java
public interface Executor {
    /**
     * 执行语句
     * @param config 总的配置
     * @param ms 存放sql语句
     * @param params sql语句的参数
     * @param <E> 泛型
     * @return
     */
    public <E> List<E> query(Configuration config, MappedStatement ms,Object...params);

    /**
     * 删除和修改方法
     * @param config
     * @param ms
     * @param params
     * @return
     */
    public int queryOther(Configuration config, MappedStatement ms,Object...params);
}
```
```java
public class simpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration config, MappedStatement ms, Object... params) {
        //1,注册驱动,获取连接
        try {
//            System.out.println(Arrays.toString(params));//yes
            Connection conn = config.getDataSource().getConnection();
            //2,获取sql语句
            String sql = ms.getSql();
//            System.out.println(sql);//yes
            //给sql填充参数
            BoundSql boundSql = getBoundSql(sql);
//            System.out.println(boundSql);
            //3,获取预处理对象
            PreparedStatement preparedStatement = conn.prepareStatement(boundSql.getSqlText());
            //4,设置参数 (根据得到的参数名称来反射获取传过来的类里的属性
            String parameterType = ms.getParameterType();//获取参数全路径
            Class<?> parameterTypeClass = getClassType(parameterType);
            List<ParameterMapping> parameterMappingList =
                    boundSql.getParameterMappingList();
//            System.out.println(boundSql);
            for (int i = 0; i < parameterMappingList.size(); i++) {
                //获取参数名
                ParameterMapping parameterMapping = parameterMappingList.get(i);
                String content = parameterMapping.getContent();//参数名
                //反射
                Field declaredField = parameterTypeClass.getDeclaredField(content);
                declaredField.setAccessible(true);//设置(暴力)可访问
                //得到对应参数的值
                Object o = declaredField.get(params[0]); //params[0] == 传过来的user
                preparedStatement.setObject(i + 1, o);
            }
            //5,执行操作
            ResultSet resultSet = preparedStatement.executeQuery();
            String resultType=ms.getResultType();
            Class<?> resultTypeClass = getClassType(resultType);
            Object instance = null;
            //6,封装返回结果集
            ArrayList<Object> objects = new ArrayList<>();
            while(resultSet.next()){
                //封装的对象
                instance=resultTypeClass.newInstance();
                //元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //获取字段名
                    String columnName = metaData.getColumnName(i);
                    //获取字段值
                    Object value = resultSet.getObject(columnName);
                    //反射,根据数据库表和实体类的映射关系来封装类
                    PropertyDescriptor propertyDescriptor = //会根据参数一的参数名生成getset方法
                            new PropertyDescriptor(columnName,resultTypeClass);
                    Method writeMethod = propertyDescriptor.getWriteMethod();//写方法
                    writeMethod.invoke(instance,value);
                }
                //放入集合
                objects.add(instance);
            }
            return (List<E>)objects;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //删除,修改
    @Override
    public int queryOther(Configuration config, MappedStatement ms, Object... params) {
        //1,注册驱动,获取连接
        try {
//            System.out.println(Arrays.toString(params));//yes
            Connection conn = config.getDataSource().getConnection();
            //2,获取sql语句
            String sql = ms.getSql();
//            System.out.println(sql);//yes
            //给sql填充参数
            BoundSql boundSql = getBoundSql(sql);
//            System.out.println(boundSql);
            //3,获取预处理对象
            PreparedStatement preparedStatement = conn.prepareStatement(boundSql.getSqlText());
            //4,设置参数 (根据得到的参数名称来反射获取传过来的类里的属性
            String parameterType = ms.getParameterType();//获取参数全路径
            Class<?> parameterTypeClass = getClassType(parameterType);
            List<ParameterMapping> parameterMappingList =
                    boundSql.getParameterMappingList();
//            System.out.println(boundSql);
            for (int i = 0; i < parameterMappingList.size(); i++) {
                //获取参数名
                ParameterMapping parameterMapping = parameterMappingList.get(i);
                String content = parameterMapping.getContent();//参数名
                //反射
                Field declaredField = parameterTypeClass.getDeclaredField(content);
                declaredField.setAccessible(true);//设置(暴力)可访问
                //得到对应参数的值
                Object o = declaredField.get(params[0]); //params[0] == 传过来的user
                preparedStatement.setObject(i + 1, o);
            }
            //5,执行操作
            boolean flag = preparedStatement.execute();
            if (flag) return 1; //成功
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private Class<?> getClassType(String parameterType) throws Exception {
        if (parameterType != null) {
            Class<?> aClass = Class.forName(parameterType);
            return aClass;
        }
        return null;
    }

    /**
     * 1,#{}转换为? 2,#{}里的值存储起来
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类: 配合标记解析器完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler =
                new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser =
                new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        System.out.println(parseSql);//?
        //#{}里解析出来的参数名称
        List<ParameterMapping> parameterMappings =
                parameterMappingTokenHandler.getParameterMappings();
        System.out.println(parameterMappings);//?
        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
```
# Boundsql
```java
public class BoundSql {
    private String sqlText;//解析后的sql

    public String getSqlText() {
        return sqlText;
    }

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }

    private List<ParameterMapping> parameterMappingList=
            new ArrayList<ParameterMapping>();
}
```
# utils
```java
public class GenericTokenParser {
    private final String openToken;//开始标记
    private final String closeToken;//结束标记
    private final TokenHandler handler;//标记处理器
    public GenericTokenParser(String openToken, String closeToken, TokenHandler handler) {
        this.openToken = openToken;
        this.closeToken = closeToken;
        this.handler = handler;
    }

    /**
     * 解析${}和#{}
     * @param text 传入的文本,包含${}或#{}
     * @return
     */
    public String parse(String text) {
        //验证参数问题,如果为null,就返回空串
        if(text==null||text.isEmpty()){
            return "";
        }
        //验证是否包含开始标签,不包含默认不是占位符,原样返回
        int start=text.indexOf(openToken,0);
        if(start==-1){
            return text;
        }
        //text转成字符数组src,定义默认偏移量offset=0,存储最终需要返回的字符串变量builder
        //text变量中占位符对应变量名expression,判断start是否>-1(text中是否包含openToken),存在就执行下面代码
        char[] src=text.toCharArray();
        int offset = 0;
        final StringBuilder builder = new StringBuilder();
        StringBuilder expression = null;
        while(start>-1){
            //判断如果开始标记前有转义字符,就不作为openToken进行处理,否则继续
            if(start>0&&src[start-1]=='\\'){
                builder.append(src,offset,start-offset-1).append(openToken);
                offset=start+openToken.length();
            }else{
                //重置expression变量,避免空指针或老数据干扰
                if(expression==null){
                    expression=new StringBuilder();
                }else{
                    expression.setLength(0);
                }
                builder.append(src,offset,start-offset);
//                System.out.println(builder.toString());//yes
                offset=start+openToken.length();
                int end = text.indexOf(closeToken,offset);
                while(end>-1) {//存在结束标记时
                    if(end>offset&&src[end-1]=='\\'){//如果结束标记前有转义字符
                        expression.append(src,offset,end-offset);
                        offset=end+closeToken.length();
                        break;
                    }else{
                        //不存在转义字符,需要作为参数处理
                        expression.append(src,offset,end-offset);
                        offset=end+closeToken.length();
                        break;
                    }
                }
                if(end==-1){
                    builder.append(src,start,src.length-start);
                    offset=src.length;
                }else{
                    //首先根据参数的key(即expression)进行参数处理,返回?作为占位符
                    builder.append(handler.handlerToken(expression.toString()));
                    offset=end+closeToken.length();
                }
            }
            start=text.indexOf(openToken,offset);
        }
        if(offset<src.length){
            builder.append(src,offset,src.length-offset);
        }
        return builder.toString();
    }
}
```
```java
public class ParameterMapping {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ParameterMapping(String content) {
        this.content = content;
    }
}
```
```java
public class ParameterMappingTokenHandler implements TokenHandler{
    private List<ParameterMapping> parameterMappings=new ArrayList();
    //context就是参数名称 #{id} -> id
    @Override
    public String handlerToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }
    private ParameterMapping buildParameterMapping(String content){
        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }
    public List<ParameterMapping> getParameterMappings(){
        return parameterMappings;
    }
    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}
```
```java
public interface TokenHandler {
    String handlerToken(String content);
}
```
# 优化为动态代理获取statementId
![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1671611842808-63b9533a-ccb7-4b19-915d-c9924a3e223e.png#averageHue=%23faf9f8&clientId=ub0afe923-d1a1-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=656&id=ua8265d1e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=820&originWidth=1355&originalType=binary&ratio=1&rotation=0&showTitle=false&size=321811&status=done&style=none&taskId=u07617ac7-8c78-4810-9b4e-7269b35fd36&title=&width=1084)
## 修改defaultSqlSession和其继承的接口
```java
package com.malguy.sqlSession; 
public interface SqlSession {
    /**
     * 查询所有
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <E> 泛型
     * @return 返回查询的对象的集合
     */
    public <E> List<E> selectList(String statementid,Object...params);

    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <T> 泛型
     * @return 返回一个类
     */
    public <T> T selectOne(String statementid,Object...params);

    /**
     * 根据条件删除单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int deleteOne(String statementid,Object...params);

    /**
     * 根据条件更新单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int updateOne(String statementid,Object...params);
    /**
     * 根据条件插入单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int insertOne(String statementid,Object...params);

    /**
     * 为dao接口生成代理实现类
     * @param mapperClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> mapperClass);
}
```
```java
package com.malguy.sqlSession; 
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... params) {
        //对simpleExecutor里的方法的调用
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
//        System.out.println(mappedStatement);//yes
//        System.out.println(statementid);//yes
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementid, Object... params) {
        List<Object> objects = selectList(statementid, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或返回结果过多");
        }
    }

    @Override
    public int deleteOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public int updateOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public int insertOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理为DAO接口生成代理对象,并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),
                new Class[]{mapperClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //底层都是调jdbc,根据不同情况,调用不同方法
                        //准备参数,statementid(sql语句唯一标识) = namespace.id=dao接口全类名.方法名
                        //方法名获取 findAll
                        String methodName = method.getName();
                        //获取该方法所在的字节码对象,然后获取全类名
                        String className = method.getDeclaringClass().getName();
                        //拼接
                        String statementId = className +"."+ methodName;
                        //准备参数,params
                        //获取被调用方法的返回值类型(如List<xxx>,和User类)
                        Type genericReturnType = method.getGenericReturnType();
                        //判断是否进行了 泛型类型参数化(即是否使用泛型(比如List))
                        if (genericReturnType instanceof ParameterizedType) {
                            List<Object> objects = selectList(statementId, args);
                            return objects;
                        }
                        return selectOne(statementId, args);
                    }
                });
        return (T) proxyInstance;
    }
}
```
# IPersistence_test工程
![image.png](https://cdn.nlark.com/yuque/0/2022/png/26091703/1671615884271-1adac266-8ec4-497d-9a96-678307d33c84.png#averageHue=%232a3139&clientId=ub0afe923-d1a1-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=570&id=u76a9c416&margin=%5Bobject%20Object%5D&name=image.png&originHeight=713&originWidth=338&originalType=binary&ratio=1&rotation=0&showTitle=false&size=351607&status=done&style=none&taskId=u8870f5c1-b0e6-43dd-8480-53560c1b62a&title=&width=270.4)
## IUserDao
```java
public interface IUserDao {
    //查询所有用户
    public List<User> findAll();
    //根据条件进行用户查询
    public User findByCondition(User user);
}
```
## IUserDaoImpl
```java
/**
 * 示例: 原来的方式会产生代码冗余(多次加载配置,new sqlsession)
 */
public class IUserDaoImpl implements IUserDao {
    @Override
    public List<User> findAll() {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }
        return users;
    }

    @Override
    public User findByCondition(User user) {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User u = sqlSession.selectOne("user.selectOne", user);
        return u;
    }

    @Override
    public int updateOne(User user) {
        return 0;
    }

    @Override
    public int delOne(User user) {
        return 0;
    }

    @Override
    public int insertOne(User user) {
        return 0;
    }
}
```
## User
```java
public class User {

  private int id;
  private String name;
  private String password;
  private String address;
  private String phone;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
```
## sqlMapConfig
```xml
<configuration>
    <!--数据库配置信息-->
    <dataSource>
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3307/test"></property>
        <property name="username" value="root"></property>
        <property name="password" value="123456"></property>
    </dataSource>
    <!-- 存放mapper.xml的全路径 -->
    <!--一个测试传统方法,一个测试代理对象方法-->
    <mapper resource="IUserMapper.xml"></mapper>
    <mapper resource="UserMapper.xml"></mapper>
</configuration>
```
## UserMapper
```xml
<!-- namespace+id ==> 唯一表示statementId -->
<!-- 问题2,如果别的mapper也是一模一样的,怎么区分? ->> mapper的namespace属性 -->
<mapper namespace="user">
    <!--使用动态代理,这里需要换成接口的全类名,否则按原来的会报错(mapperstatement空指针
            ,无法获取对应方法(key)和sql语句(value))-->
    <!--<mapper namespace="com.malguy.dao.IUserDao">-->
    <!-- 问题1,如果多个select标签,如何区分? ->> 使用id属性 -->
    <!-- 为了解决jdbc自己封装返回的数据的问题,
         我们借助反射来封装,但反射需要全类名,由resultType指定 -->
    <select id="selectList" resultType="com.malguy.pojo.User">
        select * from user
    </select>
    <!--
       语句需要参数,当有多个参数,我们选择封装为类来传递,
       User user=new User();
       user.setId=?
       user.setName=?
       传递类,并反射获取参数
       #{}可以指定要获取的属性的名字
    -->
    <select id="selectOne" resultType="com.malguy.pojo.User"
            parameterType="com.malguy.pojo.User">
        select * from user where id=#{id} and name=#{name}
    </select>
    <update id="updateOne" parameterType="com.malguy.pojo.User">
        UPDATE user
        SET name=#{name},password=#{password},address=#{address},phone=#{phone}
        WHERE id=#{id};
    </update>
    <delete id="delOne" parameterType="com.malguy.pojo.User">
        delete from user where id=#{id}
    </delete>
    <insert id="insertOne" parameterType="com.malguy.pojo.User">
        insert into user(name,password) values(#{name},#{password});
    </insert>
</mapper>
```
## IUserMapper
```xml
<!-- namespace+id ==> 唯一表示statementId -->
<!-- 问题2,如果别的mapper也是一模一样的,怎么区分? ->> mapper的namespace属性 -->
<!--<mapper namespace="user">-->
<!--使用动态代理,这里需要换成接口的全类名,否则按原来的会报错(mapperstatement空指针
        ,无法获取对应方法(key)和sql语句(value))-->
<mapper namespace="com.malguy.dao.IUserDao">
    <!-- 问题1,如果多个select标签,如何区分? ->> 使用id属性 -->
    <!-- 为了解决jdbc自己封装返回的数据的问题,
         我们借助反射来封装,但反射需要全类名,由resultType指定 -->
    <!--    <select id="selectList" resultType="com.malguy.pojo.User">-->
    <!--使用动态代理,无法获取mapper文件的值,但是可以通过method对象获取方法名,索引id改为方法名-->
    <select id="findAll" resultType="com.malguy.pojo.User">
        select * from user
    </select>
    <!--
       语句需要参数,当有多个参数,我们选择封装为类来传递,
       User user=new User();
       user.setId=?
       user.setName=?
       传递类,并反射获取参数
       #{}可以指定要获取的属性的名字
    -->
    <select id="findByCondition" resultType="com.malguy.pojo.User"
            parameterType="com.malguy.pojo.User">
        select * from user where id=#{id} and name=#{name}
    </select>
    <update id="updateOne" parameterType="com.malguy.pojo.User">
        UPDATE user
        SET name=#{name},password=#{password},address=#{address},phone=#{phone}
        WHERE id=#{id};
    </update>
    <delete id="delOne" parameterType="com.malguy.pojo.User">
        delete from user where id=#{id}
    </delete>
    <insert id="insertOne" parameterType="com.malguy.pojo.User">
        insert into user(name,password) values(#{name},#{password});
    </insert>
</mapper>
```
## Test
```java
package com.malguy.test; 
/**
 * 传统方法测试
 */
public class IPersistenceTest {
    public SqlSession sqlSession = null;

    @Before
    public void bef() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void sel() throws Exception {
//        System.out.println(sqlSession.toString());//yes
        User user = new User();
        user.setId(1);
        user.setName("章子怡");
//        查询单个
        User u = sqlSession.selectOne("user.selectOne", user);
        System.out.println(u);
        // 查询多个
        List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void upd() {
        // 更新
        User user = new User();
        user.setId(18);
        user.setPassword("10086");
        user.setName("米酒1973");  // user.updateOne,就是mapper文件里的namespace+id == statementid
        sqlSession.updateOne("user.updateOne", user);
    }

    @Test
    public void del() {
        // 删除
        User user = new User();
        user.setId(21);
        sqlSession.deleteOne("user.delOne", user);
    }

    @Test
    public void insert() {
        // 插入
        User sp = new User(); 
        sp.setName("湿婆");
        sp.setPassword("tdw");
        sqlSession.insertOne("user.insertOne", sp);
    }
}
```
```java
package com.malguy.test; 
/**
 * 代理方法测试
 */
public class proxyTest {
    public SqlSession sqlSession = null;

    // getmapper代理生成对象,代理对象每次执行方法都会调用invoke,
    // 在invoke里获取全类名,减少new sqlsession的次数,减少重复代码
    IUserDao userDao = null;

    @Before
    public void bef() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @Test
    public void sel() {
        User user = new User();
        user.setId(1);
        user.setName("章子怡");
        // 查询单个
        User u2 = userDao.findByCondition(user);
        System.out.println(u2);
        // 查询多个
        List<User> all = userDao.findAll();
        for (User u : all) {
            System.out.println(u);
        }
    }
    /* todo 可以在configuration类里加一个map,key是标签类型(如update),value是方法的statementid,在代理invoke方法进行判断是什么类型的操作,然后执行相应方法
            并且把deleteOne/updateOne这些代码(有相同逻辑,都是queryother)->抽象成一个方法来操作*/
    /*
    @Test
    public void upd() {
        // 更新
        User user = new User();
        user.setId(18);
        user.setPassword("10086");
        user.setName("米酒1973");  // user.updateOne,就是mapper文件里的namespace+id == statementid
        userDao.updateOne(user);
    }

    @Test
    public void del() {
        // 删除
        User user = new User();
        user.setId(21);
        userDao.delOne(user);
    }

    @Test
    public void insert() {
        // 插入
        User sp = new User();
        sp.setName("湿婆");
        sp.setPassword("tdw");
        userDao.insertOne(sp);
    }
    */
}
```
