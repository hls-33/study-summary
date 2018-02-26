package com.bwf.service.login;

import com.bwf.entry.User;

public interface LoginService {
	boolean login(User user);
	boolean regist(User user);
}
