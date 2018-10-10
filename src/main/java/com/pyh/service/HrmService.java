package com.pyh.service;

import com.pyh.domain.User;
import com.pyh.util.PageModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HrmService {

	User login(String loginname, String password);

	List<User> findUser(User user, PageModel pageModel);

	void removeUserById(Integer id);

	void addUser(User user);

	void updateUser(User user);

	User findUserById(Integer id);
}
