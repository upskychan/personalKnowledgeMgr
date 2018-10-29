package com.jacky.study.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CacheHolder {
	private static Map<String, Map<String, String>> cache = new ConcurrentHashMap<String, Map<String, String>>();
	private static Map<String,Long> timeCache = new ConcurrentHashMap<String,Long>();
	
	public static Map<String,Map> getWriteMap(){
		Map<String,Map> map = new ConcurrentHashMap<String,Map>();
		map.put("cache", cache);
		map.put("timeCache", timeCache);
		return map;
	}
	
	public static void loadCache(Map<String,Map> cacheMap){
		if(cacheMap != null){
			if(null !=cacheMap.get("cache")){
				CacheHolder.getCache().putAll(cacheMap.get("cache"));
			}
			if(null !=cacheMap.get("timeCache")){
				CacheHolder.getTimeCache().putAll(cacheMap.get("timeCache"));
			}
		}
	}
	
	/**
	 * @return the cache
	 */
	public static Map<String, Map<String, String>> getCache() {
		return cache;
	}
	/**
	 * @param cache the cache to set
	 */
	public static void setCache(Map<String, Map<String, String>> cache) {
		CacheHolder.cache = cache;
	}
	/**
	 * @return the timeCache
	 */
	public static Map<String, Long> getTimeCache() {
		return timeCache;
	}
	/**
	 * @param timeCache the timeCache to set
	 */
	public static void setTimeCache(Map<String, Long> timeCache) {
		CacheHolder.timeCache = timeCache;
	}
	
}
