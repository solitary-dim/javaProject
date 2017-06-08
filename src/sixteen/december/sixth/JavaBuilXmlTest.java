package sixteen.december.sixth;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/12/6
 * Time: 14:29
 */
public class JavaBuilXmlTest {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "localhost";
    private static final String PASSWORD = "123456";

    public static void generate(){
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlVersion("1.0");
            /*document.setXmlStandalone(true);*/

            Element root = document.createElement("MobileNet");       //创建根节点
            document.appendChild(root);                               //将根节点添加到Document对象中

            Element pageElement = document.createElement("PAGE");     //设置第一个page元素到
            pageElement.setAttribute("NAME", "list.jsp");             //设置page节点的name属性

            Element methodElement = document.createElement("METHOD");   //设置method节点
            methodElement.setTextContent("get");                        //给method设置值
            pageElement.appendChild(methodElement);                     //添加method节点到page节点内

            Element displayElement = document.createElement("DISPLAY");    //设置method节点
            displayElement.setTextContent("list撒旦发放");                         //给display设置值
            pageElement.appendChild(displayElement);            //添加display节点到page节点内

            Element request_paramElement = document.createElement("REQUEST_PARAM");
            request_paramElement.setTextContent("request_param1|request_param2");
            pageElement.appendChild(request_paramElement);

            Element thirdElement = document.createElement("THIRD");
            pageElement.appendChild(thirdElement);

            Element third_element = document.createElement("TEST");
            third_element.setTextContent("test");
            thirdElement.appendChild(third_element);

            root.appendChild(pageElement);
            pageElement = document.createElement("PAGE");                    //设置第二个page元素到
            pageElement.setAttribute("NAME", "content.jsp");                 //设置page节点的name属性

            methodElement = document.createElement("METHOD");
            methodElement.setTextContent("post");

            pageElement.appendChild(methodElement);
            displayElement = document.createElement("DISPLAY");
            displayElement.setTextContent("content");

            pageElement.appendChild(displayElement);

            Element url_titleElement = document.createElement("URL_TITLE");        //设置url_title节点
            url_titleElement.setTextContent("title,publisher,published_calendar"); //给url_title设置值
            pageElement.appendChild(url_titleElement);                             //添加url_title节点到page节点内

            root.appendChild(pageElement);                                         //将page段加人根节点内

            TransformerFactory transFactory = TransformerFactory.newInstance();     //开始把Document映射到文件
            Transformer transFormer = transFactory.newTransformer();

            DOMSource domSource = new DOMSource(document);                           //设置输出结果

            File file = new File("F:\\test\\test\\temp\\MobileNetRule.xml"); //生成xml文件

            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(file);              //文件输出流
            StreamResult xmlResult = new StreamResult(out);                 //设置输入源

            transFormer.setOutputProperty(OutputKeys.INDENT, "yes");       //用于元素换行
            transFormer.setOutputProperty(OutputKeys.METHOD, "xml");       //用于缩进
            transFormer.transform(domSource, xmlResult);                    //输出xml文件
            System.out.println(file.getAbsolutePath());                     //测试文件输出的路径

            //控制台输出显示
            TransformerFactory  tf  =  TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty("{/encoding/}","GB2312/");
            t.setOutputProperty(OutputKeys.INDENT, "yes");                //用于元素换行
            t.setOutputProperty(OutputKeys.METHOD, "xml");                //用于缩进
            ByteArrayOutputStream boc  = new ByteArrayOutputStream();
            t.transform(new DOMSource(document), new StreamResult(boc));
            String xmlstring = boc.toString();
            System.out.println(xmlstring);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //JavaBuilXmlTest.generate();
        JavaBuilXmlTest.getData();
    }

    public static List<Order> getData(){
        Connection connection;
        Statement stmt;
        String sql;
        ResultSet rs;

        List<Order> orderList = new ArrayList<>();

        /*
        //连接数据库方式一
        String url = "jdbc:mysql://localhost:3306/test?" +
                "user=" + USERNAME + "&password=" + PASSWORD + "&" +
                "useUnicode=true&characterEncoding=UTF-8";*/
        //连接数据库方式二
        String url = "jdbc:mysql://localhost:3306/test?" +
                "useUnicode=true&characterEncoding=UTF-8";

        try {
            Class.forName(DRIVER);

            //连接数据库方式一
            //connection = DriverManager.getConnection(url);
            //连接数据库方式二
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("加载MySQL驱动程序成功！");
            } else {
                System.out.println("加载MySQL驱动程序失败！");
            }

            //得到普通ResultSet
            stmt = connection.createStatement();
            //得到可滚动ResultSet
            //stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "select * from t_order WHERE id < 1600";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setStatus(rs.getString("status"));
                order.setMerchantOrderNo(rs.getString("merchant_order_no"));
                order.setDeletedFlag(rs.getString("deleted_flag"));
                order.setUpdatedUserId(rs.getLong("updated_user_id"));
                orderList.add(order);

                System.out.println("id: " + rs.getLong("id"));
                System.out.println("status: " + rs.getString("status"));
                System.out.println("merchant_order_no: " + rs.getString("merchant_order_no"));
                System.out.println("//=============================================================//");
            }

            if (!rs.isClosed()) {
                rs.close();
            }
            if (!stmt.isClosed()) {
                stmt.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("TEST!!");
            System.out.println("数据库数据成功获取!!");
        }

        return orderList;
    }

    public static class  Order {
        private Long id;
        private String status;
        private String merchantOrderNo;
        private String deletedFlag = "0";
        private Long updatedUserId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMerchantOrderNo() {
            return merchantOrderNo;
        }

        public void setMerchantOrderNo(String id) {
            this.merchantOrderNo = merchantOrderNo;
        }

        public String getDeletedFlag() {
            return deletedFlag;
        }

        public void setDeletedFlag(String deletedFlag) {
            this.deletedFlag = deletedFlag;
        }

        public Long getUpdatedUserId() {
            return updatedUserId;
        }

        public void setUpdatedUserId(Long updatedUserId) {
            this.updatedUserId = updatedUserId;
        }
    }
}

/*
结果集(ResultSet)是数据中查询结果返回的一种对象，可以说结果集是一个存储查询结果的对象，但是结果集并不仅仅具有存储的功能，
他同时还具有操纵数据的功能，可能完成对数据的更新等。

结果集读取数据的方法主要是getXXX() ，他的参数可以使整型表示第几列（是从1开始的），还可以是列名。
返回的是对应的XXX类型的值。如果对应那列时空值，XXX是对象的话返回XXX型的空值，如果XXX是数字类型，如Float等则返回0，boolean返回false。
使用getString()可以返回所有的列的值，不过返回的都是字符串类型的。
XXX可以代表的类型有：基本的数据类型如整型(int)，布尔型(Boolean)，浮点型(Float,Double)等，比特型（byte），
还包括一些特殊的类型，如：日期类型（java.sql.Date），时间类型(java.sql.Time)，时间戳类型 (java.sql.Timestamp)，
大数型(BigDecimal和BigInteger等)等。
还可以使用getArray(int colindex/String columnname)，通过这个方法获得当前行中，colindex所在列的元素组成的对象的数组。
使用getAsciiStream(int colindex/String colname)可以获得该列对应的当前行的ascii流。
也就是说所有的getXXX方法都是对当前行进行操作。

结果集从其使用的特点上可以分为四类，这四类的结果集的所具备的特点都是和Statement语句的创建有关，
因为结果集是通过Statement语句执行后产生的，所以可以说，结果集具备何种特点，完全决定于Statement，当然我是说下面要将的四个特点，
在Statement创建时包括三种类型。首先是无参数类型的，他对应的就是下面要介绍的基本的ResultSet对应的Statement。
下面的代码中用到的Connection并没有对其初始化，变量conn代表的就是Connection对应的对象。SqlStr代表的是响应的SQL语句。

1、    最基本的ResultSet。
之所以说是最基本的ResultSet是因为，这个ResultSet他起到的作用就是完成了查询结果的存储功能，而且只能读去一次，不能够来回的滚动读取。
这种结果集的创建方式如下：

Statement st = conn.CreateStatement
ResultSet rs = Statement.excuteQuery(sqlStr);

由于这种结果集不支持，滚动的读去功能所以，如果获得这样一个结果集，只能使用它里面的next()方法，逐个的读去数据。

2、    可滚动的ResultSet类型。
这个类型支持前后滚动取得纪录next（）、previous()，回到第一行first()，同时还支持要去的ResultSet中的第几行 absolute（int n），
以及移动到相对当前行的第几行relative(int n)，要实现这样的ResultSet在创建Statement时用如下的方法。

Statement st = conn. createStatement (int resultSetType, int resultSetConcurrency)
ResultSet rs = st.executeQuery(sqlStr)

其中两个参数的意义是：
resultSetType 是设置 ResultSet 对象的类型可滚动，或者是不可滚动。取值如下：
       ResultSet.TYPE_FORWARD_ONLY 只能向前滚动
       ResultSet.TYPE_SCROLL_INSENSITIVE 和 Result.TYPE_SCROLL_SENSITIVE 这两个 方法都能够实现任意的前后滚动，
       使用各种移动的 ResultSet 指针的方法。二者的区别在于前者对于修改不敏感，而后者对于修改敏感。
resultSetConcurency 是设置 ResultSet 对象能够修改的，取值如下：
       ResultSet.CONCUR_READ_ONLY 设置为只读类型的参数。
       ResultSet.CONCUR_UPDATABLE 设置为可修改类型的参数。
所以如果只是想要可以滚动的类型的 Result 只要把 Statement 如下赋值就行了。

Statement st = conn.createStatement(Result.TYPE_SCROLL_INSENITIVE,
                          ResultSet.CONCUR_READ_ONLY);
ResultSet rs = st.excuteQuery(sqlStr) ；

用这个 Statement 执行的查询语句得到的就是可滚动的 ResultSet 。



3、    可更新的ResultSet
这样的ResultSet对象可以完成对数据库中表的修改，但是我知道ResultSet只是相当于数据库中表的视图，
所以并不时所有的ResultSet只要设置了可更新就能够完成更新的，能够完成更新的ResultSet的SQL语句必须要具备如下的属性：
    a 、只引用了单个表。
    b 、不含有join或者group by子句。
    c 、那些列中要包含主关键字。
    具有上述条件的，可更新的ResultSet可以完成对数据的修改，可更新的结果集的创建方法是：

Statement st = createstatement(Result.TYPE_SCROLL_INSENSITIVE,Result.CONCUR_UPDATABLE)



4、    可保持的ResultSet
正常情况下如果使用Statement执行完一个查询，又去执行另一个查询时这时候第一个查询的结果集就会被关闭，也就是说，
所有的Statement的查询对应的结果集是一个，如果调用Connection的commit()方法也会关闭结果集。
可保持性就是指当ResultSet的结果被提交时，是被关闭还是不被关闭。JDBC2.0和1.0提供的都是提交后ResultSet就会被关闭。
不过在JDBC3.0中，我们可以设置ResultSet是否关闭。要完成这样的ResultSet的对象的创建，要使用的Statement的创建要具有三个参数，
这个Statement的创建方式也就是，我所说的 Statement的第三种创建方式。


本文来自CSDN博客，转载请标明出处：http://blog.csdn.net/zeuskaaba/archive/2009/09/04/4517894.aspx

当使用ResultSet的时候，当查询出来的数据集记录很多，有一千万条的时候，那rs所指的对象是否会占用很多内存，如果记录过多，
那程序会不会把系统的内存用光呢

不会的，ResultSet表面看起来是一个记录集，其实这个对象中只是记录了结果集的相关信息，具体的记录并没有存放在对象中，
具体的记录内容知道你通过next方法提取的时候，再通过相关的getXXXXX方法提取字段内容的时候才能从数据库中得到，这些并不会占用内存，
具体消耗内存是由于你将记录集中的数据提取出来加入到你自己的集合中的时候才会发生，
如果你没有使用集合记录所有的记录就不会发生消耗内存厉害的情况。
 */