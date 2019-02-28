package com.pyh.service.impl;

import com.pyh.dao.*;
import com.pyh.domain.Dept;
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

	@Override
	@Transactional(readOnly=true)
	public User login(String loginname, String password) {
		log.info("HrmServiceImpl "+ loginname +" login -- >>");
		return userDao.selectByLoginNameAndPassword(loginname, password);
	}

    /*****************用户服务接口实现*************************************/

	@Override
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

    /**
     * HrmServiceImpl接口removeUserById方法实现
     * @see { HrmService }
     * */
    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);
    }

    /**
     * HrmServiceImpl接口addUser方法实现
     * @see { HrmService }
     * */
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    /**
     * HrmServiceImpl接口updateUser方法实现
     * @see { HrmService }
     * */
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    /**
     * HrmServiceImpl接口findUserById方法实现
     * @see { HrmService }
     * */
    @Transactional(readOnly=true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    /*****************部门服务接口实现*************************************/

    @Transactional(readOnly=true)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    @Transactional(readOnly=true)
    @Override
    public List<Dept> findDept(Dept dept, PageModel pageModel) {
        Map<String,Object> param = new HashMap<>();
        param.put("dept",dept);
        log.info("select dept:"+dept);

        int deptCount = deptDao.count(param);
        log.info("deptCount:"+deptCount);
        pageModel.setRecordCount(deptCount);
        param.put("pageModel",pageModel);

        List<Dept> deptList = deptDao.selectByPage(param);
        return deptList;
    }

    @Transactional(readOnly=true)
    @Override
    public Dept findDeptById(int id) {
        return deptDao.selectById(id);
    }

    @Override
    public void removeDeptById(int id) {
        deptDao.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.update(dept);
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
