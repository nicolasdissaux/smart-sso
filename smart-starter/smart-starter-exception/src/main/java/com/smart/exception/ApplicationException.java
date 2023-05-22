package com.smart.exception;

import com.smart.core.entity.Message;

public class ApplicationException extends CommonException {

    public ApplicationException(String code) {
        super(code, Message.get(code));
    }

    public ApplicationException(String code, Object... args) {
        super(code, Message.get(code, args));
    }

    public ApplicationException(String code, Throwable cause) {
        super(code, cause, Message.get(code));
    }

    public ApplicationException(String code, Throwable cause, Object... args) {
        super(code, cause, Message.get(code, args));
    }
}