package com.film.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.film.entity.Film;
import com.film.entity.PageBean;
import com.film.service.FilmService;
import com.film.vo.FilmVo;

/**
 * @author 郑伟
 * @date 2018年3月14日 下午12:56:11
 * @describe
 */
@Controller
@RequestMapping("/back")
public class FilmListController {
	private static final Integer pageSize = 5;
	private static final Integer firstPage = 1;
	@Autowired
	private FilmService fi;

	@RequestMapping("/filmList")
	public String filmList(Model model,FilmVo filmVo) throws Exception {
		List<Film> filmList = fi.selectByFilm(filmVo);
		model.addAttribute("filmList", filmList);
		return "filmList";
	}
		
	

	@RequestMapping("/add")
	public String saveFilm() throws Exception {
		return "filmForm";
	}

	@RequestMapping("/saveFilm")
	public String addFilm(Film film) throws Exception {
		fi.addFilms(film);
		return "redirect:filmList";

	}

	// 模糊查询
	@RequestMapping("/selectFilm")
	public String selectFilm(Model model, FilmVo filmVo) throws Exception {
		model.addAttribute("filmList", fi.selectByFilm(filmVo));
		return "filmList";
	}

	@RequestMapping("/form")
	public String updateFilm(Model model, Integer id) throws Exception {
		Film film = fi.selectById(id);
		model.addAttribute("film", film);
		return "filmForm";
	}

	// 删除影片
	@RequestMapping("/filmDel")
	@ResponseBody
	public String filmDel(String ids) throws Exception {
		String[] filmIds = ids.split(",");
		fi.batchDeleteFilms(filmIds);
		return "success";
	}

	@RequestMapping("/FilmJpg")
	public String FilmJpg() throws Exception {
		return "FilmJpg";
	}

	@RequestMapping(value = "/upload")
	public String editItemsSubmit(Model model,
			//@ModelAttribute(value="item")
			 Film film,BindingResult bindingResult,
			MultipartFile items_pic	//接收上传的图片
			) throws Exception {
		
		//捕获异常
		if(bindingResult.hasErrors()) {
			//输出异常信息
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.getDefaultMessage());
			}
			
			//将错误提示放到model中
			model.addAttribute("errors", errors);
			
			model.addAttribute("film", film);
			
			//重新返回到表单页面
			return "FilmJpg";
		}
		
		//图片上传
		//上传图片处理
		String originalFileName = items_pic.getOriginalFilename();
		
		if(items_pic != null 
				&& originalFileName != null 
				&& originalFileName.length() > 0) {
			//定义存储图片的路径
			String storgePath = "F:\\upload\\temp\\";
			//获取新图片的名称 xx.jpg
			String newFileName = UUID.randomUUID() 
					+ originalFileName.substring(originalFileName.lastIndexOf("."));
			
			//创建新文件
			File newFile = new File(storgePath + newFileName);
			
			//将内存中的数据写入文件
			items_pic.transferTo(newFile);
			
			//将新文件名称保存到实体的pic属性上
			film.setFilmName(newFileName);
		}
		
		//调用service完成信息保存
		fi.addFilms(film);
		
		return "success";
		//return "forward:queryItems.action";
	}
	
	//获取影片列表信息
		@RequestMapping("/getFilmData")
		public String getFilmData(Model model,FilmVo filmVo,HttpServletRequest request) throws Exception{
			String pageNo = request.getParameter("page");
			String filmName = request.getParameter("filmName");
			System.out.println(filmName);
			if(filmName != null){
				Film film = new Film();
				film.setFilmName(filmName);
				filmVo.setFilm(film);
			}
			if(pageNo == null){
				pageNo = String.valueOf(firstPage);
			}
			PageBean<Film> page = fi.queryFilmByCondition(Integer.valueOf(pageNo), pageSize, filmVo);
			request.setAttribute("page", page);
			
			return "filmListDataPage";
		}
	}
		
	
