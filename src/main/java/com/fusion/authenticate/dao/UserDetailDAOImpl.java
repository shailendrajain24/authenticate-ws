package com.fusion.authenticate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fusion.authenticate.dao.mapper.UserDetailMapper;
import com.fusion.authenticate.jdbc.model.UserDetail;

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
		String SQL = "select * from userdetail where userID = ?";
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
