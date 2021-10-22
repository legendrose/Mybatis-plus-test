package com.nj.mybatisplus.samples;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nj.mybatisplus.samples.dao.DeviceMapper;
import com.nj.mybatisplus.samples.dao.TAppMapper;

import com.nj.mybatisplus.samples.dao.TRoleMapper;
import com.nj.mybatisplus.samples.dao.TUserMapper;
import com.nj.mybatisplus.samples.entity.Device;
import com.nj.mybatisplus.samples.entity.TRole;
import com.nj.mybatisplus.samples.entity.TUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Resource
    private TAppMapper tAppMapper;
    @Resource
    private DeviceMapper deviceMapper;
    @Resource
    private TUserMapper tUserMapper;
    @Resource
    private TRoleMapper tRoleMapper;
/*
    @Resource
    private TUserService tUserService;*/

    @Test
    @Transactional
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        tUserMapper.insert(TUser.builder().name("21sa3445发彻底删除6").age(11).email("w谁主浮沉er").build());
        tUserMapper.insert(TUser.builder().name("dx123123sad").age(11).email("we需r").build());
        List<TUser> userList = tUserMapper.selectList(null);
        Assert.assertEquals(2, userList.size());
        userList.forEach(System.out::println);
        //条件构造器
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","123123");
        //分页
        IPage<TUser> pages = new Page<>(1,2);

        IPage<TUser> itemPages = tUserMapper.selectPage(pages,queryWrapper);

        System.out.println("总条数"+itemPages.getTotal());

        List<TUser> list = itemPages.getRecords();
        System.out.println("分页记录"+list);
//        System.out.println("分页记录PageUI"+new PageUI(itemPages.getTotal(),list));
    }
    @Test
    @Transactional
    public void testOneMore() {

        //获取角色关联的用户信息
        List<TRole> list = tRoleMapper.selectUser();


    }
    @Test
    public void testSelec1t() {
       /* tAppMapper.insert(TApp.builder()
                .appId("sdfsdfsdf")
                .userName("12321")
                .createDate(new Date())
        .build());*/
        deviceMapper.insert(Device.builder()
                .createtime(new Date())
        .build());


//        System.out.println(tAppMapper.(null));
       /* System.out.println(("----- selectAll method test ------"));
         tUserService.insert(TUser.builder()
                .age(11)
                .build());
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);*/
    }

    /**
     * JDBC 深入理解PreparedStatement和Statement
     *
     * https://www.jianshu.com/p/50a33f2046dd
     */
    @Test
    public void showUser(){
        //数据库连接
        Connection connection = null;
        //预编译的Statement，使用预编译的Statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果 集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?&useServerPrepStmts=true", "root", "1q2w3e");
            //定义sql语句 ?表示占位符
            String sql = "select * from t_user where name = ?";
            //获取预处理statement
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();

            preparedStatement.setString(1, "张三");
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
            }
            resultSet.close();
            preparedStatement.close();

            System.out.println("#############################");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
