package cn.tust.myJavaWork.web.servlet;

import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.ILoginService;
import cn.tust.myJavaWork.util.InitApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private ILoginService service = (ILoginService) InitApplicationContext.applicationContext.getBean("loginService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用service查询
        ResultInfo resultInfo = service.findUserByUsernameAndPassword(loginUser);
        //4.响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),resultInfo);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
