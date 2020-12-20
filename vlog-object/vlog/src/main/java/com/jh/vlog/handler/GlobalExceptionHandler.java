package com.jh.vlog.handler;

import cn.hutool.db.sql.SqlExecutor;
import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.common.ResultCode;
import com.jh.vlog.exception.Customexception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.concurrent.Executors;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author apple
 * @Date 2020/12/19
 **/
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理，统一在这里捕获返回JSON格式的友好提示
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {Customexception.class})
    @ResponseBody
    public ResponseResult sendError(Customexception exception){
        log.error(exception.getMessage());
        return ResponseResult.failure(exception.getResultCode());
    }

    @ExceptionHandler(value = {SQLException.class})
    @ResponseBody
    public ResponseResult sendError(SQLException exception){
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.DATABASE_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public ResponseResult sendError(NullPointerException exception){
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}
