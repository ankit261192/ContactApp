package com.ds.contactapp.util;

public class StringUtility {

	/**
	 * this class contains utility methods related to string operations
	 * @param items
	 * @return
	 */
	public static String toCommaSeperatedString(Object[] items)//all items will be comma separated 
	{
		
		StringBuilder sb=new StringBuilder();
		for(Object item:items) {
			sb.append(item).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
		
	}
}
