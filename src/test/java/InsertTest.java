import com.akon.springboot.mybatis.SpringbootMybatisApplication;
import com.akon.springboot.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class InsertTest {


    @Autowired
    UserService userService;

    @Test
    public void testInsert(){
//        int i = userService.insertBatch(null);

//        System.out.println("开始测试:"+i+"条数据被插入");
    }
}
