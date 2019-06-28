package todo.forms;

public class IndexForm {

	private String number;
	private String title;
	private String priority;
	private String deadline;

	public IndexForm(String number, String title, String priority, String deadline) {
		super();
		this.number = number;
		this.title = title;
		this.priority = priority;
		this.deadline = deadline;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
