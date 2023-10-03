package com.monpro.ticket.common.handler;

import com.monpro.ticket.common.exception.BusinessException;
import com.monpro.ticket.common.resp.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    /**
     * Handler of all Business Exception thrown by controller
     * @param e Exception
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ApiResponse exceptionHandler(BusinessException e) {
        LOG.error("Business Exception occurred: {} ", e.getExceptionEnum().getDesc());
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(e.getExceptionEnum().getDesc());
        return response;
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ApiResponse exceptionHandler(BindException e) {
        LOG.error("Validation Exception occurred: ", e);
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(e.getBindingResult().getAllErrors().toString());
        return response;
    }

    /**
     * Handler of all run time exception thrown by controller
     * @param e Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse exceptionHandler(Exception e) {
        LOG.error("Exception occurred: ", e);
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(e.getMessage());
        return response;
    }
}
