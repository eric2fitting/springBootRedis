package cn.prv.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {
    
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    
    /**
     * 读取缓存
     * @param Key
     * @return
     */
    public String get(String Key) {
        return redisTemplate.opsForValue().get(Key);
    }
    
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        boolean result = false;
        try {
                redisTemplate.opsForValue().set(key, value);
                result = true;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return result;
    }
    
    
    /**
     * 删除缓存
     * @param key
     * @return
     */
    public boolean delete(String key) {
        boolean result = false;
        try {
                redisTemplate.delete(key);
                result = true;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return result;
    }


}
