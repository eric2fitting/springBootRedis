import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.prv.util.RedisService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
    
    @Resource
    private RedisService redisService;
    
    @Test
    public void set() {
        System.out.println("开始加入缓存");
        this.redisService.set("Redis_Test", "success?");
        System.out.println("加入缓存成功？");
    }
    
    @Test
    public void get() {
        String string=this.redisService.get("Redis_Test");
        System.out.println(string);
    }
    
    @Test
    public void del() {
        this.redisService.delete("Redis_Test");
        System.out.println("删除了？");
    }
}
