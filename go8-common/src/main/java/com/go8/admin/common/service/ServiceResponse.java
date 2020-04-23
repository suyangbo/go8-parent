package com.go8.admin.common.service;
/**
 * service response
 * @author cjl
 * @param <T>
 */
public class ServiceResponse<T> {
	private ServiceStatus status;
	
	private T data;
	
	public ServiceResponse() {}
	
	public ServiceResponse(ServiceStatus status,T data) {
		this.status = status;
		this.data = data;
	}
	
	public ServiceResponse(ServiceStatus status) {
		this.status = status;
		this.data = null;
	}
	
	public static <T> ServiceResponse<T> ok(){
		return new ServiceResponse<T>(ServiceStatus.OK,null);
	}
	
	public static <T> ServiceResponse<T> ok(T data){
		return new ServiceResponse<T>(ServiceStatus.OK,data);
	}
	
	public static <T> ServiceResponse<T> illegalArgs(){
		return new ServiceResponse<T>(ServiceStatus.ILLEGAL_ARGS,null);
	}
	
	public static <T> ServiceResponse<T> error(){
		return new ServiceResponse<T>(ServiceStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	public static <T> ServiceResponse<T> info(T message){
		return new ServiceResponse<T>(ServiceStatus.INFO,message);
	}
	
	public ServiceStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
