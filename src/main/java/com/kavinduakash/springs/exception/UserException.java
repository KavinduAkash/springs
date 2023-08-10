package com.kavinduakash.springs.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserException extends RuntimeException {
    private int status;
    private String msg;

    public UserException(int status, String msg) {
        super(msg);
        this.status = status;
        this.msg = msg;
    }
}
