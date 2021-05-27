package project.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data) {
		super(false, data);
		// TODO Auto-generated constructor stub
	}

	
	public ErrorDataResult(T data,String message) {
		super(false, data,message);
		// TODO Auto-generated constructor stub
	}
	
	public  ErrorDataResult() {
		super(false);
		
	}
}