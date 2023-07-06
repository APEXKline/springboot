package ltd.newbee.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 13
 * @Configuration
 * @MapperScan("com.example.mapper") // 指定要扫描的Mapper接口所在的包路径
 * public class MyBatisConfig {
 *     // MyBatis配置相关的其他代码...
 * }
 * 在上述示例中，@MapperScan注解被应用在一个Java配置类上，
 * 指定了要扫描的Mapper接口所在的包路径为com.example.mapper。MyBatis会自动扫描该包下的Mapper接口，并将它们注册为可用的Mapper组件。
 */
@MapperScan("ltd.newbee.mall.dao")
@SpringBootApplication
public class NewBeeMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewBeeMallApplication.class, args);
    }
}
