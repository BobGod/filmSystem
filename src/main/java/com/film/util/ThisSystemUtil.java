package com.film.util;

import com.film.exception.ThisSystemException;

/**
* @author 郑伟
* @date 2018年3月13日 下午9:46:08
* @describe
*/

public class ThisSystemUtil {
	public static String throwIfBlank(String message,String target){
		if(target==null||(target=target.trim()).length()==0){
			throw new ThisSystemException(message);
		}
		return message;
	}
	
	public static String $(String message,String target){
		return throwIfBlank(message,target);
	}
}
