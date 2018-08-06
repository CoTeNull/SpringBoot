package cn.cote.handler;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//设置为处理全局异常
@ControllerAdvice
public class GlobeHandler {
//  //  shiro无权限的异常
//    @ExceptionHandler(value = UnauthorizedException.class)
//    @ResponseBody
//    public String login(Exception e){
//        return "no permission";
//    }
//

//定义处理异常的类型
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
      e.printStackTrace();
      if(isAjax(request))
        return "thisAjAX";
      else
          return "webRequest";
    }
//判断是否是ajax请求的方法
    private boolean isAjax(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            return true;
        }else{
           return false;
        }
    }
}
