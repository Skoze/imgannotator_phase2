package wnderful.imgannotator.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.publicData.reponseCode.GlobalRepCode;
import wnderful.imgannotator.publicData.response.GlobalResponse;
import wnderful.imgannotator.publicData.response.Response;
import java.io.IOException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response allExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.SERVERFAIL);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public Response usernameExceptionHandler(IOException exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.WRITEERROE);
    }

}
