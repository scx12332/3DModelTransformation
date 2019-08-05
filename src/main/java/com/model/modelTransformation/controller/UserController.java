package com.model.modelTransformation.controller;
import com.model.modelTransformation.entity.Response;
import com.model.modelTransformation.entity.User;
import com.model.modelTransformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by xpwu on 2019/6/18.
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;


    @RequestMapping(value = "/index")
    public ModelAndView index()
    {
        return new ModelAndView("/index.html");
    }

    @RequestMapping(value = "/regist")
    public String register(@RequestParam Map<String, Object> person, HttpServletResponse response) throws IOException {
        String username = person.get("username").toString();
        String password = person.get("password").toString();
        String phone = person.get("phone").toString();
        List<User> users =  service.queryByUsername(username);
        //1.判断是否有重复用户名
        if(users!=null && users.size()>0){
            getAlert(response, "alert('此用户名已存在，请重新输入！');");
            return "/regist";
        }else {
            int count = service.addUser(username,password,phone);
            if(count>0){
                //2.没有重复用户名，注册成功
                return "/login";
            }else {
                return "/regist";
            }
        }
    }


    @RequestMapping(value = "/login")
    public String login(@RequestParam Map<String, String> person,HttpServletResponse response,HttpServletRequest request) throws IOException {
        String username = person.get("username");
        String password =person.get("password");
        List<User> users =  service.queryByUsername(username);
        //1. 判断用户名是否存在
        if(users!=null && users.size()>0){
            User user = users.get(0);
            //2. 判断密码是否正确
            if(password.equals(user.getPassword())){
                request.getSession().setAttribute("msg",user);
                //3. 密码正确，登陆成功
                return "/index";
            }else {
                getAlert(response, "alert('登陆失败，密码错误');");
                return "/login";
            }
        }else {
            getAlert(response, "alert('登陆失败，用户名不存在');");
            return "/login";
        }
    }

    private void getAlert(HttpServletResponse response, String s) throws IOException {
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out = response.getWriter();
        out.flush();
        out.println("<script>");
        out.println(s);
        out.println("history.back();");
        out.println("</script>");

    }
}