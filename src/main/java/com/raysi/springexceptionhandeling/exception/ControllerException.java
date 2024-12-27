package com.raysi.springexceptionhandeling.exception;


import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControllerException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
}
