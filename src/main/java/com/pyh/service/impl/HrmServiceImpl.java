package com.pyh.service.impl;

import com.pyh.dao.*;
import com.pyh.util.PageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pyh.domain.User;
import com.pyh.service.HrmService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{
	
	private static Logger log = Logger.getLogger(HrmServiceImpl.class);
	
	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;

    @Autowired
    protected DeptDao deptDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private DocumentDao documentDao;

	@Transactional(readOnly=true)
	public User login(String loginname, String password) {
		log.info("HrmServiceImpl "+ loginname +" login -- >>");
		return userDao.selectByLoginNameAndPassword(loginname, password);
	}

    @Transactional(readOnly=true)
    public List<User> findUser(User user, PageModel pageModel){
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        log.debug("select user:"+user);
        params.put("user",user);
        int recordCount = userDao.count(params);  //获取数据总条数
        if (recordCount!=0){
            pageModel.setRecordCount(recordCount);
        }
        params.put("pageModel",pageModel);
        List<User> users = userDao.selectByPage(params);
        log.debug(users);
        return users;
    }

    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setNoticeDao(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
}
