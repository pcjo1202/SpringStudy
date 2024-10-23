package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Dept;
import com.ssafy.uitl.DBUtil;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String NAME_SPACE = "com.ssafy.model.dao.UserDAO";
	private SqlSession sqlSession;
	
	public UserDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public String login(Map<String, String> user) {
		return sqlSession.selectOne(NAME_SPACE+".login", user);
	}
}
