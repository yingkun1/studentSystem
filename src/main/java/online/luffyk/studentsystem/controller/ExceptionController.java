package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;


@ControllerAdvice
public class ExceptionController {
    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public Object handlerException(Exception e){
        logger.debug("捕获到了参数校验异常");
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        logger.debug(constraintViolations.toString());
        for(ConstraintViolation<?> value:constraintViolations){
            logger.debug(value.getMessage());
        }
        e.getStackTrace();
        return new Result(400,constraintViolations.toString(),"错误的请求参数");
    }
}
