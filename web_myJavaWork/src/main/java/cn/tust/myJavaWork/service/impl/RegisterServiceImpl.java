package cn.tust.myJavaWork.service.impl;

import cn.tust.myJavaWork.dao.impl.UserDaoImpl;
import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;


@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private UserDaoImpl userDao;// = new UserDaoImpl();

    @Override
    public ResultInfo saveUser(User user) {
        User u1 = userDao.findUserByUsername(user.getUsername());
        if (u1!=null){
            return new ResultInfo(false,"用户名已存在！请换一个用户名。");
        }
        userDao.saveUser(user);
        return new ResultInfo(true,"注册成功！");
    }
}
