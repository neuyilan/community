package com.community.framework.utils.ftp;

import com.enterprisedt.net.ftp.EventAdapter;
import com.enterprisedt.net.ftp.FileTransferClient;

/**
 * Created with IntelliJ IDEA.
 * User: 彭鹏
 * Date: 12-4-18
 * Time: 上午7:56
 * To change this template use File | Settings | File Templates.
 */
public class UploadListener extends EventAdapter {
    private long bytesTransferred = 0;
    private FileTransferClient ftpClient;

    public UploadListener(FileTransferClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public void bytesTransferred(String connId, String remoteFilename, long bytes) {
        bytesTransferred = bytes;
    }

}
