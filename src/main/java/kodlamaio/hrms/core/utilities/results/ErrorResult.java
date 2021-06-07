package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult(boolean success, String message) {
		super(false, message);   //default isSuccess false.
	}
	
	public ErrorResult(String message) {
		super(false,message);
	}
	
}
