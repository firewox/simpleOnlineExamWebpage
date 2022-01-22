package cn.tust.myJavaWork.dao;

import cn.tust.myJavaWork.domain.User;

/**
 * @Author: Liyutian
 * @Date:Create：in 2020/11/22 16:40
 */
public interface IUserDao {
    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    public abstract User findUserByUsername(String username);

    /**
     * 根据用户名和密码登录
     * @param user
     * @return
     */
    public abstract User findUserByUsernameAndPassword(User user);

    /**
     * 注册用户
     * @param user
     */
    public abstract void saveUser(User user);
}
