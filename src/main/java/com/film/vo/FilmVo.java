package com.film.vo;

import com.film.entity.Film;

import lombok.Data;

/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmVo   
* 类描述：查询条件包装类
*      
*/
@Data
public class FilmVo {
	private Film film;
	
	private int currentPage;	//当前页
	
	private int pageCount;		//每页显示记录数
	
	
}
