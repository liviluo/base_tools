package tools.model;

public class DataResponse<T> {

	private Boolean status;

	private Integer code;

	private String msg;

	private T data;

	public DataResponse(Boolean status, String msg, T data) {
		this.status = status;
		this.code = 200;
		this.msg = msg;
		this.data = data;
	}

	public DataResponse(Boolean status, Integer code, String msg, T data) {
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
