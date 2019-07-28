package com.promod.rest.webservices.restfulwebservices.exception;

import com.promod.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizedResponseentityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {


        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){


        ExceptionResponse exceptionResponce = new ExceptionResponse( new Date(), ex.getMessage(), webRequest.getDescription(false));


        return new ResponseEntity( exceptionResponce, HttpStatus.NOT_FOUND);

    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

  //      ExceptionResponse exceptionResponce = new ExceptionResponse( new Date(), ex.getMessage(), ex.getBindingResult().toString() );

             ExceptionResponse exceptionResponce = new ExceptionResponse( new Date(), "Validation faild ", ex.getBindingResult().toString() );


        return new ResponseEntity( exceptionResponce, HttpStatus.BAD_REQUEST);

    }



    }
