package com.go8.admin.common.service.help;

public class ServiceResponseDeserializer<T> {

    private ServiceStatusDeserializer status;

    private T data;

    public ServiceStatusDeserializer getStatus() {
        return status;
    }

    public void setStatus(ServiceStatusDeserializer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
