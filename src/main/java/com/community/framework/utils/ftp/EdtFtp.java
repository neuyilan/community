package com.community.framework.utils.ftp;

import com.enterprisedt.net.ftp.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: pengpeng
 * Date: 12-7-25
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
public class EdtFtp implements Ftpable {
    public final FTPConnectMode ACTIVE = FTPConnectMode.ACTIVE;
    public final FTPConnectMode PASV = FTPConnectMode.PASV;
    private String ip;                      //ftp url地址
    private String port = "21";            //ftp 端口号
    private String username;               //用户名
    private String password;               //密码

    private String remotepath;            //远程路径
    private String localpath;             //本地路径

    private String remotefilename;              //远程文件名

    private String localfilename;             //本地文件路径+文件名

    private FileTransferClient client = null;

    private String properties;

    public void setProperties(String properties) throws IOException {
        this.properties = properties;
        if(this.properties != null && !"".equals(properties)) {
            Properties config = parseProperties(properties);
            this.ip = config.getProperty("ip");
            this.port = config.getProperty("port");
            this.username = config.getProperty("username");
            this.password = config.getProperty("password");
            this.remotepath = config.getProperty("remotepath");
            this.localpath = config.getProperty("localpath");
            this.remotefilename = config.getProperty("remotefilename");
            this.localfilename = config.getProperty("localfilename");
        }
    }

    private Properties parseProperties(String properties) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream(properties);
        Properties pro = new Properties();
        pro.load(in);
        return pro;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemotepath() {
        return remotepath;
    }

    public void setRemotepath(String remotepath) {
        this.remotepath = remotepath;
    }

    public String getLocalpath() {
        return localpath;
    }

    public void setLocalpath(String localpath) {
        this.localpath = localpath;
    }

    public String getRemotefilename() {
        return remotefilename;
    }

    public void setRemotefilename(String remotefilename) {
        this.remotefilename = remotefilename;
    }

    public String getLocalfilename() {
        return localfilename;
    }

    public void setLocalfilename(String localfilename) {
        this.localfilename = localfilename;
    }

    public void connect() throws FTPException, IOException {
        client = new FileTransferClient();

        client.setUserName(this.username);
        client.setPassword(this.password);
        client.setRemoteHost(this.ip);
        client.setRemotePort(Integer.valueOf(this.port));
        client.setTimeout(1200);

        client.setEventListener(new UploadListener(client));
        client.getAdvancedSettings().setTransferBufferSize(1000);
        client.getAdvancedSettings().setTransferNotifyInterval(5000);
        client.getAdvancedSettings().setControlEncoding("GBK");
        client.connect();

        String remotePath = this.remotepath;
        if("".equals(remotePath) || null == remotePath) {
            remotePath = "/";
        }
        client.changeDirectory(remotePath);
    }

    public void connect(FTPConnectMode mode) throws FTPException, IOException {
        client = new FileTransferClient();

        client.setUserName(this.username);
        client.setPassword(this.password);
        client.setRemoteHost(this.ip);
        client.setRemotePort(Integer.valueOf(this.port));
        client.setTimeout(10000);

        client.setEventListener(new UploadListener(client));
        client.getAdvancedSettings().setTransferBufferSize(1000);
        client.getAdvancedSettings().setTransferNotifyInterval(5000);
        client.getAdvancedSettings().setControlEncoding("GBK");
        client.getAdvancedFTPSettings().setConnectMode(mode);

        client.connect();

        String remotePath = this.remotepath;
        if("".equals(remotePath) || null == remotePath) {
            remotePath = "/";
        }

        client.changeDirectory(remotePath);
    }

    public void close() throws IOException, FTPException {
        client.disconnect();
    }

    public void upLoad() throws IOException, FTPException {
        client.uploadFile(this.localpath + this.localfilename, this.remotefilename, WriteMode.RESUME);
        long len = client.getSize(this.remotefilename);
        System.out.println("上传文件" + this.localpath + this.localfilename + "完成，大小为" + len + "字节！");
    }

    public void downLoad() throws IOException, FTPException {
        client.downloadFile(this.localpath + this.localfilename, this.remotefilename, WriteMode.OVERWRITE);
    }

    public boolean isConnected() {
        return client.isConnected();
    }

    /**
     * 取得文件夹下的文件名
     * @return
     * @throws com.enterprisedt.net.ftp.FTPException
     * @throws java.io.IOException
     */
    public String[] getDirectoryNameList() throws FTPException, IOException {
        return client.directoryNameList();
    }

    /**
     * 取得文件夹下的ftp文件对象
     * @return
     * @throws java.text.ParseException
     * @throws com.enterprisedt.net.ftp.FTPException
     * @throws java.io.IOException
     */
    public FTPFile[] getFTPFiles() throws ParseException, FTPException, IOException {
        return client.directoryList();
    }

    public FileTransferClient getFtpCliet() {
        return this.client;
    }
}
