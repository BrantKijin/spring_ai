package kr.study.spring_ai.common.exception;


import kr.study.spring_ai.common.enumeration.Result;
import lombok.Getter;

@Getter
public class ValidationException extends Exception{
    private Result result;
    public ValidationException(Result result, String message) {
        super(message);
        this.result = result;
    }

    public ValidationException(Result result) {
        super(result.message);
        this.result = result;
    }
}
