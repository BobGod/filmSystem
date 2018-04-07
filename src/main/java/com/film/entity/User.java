package com.film.entity;

import lombok.Data;

/**   
*    
* 项目名称：filmSystem   
* 类名称：User   
* 类描述：用户实体
*/
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", username=").append(username).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
