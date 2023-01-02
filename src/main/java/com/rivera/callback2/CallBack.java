package com.rivera.callback2;

public interface CallBack {
    void pushData(String data);
	
	void pushComplete();

	void pushError(Exception ex);
}
