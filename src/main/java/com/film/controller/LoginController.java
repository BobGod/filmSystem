package com.film.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.film.entity.User;
import com.film.service.UserService;

/**   
*    
* 项目名称：filmSystem   
* 类名称：LoginController   
* 类描述：用户登录controller
*      
*/
@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	UserService us;
	
	@RequestMapping("/login")
	public String login() throws Exception {
		return "login";
	}
	
	
	@RequestMapping("/loginHandler" )
	@ResponseBody
		public String loginHandler(User user,HttpSession session) throws Exception {
			session.setAttribute("user", user);
			return us.checkUser(user.getUsername(), user.getPassword());
		}
	
	
}
