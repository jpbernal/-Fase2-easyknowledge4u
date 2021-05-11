package es.codeurjc.easyknowledge4u;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class Easyknowledge4uApplication {
	
	static final Log LOGGER = LogFactory.getLog(Easyknowledge4uApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Easyknowledge4uApplication.class, args);
	}
	
	@Bean
    public CacheManager cacheManager() {
    	LOGGER.info("...");
    	return new ConcurrentMapCacheManager("cacheManager");
    }

}
