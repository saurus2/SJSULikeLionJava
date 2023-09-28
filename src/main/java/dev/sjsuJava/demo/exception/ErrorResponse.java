package dev.sjsuJava.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
    }
}