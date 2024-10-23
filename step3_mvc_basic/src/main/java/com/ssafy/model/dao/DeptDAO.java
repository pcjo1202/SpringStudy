package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.ssafy.model.dto.Dept;

public interface DeptDAO {
	// 부서 등록
	boolean insertDept(Dept dept);

	// 부서 수정
	boolean updateDept(Dept dept);

	// 부서 삭제
	boolean deleteDept(int deptno);

	// 부서 조회
	Dept selectDept(int deptno);

	// 부서 목록 조회
	List<Dept> selectDepts();

	// 부서 목록 조회
	List<Dept> selectDeptsByDname(String dname);
}
