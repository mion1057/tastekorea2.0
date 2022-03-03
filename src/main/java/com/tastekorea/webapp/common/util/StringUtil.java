package com.tastekorea.webapp.common.util;


/**
 * 
 * @author Sage R Lee
 *
 */
public class StringUtil {
	
	/**
	 * 
	 * @param target
	 * @param delimiter
	 * @return
	 */
	public static String substring(String target, String delimiter) {
		return substring(target, delimiter, true);
	}
	
	
	/**
	 * 
	 * @param target
	 * @param deli
	 * @param after
	 * @return
	 */
	public static String substring(String target, String deli, boolean after) {
		if(!target.contains(deli)) {
			return target;
		}
		if(after) {
			return target.substring(target.indexOf(deli) + deli.length());
		}else {
			return target.substring(0, target.indexOf(deli));
		}
	}
	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}