package com.film.service;

import java.util.List;

import com.film.entity.Film;
import com.film.entity.PageBean;
import com.film.vo.FilmVo;

/**
* @author 郑伟
* @date 2018年3月14日 上午11:29:29
* @describe
*/

public interface FilmService {
	
	//查询所有电影清单
	
		public  List<Film> getAllFilmList();
		
		public String addFilms(Film Film);
		
		public List<Film> selectByFilm(FilmVo filmVo);
		
		
		public Film selectById(Integer id);
		
		public void batchDeleteFilms(String[] ids);
		
		/**
		 * 分页查询列表
		 * @param currentPage
		 * @param size
		 * @param filmVo
		 * @return
		 */
		public PageBean<Film> queryFilmByCondition(Integer currentPage,Integer size,FilmVo filmVo);

}
