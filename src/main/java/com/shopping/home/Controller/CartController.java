package com.shopping.home.Controller;

import com.shopping.home.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/")
    public String main(HttpServletResponse response){

        Cookie c = new Cookie("cart", "물품1=3/물품2=4");
        c.setMaxAge(-1);

        response.addCookie(c);

        return "main";
    }

    @GetMapping("/cart")
    public String cart(@CookieValue(value="cart", required = false) String cart, Model model){

        if(cart!=null) {
            model.addAttribute("true", true);
            model.addAttribute("cart", cartService.show(cart));
        }

        return "cart";
    }

}
