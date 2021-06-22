package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult(String message) {
		super(false, message);   //default isSuccess false.
	}
	
	public ErrorResult() {
		super(false);
	}
	
}
