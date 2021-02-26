package com.xuemiao.mybatis_myself.session;

import com.xuemiao.mybatis_myself.mapping.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * @author xxm
 * @date 2021/2/26 9:26
 */
public class SqlSessionFactory {
    private Configuration configuration = new Configuration();

    public SqlSessionFactory() {
        //加载数据库信息
        loadDbInfo();
        //解析mapper.xml内容，保存到configuration中
        loadMappersInfo();
    }

    /**
     * 实际应该是加载mybatis-config.xml
     * 加载数据库的连接信息，设置到configuration中
     */
    private void loadDbInfo() {
        InputStream dbInfo = SqlSessionFactory.class.getClassLoader()
                .getResourceAsStream(configuration.DB_FILE);
        Properties properties = new Properties();
        try {
            properties.load(dbInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        configuration.setDbDriver(properties.getProperty("jdbc.driver"));
        configuration.setDbUrl(properties.getProperty("jdbc.url"));
        configuration.setDbUserName(properties.getProperty("jdbc.username"));
        configuration.setDbPassWord(properties.getProperty("jdbc.password"));
    }

    private void loadMappersInfo() {
        URL resources = null;
        //获取存放mapper文件的路径
        resources = SqlSessionFactory.class.getClassLoader()
                .getResource(configuration.MAPPER_LOCATION);
        File mappers = new File(resources.getFile());
        if (mappers.isDirectory()) {
            File[] listFiles = mappers.listFiles();
            if (listFiles == null || listFiles.length == 0) return;
            for (File mapper : listFiles) {
                loadMapperInfo(mapper);
            }
        }
    }

    /**
     * 解析mapper SELECT节点
     * @param mapper
     */
    private void loadMapperInfo(File mapper) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(mapper);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Element node = document.getRootElement();
        String namespace = node.attribute("namespace").getData().toString();
        List<Element> selects = node.elements("select");
        if (selects == null || selects.isEmpty()) return;
        for (Element element : selects) {
            MappedStatement mappedStatement = new MappedStatement();
            String id = element.attribute("id").getData().toString();
            String resultType = element.attribute("resultType").getData().toString();
            String sql = element.getData().toString();
            String sourceId = namespace + "." + id;

            mappedStatement.setSourceId(sourceId);
            mappedStatement.setNamespace(namespace);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);
            configuration.getMappedStatements().put(sourceId, mappedStatement);
        }
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
