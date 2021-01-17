package com.shopping.home.Controller;

import com.shopping.home.AOP.Visitor.TotalVisit;
import com.shopping.home.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin")
    public String index(HttpServletResponse response, Model model){

        List<Integer> list = TotalVisit.getVisitors();

        model.addAttribute("array", list);

        model.addAttribute("count",userService.count());

        return "adminPage";
    }

    @GetMapping("/admin/user")
    public String adminPage(){
        return "change";
    }
}
