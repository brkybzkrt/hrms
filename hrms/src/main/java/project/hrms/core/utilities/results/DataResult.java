package project.hrms.core.utilities.results;

public class DataResult<T> extends Result {


	private T data;
	
	public DataResult(boolean success,T type) {
		super(success);
		this.data=type;
		
	}
	
	public DataResult(boolean success,T data, String message) {
		super(success, message);
		this.data=data;
		
	}
	
	public DataResult(boolean success) {
		super(success);
		
		
	}
	
	public T getData() {
		
		return this.data;
	}
}
