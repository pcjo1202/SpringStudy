package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.Map;

public interface UserService {

	String login(Map<String, String> user) throws SQLException;

}