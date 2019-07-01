package chatting;

public class chatDTO {

	private String send_id;
	private String receive_id;
	private String message;
	private String senddate;
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getReceive_id() {
		return receive_id;
	}
	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
