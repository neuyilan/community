package com.community.ws.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class RampartPasswordCB implements CallbackHandler {
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
			String id = pwcb.getIdentifier();
			System.out.println("id====" + id);
			if ("QnhClient".equals(id)) {
				pwcb.setPassword("111111");
			} else if ("QnhServer".equals(id)) {
				pwcb.setPassword("22222");
			} else {
				System.out.println("Your are not a authorized user");
				throw new UnsupportedCallbackException(callbacks[i],
						"Your are not a authorized user");
			}
		}
	}
}