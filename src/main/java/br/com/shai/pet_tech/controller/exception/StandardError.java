package br.com.shai.pet_tech.controller.exception;

import lombok.Getter;

import java.time.Instant;

@Getter
public class StandardError {

    public StandardError() {
    }

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
