package com.lux.awaking.integration.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis的初始化
 *
 * 参考 https://blog.csdn.net/m0_59961940/article/details/127006604
 * https://blog.csdn.net/weixin_43769525/article/details/109569084
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // Json 序列化器
        ObjectMapper om = new ObjectMapper(); // https://blog.csdn.net/qq_42017395/article/details/107555339
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(om, Object.class);

        // String 序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        template.setKeySerializer(stringRedisSerializer); // key 序列化方式
        template.setHashKeySerializer(stringRedisSerializer); // hash的key 序列化方式

        template.setValueSerializer(jackson2JsonRedisSerializer); // value 序列化方式-json序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }

//    @Bean
//    public Redisson redisson() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
//        return (Redisson) Redisson.create(config);
//    }
}
