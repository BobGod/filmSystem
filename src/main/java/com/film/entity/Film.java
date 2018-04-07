package com.film.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.film.group.ValidGroup1;

import lombok.Data;


/**
* @author 郑伟
* @date 2018年3月14日 上午10:26:12
* @describe
*/
@Data
public class Film {
	
	private Integer id;
	
	@Size(min=1,max=30,message="{film.filmNum.length.error}",groups={ValidGroup1.class})
	private String filmNum;
	// 校验名称的长度在1-30个字符之间
	private String filmName;
	private String filmYear;
	private String filmCategory;
	private String language;
	private String word;
	private String director;// 导演
	private String actor;// 演员
	private String releaseTime;// 上映时间
	private String movieHall;// 影厅
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date playTime;// 播放时间
	private String summary;// 简介
	
	private String imgName; //上传的文件
	
	private String delFlag = "0";		//删除表示位 0正常 1删除
	
}
