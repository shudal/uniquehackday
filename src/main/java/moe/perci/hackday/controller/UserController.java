package moe.perci.hackday.controller;

import moe.perci.hackday.config.CodeConfig;
import moe.perci.hackday.model.User;
import moe.perci.hackday.model.service.UserService;
import moe.perci.hackday.util.MyEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public HashMap<String, Object> register(HttpServletRequest request, HttpSession httpSession) {
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
            user.setPhone(request.getParameter("phone"));

            user.setPassword(MyEncrypt.sha1(request.getParameter("password")));
            user.setSchool(request.getParameter("school"));
            user.setEducationBg(request.getParameter("educationBg"));
            user.setIdNumber(request.getParameter("idNumber"));
            user.setNameOfContactPerson(request.getParameter("nameOfContactPerson"));
            user.setStatus(CodeConfig.STATUS_USER_NORMAL);
            user.setRole(Integer.parseInt(request.getParameter("role")));
            user.setDescription(request.getParameter("description"));
            user.setSchoolLevel(request.getParameter("schoolLevel"));

            if (user.getRole() == CodeConfig.ROLE_DEMAND_SIDE) {
                user.setUsername(user.getPhone() + "");
            } else {
                user.setUsername(user.getIdNumber());
            }

            userService.save(user);

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
            String _username = request.getParameter("username");
            String _password = request.getParameter("password");

            User user = userService.findUserByUsernameAndStatus(_username, CodeConfig.STATUS_USER_NORMAL);

            if (MyEncrypt.sha1(_password).equals(user.getPassword())) {
                httpSession.setAttribute("id", user.getId());
                httpSession.setAttribute("role", user.getRole());

                HashMap<String, Object> data = new HashMap<>();
                data.put("id", user.getId());
                data.put("role", user.getRole());
                data.put("name", user.getName());

                result.put("code", 1);
                result.put("msg", "OK");
            } else {
                result.put("msg", "pwd_wrong");
            }
        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("info")
    public HashMap<String, Object> getUserInfo(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            int userId = Integer.parseInt(httpSession.getAttribute("id").toString());
            User user = userService.findUserById(userId);

            user.setPassword("");
            result.put("data", user);
            result.put("code", 1);
            result.put("msg", "OK");
        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
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
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
