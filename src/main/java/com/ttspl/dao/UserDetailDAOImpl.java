package com.ttspl.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ttspl.dao.mapper.UserDetailMapper;
import com.ttspl.jdbc.model.UserDetail;

public class UserDetailDAOImpl implements UserDetailDAO{

	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	public void createUser(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
	}

	public UserDetail getUser(String id) {
		System.out.println("---getUser---");
		String SQL = "SELECT * FROM USERS WHERE UESRNAME = ?";
	      UserDetail userDetail = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new UserDetailMapper());
	      System.out.println("etUser::::::;; - " +userDetail.getUserID());
	      return userDetail;
	}

	public List<UserDetail> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
	}

}
