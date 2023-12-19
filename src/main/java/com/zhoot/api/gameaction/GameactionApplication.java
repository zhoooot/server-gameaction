package com.zhoot.api.gameaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@ComponentScan(basePackages = "com.zhoot.api.gameaction")
public class GameactionApplication {

	@Value("${redis.hostname}")
	private String redisHostname;

	@Value("${redis.port}")
	private int redisPort;

	public static void main(String[] args) {
		SpringApplication.run(GameactionApplication.class, args);
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory(String redisHostname, Integer redisPort) {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostname, redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<?, ?> powerTemplate() {
		RedisTemplate<?, ?> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory(redisHostname, redisPort));
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}
}
