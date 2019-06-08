package moe.perci.hackday.controller;

import moe.perci.hackday.model.Task;
import moe.perci.hackday.model.User;
import moe.perci.hackday.model.service.TaskService;
import moe.perci.hackday.model.service.UserService;
import org.hibernate.type.BigDecimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("task")
    public HashMap<String, Object> getTask(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            Task task = taskService.findTaskById(Integer.parseInt(request.getParameter("id")));
            HashMap<String, Object> data= new HashMap<>();
            data.put("description", task.getDescription());
            data.put("province", task.getUser().getProvince());
            data.put("city", task.getUser().getCity());
            data.put("county", task.getUser().getCounty());
            data.put("peopleNeed", task.getPeopleNeed());
            data.put("phone", task.getUser().getPhone());
            data.put("ddlRegister", task.getDdlRegister());
            data.put("schoolDes", task.getUser().getDescription());

            result.put("data", data);

            result.put("code", 1);
            result.put("msg", "OK");
        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("tasks")
    public HashMap<String, Object> getTasks(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            List<Task> taskList = new ArrayList<>();
            if (request.getParameter("province") != null ) {
                taskList = taskService.findTasksByUserProvince(request.getParameter("province"));
            }

            if (request.getParameter("schoolLevel") != null ) {
                List<Task> taskList2 = new ArrayList<>();
                for (int i=0; i<taskList.size(); i++) {
                    if (taskList.get(i).getUser().getSchoolLevel().equals(request.getParameter("schoolLevel"))) {
                        taskList2.add(taskList.get(i));
                    }
                }

                taskList = taskList2;
            }

            if (request.getParameter("startTime") != null ) {
                List<Task> taskList3 = new ArrayList<>();
                BigInteger leastCreateTimeBi = new BigInteger(request.getParameter("startTime"));

                for (int i=0; i<taskList.size(); i++) {
                    BigInteger taskCreateTimeBi  = new BigInteger(taskList.get(i).getCreateTime());

                    if (taskCreateTimeBi.compareTo(leastCreateTimeBi) == 1 ) {
                        taskList3.add(taskList.get(i));
                    }
                }

                taskList = taskList3;
            }


            int page = 0;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt("page");
            }
            int pageSize = 9;
            if (request.getParameter("pageSize") != null) {
                pageSize = Integer.parseInt("pageSize");
            }

            int iBegin = pageSize*(page - 1);
            int iEnd = iBegin + pageSize;
            List<Task> taskList3 = new ArrayList<>();
            for (int i=iBegin; i<taskList.size() && i<iEnd; i++) {
                taskList3.add(taskList.get(i));
            }

            result.put("data", taskList3);
            result.put("code", 1);
            result.put("msg", "OK");

        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
