package com.film.mapper;


import com.film.entity.User;

/**   
*    
* 项目名称：filmSystem   
* 类名称：UserDao   
* 类描述：mapper接口
*      
*/
public interface UserMapper {
	//保存用户
	public void save(User user);
	
	//根据用户名查询用户
	public User queryUserByName(String username);
	
}
