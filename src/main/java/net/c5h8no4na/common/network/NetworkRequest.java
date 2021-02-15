package net.c5h8no4na.common.network;

import lombok.Data;
import net.c5h8no4na.common.assertion.Assert;

@Data
public abstract class NetworkRequest<T> {
	protected T data;
	protected Integer responseCode;
	protected ErrorType errorType;

	public T getData() {
		Assert.notNull(data, "check for error first");
		return data;
	}

	public boolean responseCodeOk() {
		return responseCode >= 200 && responseCode < 300;
	}

	public abstract boolean isSuccess();

	public abstract String getErrorMessage();
}
