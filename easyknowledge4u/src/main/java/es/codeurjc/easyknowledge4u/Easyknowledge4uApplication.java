package es.codeurjc.easyknowledge4u;


import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

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
	
	/*@Bean
    public Config config() {
    Config config = new Config();
    JoinConfig joinConfig = config.getNetworkConfig().getJoin();
    joinConfig.getMulticastConfig().setEnabled(false);

    List<String> serversList = new ArrayList<String>();
    serversList.add("easyknowledge4u");
    serversList.add("easyknowledge4u2");

    joinConfig.getTcpIpConfig().setEnabled(true).setMembers(serversList);
    return config;
    }
*/
}
