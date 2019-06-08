package moe.perci.hackday.controller;

import moe.perci.hackday.model.Task;
import moe.perci.hackday.model.User;
import moe.perci.hackday.model.service.TaskService;
import moe.perci.hackday.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @PostMapping("task")
    public HashMap<String, Object> addTask(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            int userId = Integer.parseInt(httpSession.getAttribute("id").toString());
            User user = userService.findUserById(userId);

            Task task = new Task();
            task.setSchoolId(user.getId());
            BigInteger nowTime = new BigInteger(Calendar.getInstance().getTimeInMillis() + "");
            task.setCreateTime(nowTime.toString());
            task.setTitle(request.getParameter("title"));
            task.setDdlRegister(request.getParameter("ddlRegister"));
            task.setStartTime(request.getParameter("startTime"));
            // task.setType(Integer.parseInt(request.getParameter("type")));
            task.setPeopleNeed(Integer.parseInt(request.getParameter("peopleNeed")));
            task.setDescription(request.getParameter("description"));
            task.setImgUrl(request.getParameter("imgUrl"));
            task.setLastDays(Integer.parseInt(request.getParameter("lastDays")));

            taskService.save(task);

            result.put("code", 1);
            result.put("msg", "OK");

        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
