package kr.study.spring_ai.common.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Result {
    SUCCESS(100, "성공")
    ,FAIL(000, "실패")
    ,PARAMETER_ERROR(201, "파라미터 오류")
    ,UNAUTHORIZED(400, "권한이 없습니다.")
    ,COMMON_ERROR(999, "에러가 발생했습니다. 잠시 후 다시 시도해주세요.")
    ;

    public final int code;
    public final String message;

    private Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<Integer, Result> typesByValue = new HashMap<>(Result.values().length);

    static {
        for (Result type : Result.values()) {
            if (typesByValue.containsKey(type.code) || typesByValue.containsKey(-type.code)) {
                Result result = typesByValue.get(type.code);
                System.exit(type.code);
            }
            typesByValue.put(type.code, type);
        }
    }

    public static Result forValue(Integer value) {
        Result res = typesByValue.get(value);
        if (res == null) {
            res = Result.FAIL;
        }
        return res;
    }

    public static Map<Integer, Result> getTypeByValue(){
        return typesByValue;
    }
}