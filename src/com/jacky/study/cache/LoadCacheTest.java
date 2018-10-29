package com.jacky.study.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class LoadCacheTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("cache.map");
			if(file.exists()){
				ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream(new FileInputStream(file));
					Map<String,Map> readMap = (Map<String,Map>)ois.readObject();
					CacheHolder.loadCache(readMap);
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally{
					if(ois != null){
						try {
							ois.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			Map<String, Map<String, String>> cache = CacheHolder.getCache();
			Map<String,Long> timeCache = CacheHolder.getTimeCache();
			System.out.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
