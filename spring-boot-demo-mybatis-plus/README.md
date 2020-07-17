## spring-boot-demo-mybatis-plus

#pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.juejueguai</groupId>
        <artifactId>spring-boot-demo</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <groupId>com.example</groupId>
    <artifactId>spring-boot-demo-mybatis-plus</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-boot-demo-mybatis-plus</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.3.1.tmp</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

#yml

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring_boot_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
    type: com.zaxxer.hikari.HikariDataSource
    initialization-mode: always
    continue-on-error: true
    hikari:
      minimum-idle: 5
      connection-test-query: SELECT 1 FROM DUAL
      maximum-pool-size: 20
      auto-commit: true
      idle-timeout: 30000
      pool-name: SpringBootDemoHikariCP
      max-lifetime: 60000
      connection-timeout: 30000
logging:
  level:
    com.juejueguai: debug
    com..juejueguai.springbootdemomybatisplus.mapper: trace
mybatis-plus:
  mapper-locations: classpath:mappers/*.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.juejueguai.springbootdemomybatisplus.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  AUTO:"数据库ID自增", INPUT:"用户输入ID",ID_WORKER:"全局唯一ID (数字类型唯一ID)", UUID:"全局唯一ID UUID";
      id-type: auto
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: not_empty
      #驼峰下划线转换
      table-underline: true
      #是否开启大写命名，默认不开启
      #capital-mode: true
      #逻辑删除配置
      #logic-delete-value: 1
      #logic-not-delete-value: 0
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: true
server:
  port: 9004

# sql 文件
/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : spring_boot_test

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-07-17 16:16:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orm_role
-- ----------------------------
DROP TABLE IF EXISTS `orm_role`;
CREATE TABLE `orm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

-- ----------------------------
-- Records of orm_role
-- ----------------------------
INSERT INTO `orm_role` VALUES ('2', '普通用户');
INSERT INTO `orm_role` VALUES ('1', '管理员');


/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : spring_boot_test

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-07-17 16:17:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orm_user
-- ----------------------------
DROP TABLE IF EXISTS `orm_user`;
CREATE TABLE `orm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '加密后的密码',
  `salt` varchar(32) NOT NULL COMMENT '加密使用的盐',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `phone_number` varchar(15) NOT NULL COMMENT '手机号码',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '上次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

-- ----------------------------
-- Records of orm_user
-- ----------------------------
INSERT INTO `orm_user` VALUES ('2', 'user_2', '6c6bf02c8d5d3d128f34b1700cb1e32c', 'fcbdd0e8a9404a5585ea4e01d0e4d7a0', 'user2@xkcoding.com', '17300000002', '1', null, null, null);
INSERT INTO `orm_user` VALUES ('3', 'MybatisPlus修改名字', '123456456', '456', 'testSave3@xkcoding.com', '17300000003', '1', '2020-07-17 14:52:15', '2020-07-17 14:52:15', '2020-07-17 15:05:46');
INSERT INTO `orm_user` VALUES ('4', 'testSave4', '123456456', '456', 'testSave4@xkcoding.com', '17300000004', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('5', 'testSave5', '123456456', '456', 'testSave5@xkcoding.com', '17300000005', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('6', 'testSave6', '123456456', '456', 'testSave6@xkcoding.com', '17300000006', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('7', 'testSave7', '123456456', '456', 'testSave7@xkcoding.com', '17300000007', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('8', 'testSave8', '123456456', '456', 'testSave8@xkcoding.com', '17300000008', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('9', 'testSave9', '123456456', '456', 'testSave9@xkcoding.com', '17300000009', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('10', 'testSave10', '123456456', '456', 'testSave10@xkcoding.com', '173000000010', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('11', 'testSave11', '123456456', '456', 'testSave11@xkcoding.com', '173000000011', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('12', 'testSave12', '123456456', '456', 'testSave12@xkcoding.com', '173000000012', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('13', 'testSave13', '123456456', '456', 'testSave13@xkcoding.com', '173000000013', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('24', 'testSave14', '123456456', '456', 'testSave14@xkcoding.com', '173000000014', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('25', 'testSave15', '123456456', '456', 'testSave15@xkcoding.com', '173000000015', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('26', 'testSave16', '123456456', '456', 'testSave16@xkcoding.com', '173000000016', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('27', 'testSave17', '123456456', '456', 'testSave17@xkcoding.com', '173000000017', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('28', 'testSave18', '123456456', '456', 'testSave18@xkcoding.com', '173000000018', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('29', 'testSave19', '123456456', '456', 'testSave19@xkcoding.com', '173000000019', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');

# config文件
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }
}

@Configuration
@MapperScan(basePackages = {"com.juejueguai.springbootdemomybatisplus.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
# entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("orm_user")
public class User implements Serializable {
    private static final long serialVersionUID = -1840831686851699943L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 加密使用的盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(fill = INSERT)
    private Date createTime;
    /**
     * 上次登录时间
     */
    private Date lastLoginTime;
    /**
     * 上次更新时间
     */
    @TableField(fill = INSERT_UPDATE)
    private Date lastUpdateTime;
}

# mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
# service
public interface UserService extends IService<User> {
}

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

# test

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoMybatisPlusApplicationTests {
    @Test
    public void contextLoads() {
    }
}

@Slf4j
public class UserServiceTest extends SpringBootDemoMybatisPlusApplicationTests {
    @Autowired
    private UserService userService;
    /**
     * 测试Mybatis-Plus 新增
     */
    @Test
    public void testSave() {
        String salt = "456";
        User testSave3 = User.builder().name("testSave").password("123456" + salt).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new Date()).build();
        boolean save = userService.save(testSave3);
        Assert.assertTrue(save);
        log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());
    }
    /**
     * 测试Mybatis-Plus 批量新增
     */
    @Test
    public void testSaveList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 14; i < 20; i++) {
            String salt = "456";
            User user = User.builder().name("testSave" + i).password("123456" + salt).salt(salt).email("testSave" + i + "@xkcoding.com").phoneNumber("1730000000" + i).status(1).lastLoginTime(new Date()).build();
            userList.add(user);
        }
        boolean batch = userService.saveBatch(userList);
        Assert.assertTrue(batch);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("【userList#ids】= {}", ids);
    }
    /**
     * 测试Mybatis-Plus 删除
     */
    @Test
    public void testDelete() {
        boolean remove = userService.removeById(1L);
        User byId = userService.getById(1L);
        Assert.assertNull(byId);
    }
    /**
     * 测试Mybatis-Plus 修改
     */
    @Test
    public void testUpdate() {
        User user = userService.getById(3L);
        user.setName("MybatisPlus修改名字");
        boolean b = userService.updateById(user);
        Assert.assertTrue(b);
        User update = userService.getById(3L);
        Assert.assertEquals("MybatisPlus修改名字", update.getName());
        log.debug("【update】= {}", update);
    }
    /**
     * 测试Mybatis-Plus 查询单个
     */
    @Test
    public void testQueryOne() {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(false, User :: getId, 3L).orderByDesc(User::getId).last("limit 1"));
        Assert.assertNotNull(user);
        log.debug("【user】= {}", user);
    }
    /**
     * 测试Mybatis-Plus 查询全部
     */
    @Test
    public void testQueryAll() {
        List<User> list = userService.list(new QueryWrapper<>());
        Assert.assertTrue(!CollectionUtils.isEmpty(list));
        log.debug("【list】= {}", list);
    }
    /**
     * 测试Mybatis-Plus 分页排序查询
     */
    @Test
    public void testQueryByPageAndSort() {
        initData();
        int count = userService.count(new QueryWrapper<>());
        Page<User> userPage = new Page<>(1, 5);
        userPage.setDesc("id");
        IPage<User> page = userService.page(userPage, new QueryWrapper<>());
        Assert.assertEquals(5, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }
    /**
     * 测试Mybatis-Plus 自定义查询
     */
    @Test
    public void testQueryByCondition() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "Save1").or().eq("phone_number", "17300000001").orderByDesc("id");

        userService.getOne(wrapper);
        int count = userService.count(wrapper);
        Page<User> userPage = new Page<>(1, 3);
        IPage<User> page = userService.page(userPage, wrapper);
        Assert.assertEquals(3, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }
    /**
     * 初始化数据
     */
    private void initData() {
        testSaveList();
    }

}


