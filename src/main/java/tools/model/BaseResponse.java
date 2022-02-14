package tools.model;

public class BaseResponse {

	private Boolean status;

	private Integer code;

	private String msg;

	public BaseResponse(Boolean status, String msg) {
		this.status = status;
		this.code = 200;
		this.msg = msg;
	}

	public BaseResponse(Boolean status, Integer code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
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

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", code=" + code + ", msg=" + msg + "]";
	}

}
