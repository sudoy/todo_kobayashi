package todo.forms;

public class UpdateForm {

	private String number;
	private String title;
	private String detail;
	private String priority;
	private String deadline;

	public UpdateForm(String number, String title, String detail, String priority, String deadline) {

		super();

		this.number = number;
		this.title = title;
		this.detail = detail;
		this.priority = priority;
		this.deadline = deadline;

	}

	public String getNumber() {
		return number;
	}

	public void setNUmber(String number) {
		this.number = number;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}
