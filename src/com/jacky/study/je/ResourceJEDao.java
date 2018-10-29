package com.jacky.study.je;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class ResourceJEDao {
	private static Environment dbEnvironment = null;
	private static Database database = null;
	private static boolean inited = false;
	private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

	private static boolean init() {
		if (!inited) {
			lock.lock();
			try {
				if (!inited) {
					EnvironmentConfig envConfig = new EnvironmentConfig();
					envConfig.setAllowCreate(true);// 如果不存在则创建一个
					File dir = new File("D://je" + File.separator + "resources");
					dir.mkdirs();
					dbEnvironment = new Environment(new File(
							dir.getAbsolutePath()), envConfig);
					DatabaseConfig dbConfig = new DatabaseConfig();
					dbConfig.setAllowCreate(true);
					dbConfig.setUseExistingConfig(true);
					dbConfig.setSortedDuplicates(true);
					dbConfig.setTransactional(false);
					dbConfig.setDeferredWrite(true);
					database = dbEnvironment.openDatabase(null,
							"edataresource", dbConfig);
				}
				inited = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		return inited;
	}

	public static Set<String> getAllKeys() {
		Set<String> set = new HashSet<String>();
		Cursor cursor = null;
		try {
			cursor = database.openCursor(null, null);
			byte[] keybytes = ("").getBytes();
			DatabaseEntry theKey = new DatabaseEntry(keybytes);
			DatabaseEntry queryKey = new DatabaseEntry();
			DatabaseEntry value = new DatabaseEntry();
			queryKey.setData(keybytes);
			OperationStatus status = cursor.getSearchKeyRange(theKey, value,
					LockMode.DEFAULT);
			if (status == OperationStatus.SUCCESS) {
				if (cursor.getCurrent(theKey, value, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
					String keyString = new String(theKey.getData());
					set.add(keyString);
				}
				while (cursor.getNext(theKey, value, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
					String keyString = new String(theKey.getData());
					set.add(keyString);
				}
			}
		} catch (DatabaseException dbe) {
			dbe.printStackTrace();
		} finally {
			cursor.close();
		}
		return set;
	}

	public static void insert(String key, String value) {
		init();
		byte[] keybytes = (key).getBytes();
		DatabaseEntry theKey = new DatabaseEntry(keybytes);
		DatabaseEntry theData = new DatabaseEntry((value).getBytes());
		database.put(null, theKey, theData);
	}

	public static void sync() {
		init();
		database.sync();
	}

	public static String get(String key) {
		init();
		byte[] keybytes = key.getBytes();
		DatabaseEntry queryKey = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		queryKey.setData(keybytes);
		OperationStatus status = database.get(null, queryKey, value,
				LockMode.DEFAULT);
		if (status == OperationStatus.SUCCESS) {
			return new String(value.getData());
		}

		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceJEDao.init();
		System.out.println(ResourceJEDao.getAllKeys());
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//		}
		for (int i = 10; i < 20; i++) {
			String key = "key_" + i;
			ResourceJEDao.insert(key, (new Date() + ""));
		}
		ResourceJEDao.sync();
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//		}
		System.out.println(ResourceJEDao.get("key_10"));
		System.out.println(ResourceJEDao.getAllKeys());
	}

}
