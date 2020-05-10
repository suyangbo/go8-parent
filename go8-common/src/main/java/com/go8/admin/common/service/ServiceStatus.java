package com.go8.admin.common.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * service response status
 *
 * @author cjl
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceStatus {
    // 1xx Informational
    INFO(1000, "info"),

    // 2xx Success
    OK(2000, "ok"),

    // 3xx Redirection

    // --- 4xx Client Error ---
    ILLEGAL_ARGS(4000, "illegal arguments"),

    // --- 5xx Server Error ---
    INTERNAL_SERVER_ERROR(5000, "Internal Server Error");


    private final int code;
    private final String message;

    @JsonCreator
    ServiceStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return this.code;
    }

    //@JsonValue
    public String getMessage() {
        return this.message;
    }
}
