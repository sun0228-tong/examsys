package com.qfedu.examsys.filter;

import com.qfedu.examsys.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "TokenFilter",urlPatterns = "/api/*")
public class TokenFilter implements Filter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String uri = request.getRequestURI();
        String method = request.getMethod();

        // 修改请求头中数据后，会先发送提交类型是options的请求
        if(method.equals("OPTIONS")){
            return;
        }

        if (uri.contains("login")) {
            chain.doFilter(req,resp);
        } else {
            String token = request.getHeader("token");
            if(token != null) {
                String name = redisTemplate.opsForValue().get(token);
                String token2 = MD5Utils.md5(name + "examsys");

                if (token != null && token.equals(token2)) {
                    // 合法用户
                    chain.doFilter(req,resp);
                } else {
                    String head = request.getHeader("x-requested-with");
                    // 判断是否ajax请求
                    if (head != null && head.equals("XMLHttpRequest")) {
                        response.getWriter().write("{\"info\":\"未登录\"}");
                        return;
                    } else {
                        // 跳转到登陆页面
                        response.sendRedirect("http://127.0.0.1:8020/forward/login.html");
                        return;
                    }
                }
            } else {
                String head = request.getHeader("x-requested-with");
                // 判断是否ajax请求
                if (head != null && head.equals("XMLHttpRequest")) {
                    resp.getWriter().write("{\"info\":\"未登录\"}");
                    return;
                } else {
                    // 跳转到登陆页面
                    response.sendRedirect("http://127.0.0.1:8020/forward/login.html");
                    return;
                }
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
