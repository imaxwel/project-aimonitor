package per.wph.common.redis;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return null;
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(3600*1L);
        Map<String, Long> expires = new HashMap<>();
        expires.put("perm", 60L);
        redisCacheManager.setExpires(expires);

        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate template = new StringRedisTemplate(factory);
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

    private void setSerializer(StringRedisTemplate template){
        @SuppressWarnings({ "rawtypes", "unchecked" })
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
    }
}
