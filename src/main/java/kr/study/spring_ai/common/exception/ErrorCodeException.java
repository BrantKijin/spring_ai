package kr.study.spring_ai.common.exception;


import kr.study.spring_ai.common.enumeration.Result;
import lombok.Getter;

@Getter
public class ErrorCodeException extends Exception{
    private Result result;
    private String code;
    public ErrorCodeException(Result result, String message, String code) {
        super(message);
        this.result = result;
        this.code = code;
    }

    public ErrorCodeException(Result result) {
        super(result.message);
        this.result = result;
    }
}
