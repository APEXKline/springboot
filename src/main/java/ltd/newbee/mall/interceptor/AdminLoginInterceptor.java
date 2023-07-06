package ltd.newbee.mall.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台系统身份验证拦截器
 *
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
/**
 获取当前请求的URI路径，通过 getRequestURI() 方法获取。
判断如果 URI 以 "/admin" 开头且当前会话中的 "loginUser" 属性为 null，表示用户未登录。
如果用户未登录，则将错误提示信息 "请登录" 存储到会话的 "errorMsg" 属性中。
使用 sendRedirect() 方法将请求重定向到登录页面（在 "/admin/login" 路径下）。
返回 false，表示拦截器拦截了请求，并且请求处理流程到此结束。
如果用户已登录或请求路径不是以 "/admin" 开头，则从会话中移除 "errorMsg" 属性。
返回 true，表示拦截器放行了请求，请求将继续进行处理
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if (uri.startsWith("/admin") && null == request.getSession().getAttribute("loginUser")) {
            request.getSession().setAttribute("errorMsg", "请登陆");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
