package es.codeurjc.easyknowledge4u.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.easyknowledge4u.Easyknowledge4uApplication;

@RestController
public class CacheController {
	
	@Autowired
	private CacheManager cacheManager;
	private static final Logger LOGGER=LoggerFactory.getLogger(Easyknowledge4uApplication.class);	
	
	@RequestMapping(value="/cache", method=RequestMethod.GET)
	public Map<Object, Object> getCacheContent() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("cache");
		LOGGER.info(cache.toString());
		return cache.getNativeCache();
	}

}