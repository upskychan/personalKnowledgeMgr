package com.jacky.study.cache;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WriteCacheTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Map<String, String>> cache = CacheHolder.getCache();
		for(int i=0;i<10;i++){
			Map<String, String> map = new ConcurrentHashMap<String,String>();
			for(int j=0;j<5;j++){
				map.put(i+"_"+j, (new Date()).toString());
			}
			cache.put(i+"", map);
		}
		Map<String,Long> timeCache = CacheHolder.getTimeCache();
		for(int k=0;k<8;k++){
			timeCache.put(k+"", System.currentTimeMillis());
		}
		Map<String,Map> writeMap = CacheHolder.getWriteMap();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("cache.map"));
			oos.writeObject(writeMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos != null){
				try {
					oos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
