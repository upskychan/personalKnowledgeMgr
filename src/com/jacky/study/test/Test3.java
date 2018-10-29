package com.jacky.study.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Test3 {
	public static void main(String[] args) {
		Map<String,Long> timeMap = new ConcurrentHashMap<String,Long>();
		timeMap.put("aaa", System.currentTimeMillis());
		Long value = timeMap.get("aaa");
		value = timeMap.get("bbb");
		long value2 = timeMap.get("bbb");
		Map<String,Set<String>> map = new ConcurrentHashMap<String,Set<String>>();
		for(int i=0;i<10;i++){
			String str = "zhangsan,lisi,wangwu,renliu";
			if(i==6){
				str = "zhangsan,abc,ddd";
			}
			String[] users = str.split(",");
			Set<String> userSet = new HashSet<String>();
			for(String userName : users){
				userSet.add(userName);
			}
			for(String userName : users){
				Set<String> rUsers = map.get(userName);
				if(rUsers == null){
					rUsers = new ConcurrentSkipListSet<String>();
				}
				rUsers.addAll(userSet);
				rUsers.remove(userName);
				map.put(userName, rUsers);
			}
		}
		System.out.println(map);
	}
}
