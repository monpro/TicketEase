package com.monpro.ticket.common.handler;

import com.monpro.ticket.common.resp.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

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
