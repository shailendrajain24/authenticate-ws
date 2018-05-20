package com.fusion.authenticate.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fusion.authenticate.jdbc.model.UserDetail;

public class UserDetailMapper implements RowMapper<UserDetail> {

	public UserDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDetail userDetail = new UserDetail();
		userDetail.setEmail(resultSet.getString("email"));
		userDetail.setFullname(resultSet.getString("fullname"));
		userDetail.setPass(resultSet.getString("pass"));
		userDetail.setUserID(resultSet.getString("userID"));
		userDetail.setUserName(resultSet.getString("userName"));
		return userDetail;
	}

}
