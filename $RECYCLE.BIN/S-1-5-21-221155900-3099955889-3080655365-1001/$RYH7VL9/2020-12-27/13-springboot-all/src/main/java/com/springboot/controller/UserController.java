package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String userList(Model model){
        List<User>list= userService.getUserList();
        model.addAttribute("userList",list);
        return "userList";
    }
    @RequestMapping("/private/toUpdate")
    public String toUpdate(Long id,Model model){
        User user= userService.getUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    /**
     *默认情况在这里会出现异常，异常原因是因为页面中有一个birthday的数据时日期格式，但是
     * Spring默认情况是不能自动识别日期数据的，因此需要单独的指定日期格式才能将birthday数据
     * 完成封装，具体参考User对象中的birthday 属性
     */
    @RequestMapping("/private/update")
    public String update(User user, Model model){
        userService.update(user);
        model.addAttribute("message","修改成功点击确定返回列表页面");
        model.addAttribute("url","/");
        model.addAttribute("alertType","confirm");

        return "success";
    }
    @RequestMapping("/private/delete")
    public String delete(Long id, Model model){
        userService.deleteUserById(id);
        model.addAttribute("message","删除成功");
        model.addAttribute("url","/");
        model.addAttribute("alertType","alert");

        return "success";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Long id, Model model){
        return "login";
    }
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session){

        int result=userService.login(user);
        switch (result){
            case 1:
                model.addAttribute("errorMessage","账号错误");
                model.addAttribute("username",user.getUsername());
                return "login";
            case 2:
                model.addAttribute("errorMessage","密码错误");
                model.addAttribute("username",user.getUsername());
                return "login";
        }
        session.setAttribute("userSession",user);
        return "redirect:/";
    }
    @RequestMapping("/private/toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("/private/add")
    public String add(User user,Model model){

        int result=userService.add(user);
        if(result==1){
            model.addAttribute("errorMessage","账号已经存在！");

            return "success";
        }
        model.addAttribute("message","添加成功点击确定返回列表页面");
        model.addAttribute("url","/");
        model.addAttribute("alertType","confirm");

        return "success";
    }
}
