package com.film.mapper;


import java.util.List;


import com.film.entity.Film;
import com.film.vo.FilmVo;

/**
* @author 郑伟
* @date 2018年3月14日 上午11:12:38
* @describe
*/

public interface FilmMapper {
	
	//查询所有电影清单
	
	public  List<Film> getAllFilms();
	
	public  void addFilm(Film film);
	
	public  List<Film> selectByFilmName(FilmVo filmVo);
	
	public void updateFilm(Film film);
	
	public  Film selectId(Integer id);
	
	
	/**
	 * 批量删除
	 */
	public void batchDeleteFilms(String[] ids);
	
	
	/**
	 * 查询总记录数
	 */
	public int selectCountByCondition(FilmVo filmVo);
	
	/**
	 * 查询分页
	 */
	public List<Film> selectListByPage(FilmVo filmVo);
	
}
