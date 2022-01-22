package cn.tust.myJavaWork.service;


import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;

public interface ILoginService {
    /**
     * 登录
     * @param user
     * @return
     */
    public ResultInfo findUserByUsernameAndPassword(User user);
}
