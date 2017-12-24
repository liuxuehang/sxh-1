package com.lxit.oa.dao.impl;

import java.util.List;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.lxit.oa.beans.User;
import com.lxit.oa.dao.UserDao;


@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Resource
	public void setDaoSupportFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> selectAllUser() {
		System.out.println("dao~~~~~~~");
		List<User> users = this.getSqlSession().selectList("UserMapper.selectAllUser");
		return users;
	}

}
