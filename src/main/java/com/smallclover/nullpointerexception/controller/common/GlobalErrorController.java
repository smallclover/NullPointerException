package com.smallclover.nullpointerexception.controller.common;

import com.smallclover.nullpointerexception.constant.ResponseStatusCode;
import com.smallclover.nullpointerexception.api.rep.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Amadeus
 * @date 2019-12-12
 * 全局错误处理
 */
@RestController
@RequestMapping("/error")
public class GlobalErrorController implements ErrorController {

    //错误页面路径
    @Override
    public String getErrorPath() {
        return "/common/error";
    }

    @RequestMapping
    public ApiResponse handleErrorForJson(HttpServletRequest request){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode >= 500){
            return ApiResponse.fail(ResponseStatusCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseStatusCode.INTERNAL_SERVER_ERROR.getDesc());
        }else if (statusCode == 404){
            return ApiResponse.fail(ResponseStatusCode.NOT_FOUND.getCode(),
                    ResponseStatusCode.NOT_FOUND.getDesc());
        }else if(statusCode == 400){
            return ApiResponse.fail(ResponseStatusCode.FAILURE.getCode(),
                    ResponseStatusCode.FAILURE.getDesc());
        }else {
            return ApiResponse.fail(ResponseStatusCode.OTHERS.getCode(),
                    ResponseStatusCode.OTHERS.getDesc());
        }
    }
}
