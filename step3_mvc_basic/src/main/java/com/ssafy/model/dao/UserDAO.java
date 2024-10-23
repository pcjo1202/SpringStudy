package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.Map;

public interface UserDAO {

	String login(Map<String, String> user);

}