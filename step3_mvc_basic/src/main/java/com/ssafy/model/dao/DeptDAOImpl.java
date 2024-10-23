package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Dept;
import com.ssafy.uitl.DBUtil;

@Repository
public class DeptDAOImpl implements DeptDAO {

	private static final String NAME_SPACE = "com.ssafy.model.dao.DeptDAO";
	private SqlSession sqlSession;

	public DeptDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean insertDept(Dept dept) {
		return sqlSession.insert(NAME_SPACE + ".insertDept", dept) > 0;
	}

	@Override
	public boolean updateDept(Dept dept) {
		return sqlSession.update(NAME_SPACE + ".updateDept", dept) > 0;
	}

	@Override
	public boolean deleteDept(int deptno) {
		return sqlSession.delete(NAME_SPACE + ".deleteDept", deptno) > 0;
	}

	@Override
	public Dept selectDept(int deptno) {
		return sqlSession.selectOne(NAME_SPACE + ".selectDept", deptno);
	}

	@Override
	public List<Dept> selectDepts() {
		return sqlSession.selectList(NAME_SPACE + ".selectDepts");
	}

	@Override
	public List<Dept> selectDeptsByDname(String dname) {
		return sqlSession.selectList(NAME_SPACE + ".selectDeptsByDname", dname);
	}
}
