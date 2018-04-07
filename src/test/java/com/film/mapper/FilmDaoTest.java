package com.film.mapper;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.film.entity.Film;
import com.film.vo.FilmVo;




public class FilmDaoTest {

	ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
	}

	

	@Test
	public void testFilmList() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		
		filmMapper.getAllFilms().forEach(System.out::println);
		
	}
	
	@Test
	public void testaddFilm() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		Film film = new Film();
		film.setId(2);
		film.setFilmNum("12312");
		film.setFilmName("ada");
		film.setFilmCategory("喜剧片");
		film.setLanguage("中文");
		film.setReleaseTime("2018-11-1");
		film.setActor("张军哥");
		film.setDirector("zhangjunge");
		film.setFilmYear("2018");
		film.setMovieHall("viphall");
		film.setPlayTime(new Date());
		film.setWord("中文");
		film.setSummary("来一斤积极");
		filmMapper.addFilm(film);
	}
	
	@Test
	public void testSelectByFilmName() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		FilmVo filmVo = new FilmVo();
		Film film = new Film();
		film.setFilmName("3");
		filmVo.setFilm(film);
		filmMapper.selectByFilmName(filmVo).forEach(System.out::println);;
		
	}
	
	@Test
	public void testUpdateFilm() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
	    Film film = filmMapper.selectId(11);
		film.setActor("z周星驰");
		filmMapper.updateFilm(film);
		
	}
	
	@Test
	public void testselectListByPage() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		FilmVo filmVo = new FilmVo();
		filmVo.setCurrentPage(1);
		filmVo.setPageCount(2);
		List<Film> films = filmMapper.selectListByPage(filmVo);
		
		films.forEach(System.out::println);
	}
	
	@Test
	public void selectCountByCondition() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		FilmVo filmVo = new FilmVo();
		int count = filmMapper.selectCountByCondition(filmVo);
		
		System.out.println(count);
	}
	
}
