package todo.forms;

public class EntryForm {

	private String title;
	private String detail;
	private String priority;
	private String deadline;

	public EntryForm(String title, String detail, String priority, String deadline) {

		super();

		this.title = title;
		this.detail = detail;
		this.priority = priority;
		this.deadline = deadline;

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



