package cn.tust.myJavaWork.service;


import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;

public interface IRegisterService {
    /**
     * 注册
     * @param user
     * @return
     */
    public ResultInfo saveUser(User user);
}
