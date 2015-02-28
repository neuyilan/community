package com.community.framework.utils.ftp;

import java.io.IOException;
import java.text.ParseException;

import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPFile;
import com.enterprisedt.net.ftp.FileTransferClient;

/**
 * Created with IntelliJ IDEA.
 * User: pengpeng
 * Date: 12-7-25
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 * ftp连接接口
 */
public interface Ftpable {
    //ftp的IP
    public String getIp();

    public void setIp(String ip);
    //ftp的端口
    public String getPort();

    public void setPort(String port);
    //ftp用户名
    public String getUsername();

    public void setUsername(String username);
    //ftp密码
    public String getPassword();

    public void setPassword(String password);
    //服务端路径
    public String getRemotepath();

    public void setRemotepath(String remotepath);
    //本地路径
    public String getLocalpath();

    public void setLocalpath(String localpath);
    //服务端文件名
    public String getRemotefilename();

    public void setRemotefilename(String remotefilename);
    //本地文件名
    public String getLocalfilename();

    public void setLocalfilename(String localfilename);

    public void setProperties(String properties) throws IOException;
    //连接
    public void connect() throws FTPException, IOException;

    public void connect(FTPConnectMode mode) throws FTPException, IOException;
    //关闭
    public void close() throws IOException, FTPException;
    //上传
    public void upLoad() throws IOException, FTPException;
    //下载
    public void downLoad() throws IOException, FTPException;
    //是否连接成功
    public boolean isConnected();
    //取得文件夹下的文件名
    public String[] getDirectoryNameList() throws FTPException, IOException;
    //取得文件夹下的ftp文件对象
    public FTPFile[] getFTPFiles() throws ParseException, FTPException, IOException;

    public FileTransferClient getFtpCliet();
}
