package cn.tust.myJavaWork.dao.impl;

import cn.tust.myJavaWork.dao.IUserDao;
import cn.tust.myJavaWork.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public User findUserByUsername(String username) {
        try {
            DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
            dCriteria.add(Restrictions.eq("username",username));
            List<?> list = hibernateTemplate.findByCriteria(dCriteria);
            return list.size()>0 ? (User) list.get(0) : null;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User findUserByUsernameAndPassword(User user) {
        try {
            DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
            dCriteria.add(Restrictions.eq("username",user.getUsername()));
            dCriteria.add(Restrictions.eq("password",user.getPassword()));
            List<?> list = hibernateTemplate.findByCriteria(dCriteria);
            return list.size()>0 ? (User) list.get(0) : null;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        hibernateTemplate.save(user);
    }
}
