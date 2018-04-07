package com.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.entity.Film;
import com.film.entity.PageBean;
import com.film.mapper.FilmMapper;
import com.film.service.FilmService;
import com.film.vo.FilmVo;

/**
* @author 郑伟
* @date 2018年3月14日 上午11:30:38
* @describe
*/
@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmMapper film;

	@Override
	public List<Film> getAllFilmList() {
		return film.getAllFilms();
	}

	@Override
	public String addFilms(Film films) {
		if(films.getId() != null) { //更新记录
			film.updateFilm(films);;
		}else { //新增记录
			film.addFilm(films);;
		}
		return "success";
	}

	@Override
	public List<Film> selectByFilm(FilmVo filmVo) {
		
		return film.selectByFilmName(filmVo);
	}

	@Override
	public Film selectById(Integer id) {
		return	film.selectId(id);		
	}

	@Override
	public void batchDeleteFilms(String[] ids) {
		film.batchDeleteFilms(ids);
	}

	@Override
	public PageBean<Film> queryFilmByCondition(Integer currentPage, Integer size, FilmVo filmVo) {
		//获取记录总数
				int count = film.selectCountByCondition(filmVo);
				//获取list集合
				filmVo.setCurrentPage(currentPage);
				filmVo.setPageCount(size);
				List<Film> filmList = film.selectListByPage(filmVo);
				PageBean<Film> pageBean = new PageBean<>(count, size);
				pageBean.setCurrent(currentPage);
				pageBean.setDatas(filmList);
				return pageBean;
	}


}
