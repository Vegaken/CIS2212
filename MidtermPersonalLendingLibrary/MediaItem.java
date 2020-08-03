public class MediaItem {

	private String title;
	private String format;
	private boolean onLoan;
	private String loanedTo;
	private String dateLoaned;
	
	public MediaItem() {	
		String title = null;
		String format = null;
		boolean onloan = false;
		String loanedTo = null;
		String dateLoaned = null;
	}
	
	public MediaItem(String title, String format) {
		this.title = title;
		this.format = format;
		this.onLoan = false;
	}
		
	public String getTitle() {
		return this.title;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	public boolean getonloan() {
		return this.onLoan;
	}
	
	public String getLoanedTo() {
		return this.loanedTo;
	}
	
	public String getDateLoaned() {
		return this.dateLoaned;
	}
	
	public void markOnLoan(String name, String date) {
		if (this.onLoan == true) {
			System.out.println(this.title + " is already on loan to " + this.loanedTo + ".");
			return;
		}
		this.onLoan = true;
		this.loanedTo = name;
		this.dateLoaned = date;	
	}
	
	public void markReturned() {
		if (this.onLoan == false) {
			System.out.println(this.title + " is not currently on loan.");
			return;
		}
		this.onLoan = false;
	}
}