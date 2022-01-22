package cn.tust.myJavaWork.service.impl;

import cn.tust.myJavaWork.dao.impl.UserDaoImpl;
import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserDaoImpl userDao;// = new UserDaoImpl();

    @Override
    public ResultInfo findUserByUsernameAndPassword(User user) {
        User u = userDao.findUserByUsernameAndPassword(user);
        if (u!=null){
            return new ResultInfo(true,u,"登录成功！");
        }
        return new ResultInfo(false,"用户名或密码错误！");
    }
}
