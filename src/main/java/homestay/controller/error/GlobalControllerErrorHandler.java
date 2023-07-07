package homestay.controller.error;

import java.util.NoSuchElementException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalControllerErrorHandler {
	//class is a global error handler for the controller methods, handling specific exceptions and maps them to HTTP response statuses
	private enum LogStatus{
		STACK_TRACE, MESSAGE_ONLY
	}
	
	@Data
	private class ExceptionMessage{
		//class represents structure of the exception message to be returned
		private String message;
		private String statusReason;
		private int statusCode;
		private String timeStamp;
		private String uri;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionMessage handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.NOT_FOUND, webRequest, LogStatus.MESSAGE_ONLY); 
		//exception handler for NoSuchElementException = 404 NOT_FOUND
	}
	
	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleIllegalStateException(IllegalStateException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.BAD_REQUEST, webRequest, LogStatus.MESSAGE_ONLY); 
		//exception handler for IllegalStateException = 400 BAD_REQUEST
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	public ExceptionMessage handleUnsupportedOperationException(UnsupportedOperationException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.METHOD_NOT_ALLOWED, webRequest, LogStatus.MESSAGE_ONLY); 
		//exception handler for UnsupportedOperationException = 405 METHOD_NOT_ALLOWED
	}  
	
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExceptionMessage handleDuplicateKeyException(DuplicateKeyException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.CONFLICT, webRequest, LogStatus.MESSAGE_ONLY); 
		//exception handler for DuplicateKeyException = 409 CONFLICT
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionMessage handleException(Exception ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.INTERNAL_SERVER_ERROR, webRequest, LogStatus.STACK_TRACE); 
		//exception handler for handleException = 500 INTERNAL_SERVER_ERROR
	}
	
	private ExceptionMessage buildExceptionMessage(Exception ex, HttpStatus status,
			WebRequest webRequest, LogStatus logStatus) {
		//builds the ExceptionMessage object based on exception and HTTP status
		String message = ex.toString();
		String statusReason = status.getReasonPhrase(); 
		int statusCode = status.value();
		String url = null;
		String timestamp = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME); 
		
		if(webRequest instanceof ServletWebRequest swr) {
			url = swr.getRequest().getRequestURI(); 
		}
		if(logStatus == LogStatus.MESSAGE_ONLY) {
			//logs exception based on the LogStatus
			log.error("Exception: {}", ex.toString());
		}
		else {
			log.error("Exception: ", ex);
		}
		
		ExceptionMessage excMsg = new ExceptionMessage(); 
		//creates an exception message
		excMsg.setMessage(message);
		excMsg.setStatusCode(statusCode);
		excMsg.setStatusReason(statusReason);
		excMsg.setTimeStamp(timestamp); 
		excMsg.setUri(url);
		
		return excMsg; 
	}
}