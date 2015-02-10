package com.community.framework.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 串行化并行化工具类.  
 * 深度克隆对象
 * @version 1.0 
 */
public final class PickleMake {

	private PickleMake() {
	}

	/**
	 * 深度复制.
	 * 
	 * @param obj
	 *            要深度克隆的对象
	 * @return 克隆后的对象
	 */
	public static Object deepClone(Object obj) {
		if(obj == null) {
			return null;
		}
		
		// 将对象写到流里
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			// 从流里读回来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (oi.readObject());
		}catch(java.io.NotSerializableException e) {
            throw new IllegalArgumentException(e.getMessage() + " must implements 'Serializable' interface.",e);
        }
		catch(IOException e) {
			throw new IllegalArgumentException(e.getMessage(),e);
		}
		catch(ClassNotFoundException e) {
			throw new IllegalArgumentException(e.getMessage(),e);
		}
	}
	
}