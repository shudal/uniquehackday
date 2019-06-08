package moe.perci.hackday.controller;

import moe.perci.hackday.config.CodeConfig;
import moe.perci.hackday.model.Good;
import moe.perci.hackday.model.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("good")
public class GoodController {
    @Autowired
    GoodService goodService;

    @GetMapping("goods")
    public HashMap<String, Object> t(HttpServletRequest request, HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", "");
        result.put("data", "");

        try {
            int type = Integer.parseInt(request.getParameter("type"));
            List<Good> goods = goodService.findGoodsByTypeAndStatus(type, CodeConfig.STATUS_GOOD_PENDING);

            result.put("data", goods);
            result.put("code",1);
            result.put("msg", "OK");
        } catch (Exception e) {
            result.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
