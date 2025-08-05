package kr.study.spring_ai.common.exception;


import kr.study.spring_ai.common.enumeration.Result;
import lombok.Getter;

@Getter
public class UnAuthorizeException extends RuntimeException {
    private Result result;
    public UnAuthorizeException(Result result, String message) {
        super(message);
        this.result = result;
    }

    public UnAuthorizeException(Result result) {
        super(result.message);
        this.result = result;
    }
}