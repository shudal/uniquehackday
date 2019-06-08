package moe.perci.hackday.controller;

import moe.perci.hackday.config.CodeConfig;
import moe.perci.hackday.model.User;
import moe.perci.hackday.model.service.UserService;
import moe.perci.hackday.util.MyEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public HashMap<String, Object> login(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setProvince(request.getParameter("province"));
            user.setCity(request.getParameter("city"));
            user.setCounty(request.getParameter("county"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(Integer.parseInt(request.getParameter("phone")));

            user.setPassword(MyEncrypt.sha1(request.getParameter("password")));
            user.setSchool(request.getParameter("school"));
            user.setEducationBg(request.getParameter("educationBg"));
            user.setIdNumber(request.getParameter("idNumber"));
            user.setNameOfContactPerson(request.getParameter("nameOfContactPerson"));
            user.setStatus(CodeConfig.STATUS_USER_NORMAL);
            user.setRole(Integer.parseInt(request.getParameter("role")));

            if (user.getRole() == CodeConfig.ROLE_DEMAND_SIDE) {

            }

            result.put("code", 1);
            result.put("msg", "OK");
        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("login")
    public HashMap<String, Object> login(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            String username = request.getParameter("username");
        } catch (Exception e) {

        }
        return result;
    }

    public HashMap<String, Object> t(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {

        } catch (Exception e) {

        }
        return result;
    }
}
