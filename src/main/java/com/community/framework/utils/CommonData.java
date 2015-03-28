package com.community.framework.utils;

public interface CommonData {

	public interface TimeOutData {
		/** 青年汇 ws 请求超时时间 3min */
		public final static long QHN_WS_TIMEOUT = 180 * 1000;
	}

	public interface GlobalData {
		/** DEV DEBUG 模式 */
		public final static boolean DEBUG_MODE = false;
		/**返回值 0 成功*/
		public final static int RET_SUCCESS = 0;
		/**返回值 1 失败*/
		public final static int RET_FAILURE = 1;
		/**返回值 2 审核*/
		public final static int RET_VERIFY = 2;
	}

}
