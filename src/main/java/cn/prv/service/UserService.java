package cn.prv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.prv.bean.User;
import cn.prv.mapper.UserMapper;
import cn.prv.util.RedisService;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private RedisService redisService;
    
    private String USER_KEY="redisTest";
    
    public String queryUserById(int id) {
        String key=USER_KEY+id;
        String result = this.redisService.get(key);
        if(result==null) {
            User user = this.userMapper.queryUserById(id);
            result=user.getName()+":"+user.getGender();
            this.redisService.set(key, result);
        }
        return result;
    }

    public boolean deleteUser(int id) {
        return this.redisService.delete(USER_KEY+id);
    }
    
    
}
