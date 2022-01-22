package cn.tust.myJavaWork.web.servlet;

import cn.tust.myJavaWork.domain.ResultInfo;
import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.IRegisterService;
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


@WebServlet("/registerUserServlet")
public class RegisterServlet extends HttpServlet{

    private IRegisterService service = (IRegisterService) InitApplicationContext.applicationContext.getBean("registerService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User registerUser = new User();
        try {
            BeanUtils.populate(registerUser,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用service注册
        ResultInfo resultInfo = service.saveUser(registerUser);
        //4.回显数据
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
