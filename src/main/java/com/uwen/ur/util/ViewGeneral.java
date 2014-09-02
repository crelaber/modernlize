package com.uwen.ur.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ViewGeneral {

    public static void main(String[] args) throws Exception {
        // 驱动
        String driver = "oracle.jdbc.driver.OracleDriver";
        // 数据库连接
        String url = "jdbc:oracle:thin:@192.168.141.30:1521:orcl";
        // 用户名
        String user = "twra";
        // 数据库密码
        String password = "twra";
        // 加载驱动
        Class.forName(driver);
        // 获取链接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 创建查询声明
        PreparedStatement preparedStatement = connection.prepareStatement("select * from V_PUB_USER");
        // 获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        // 获取各个列的信息
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 一条数据保存在一个Hashtable 将所有Hashtable存放到list
        List<Hashtable<String, Object>> rows = new ArrayList<Hashtable<String, Object>>();
        while (resultSet.next()) {
            Hashtable<String, Object> row = new Hashtable<String, Object>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                // 打印列名
                System.out.println(metaData.getColumnName(i));
                System.out.println(resultSet.getObject(i));
                row.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            rows.add(row);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
