package kodlamaio.hrms.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult(boolean success, String message) {
		super(true, message);  //default isSuccess is true.
	}
	
	public SuccessResult(String message) {
		super(true,message);	
	}

}
