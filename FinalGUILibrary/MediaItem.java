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
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public boolean getonloan() {
		return this.onLoan;
	}
	
	public void setonloan(boolean onLoan) {
		this.onLoan = onLoan;
	}
	
	public String getLoanedTo() {
		return this.loanedTo;
	}
	
	public void setLoanedTo(String loanedTo) {
		this.loanedTo = loanedTo;
	}
	
	public String getDateLoaned() {
		return this.dateLoaned;
	}
	
	public void setDateLoaned(String dateLoaned) {
		this.dateLoaned = dateLoaned;
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
	
	public String toString() { 
		String tmpString = String.format("%s(%s)", getTitle(),getFormat());

		if (getonloan()) 
			tmpString += String.format(" loaned to %s on %s", getLoanedTo(),getDateLoaned());
		return tmpString;
	}  

	public String toFileString() {
        return title + "," + format + "," + onLoan + "," + loanedTo + "," + dateLoaned;
    }        
}