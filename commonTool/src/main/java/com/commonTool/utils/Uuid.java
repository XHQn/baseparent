/**
 * 
 */
package com.commonTool.utils;

import java.util.UUID;

/**
 * @author Administrator
 *
 */
public class Uuid {

	/**
	 * 获取uuid
	 */
	public Uuid() {
		
	}
	
	public static String getUuidStr(){
		UUID uuid = UUID.randomUUID();
		String uuid_str = uuid.toString().replace("-", "");
		return uuid_str;
	}
}
