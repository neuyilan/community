package com.community.framework.utils.ftp;

import com.enterprisedt.net.ftp.FTPException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pengpeng
 * Date: 12-7-25
 * Time: 下午1:24
 * To change this template use File | Settings | File Templates.
 */
public class Excecute {
    public static void main(String[] args) throws IOException, FTPException {
//        System.out.println("==========开始==========" + new Date());
//        Ftpable ftp = new EdtFtp();
//        ftp.setIp("10.230.3.139");
//        ftp.setPort("21");
//        ftp.setUsername("chuhang");
//        ftp.setPassword("123");
//        ftp.setRemotepath("/");         ///ftp/ftpgather/
//        ftp.setRemotefilename("sybiq-dmpiq1-dmpiq1-ga_cc_bdr-120731-0920.dat");
//        ftp.setLocalpath("d:/sybiq-dmpiq1-dmpiq1-ga_cc_bdr-120731-0920.dat");
//        ftp.setLocalfilename("sybiq-dmpiq1-dmpiq1-ga_cc_bdr-120731-0920.dat");
//        ftp.connect();
//        ftp.upLoad();
//        System.out.println("==============下载1 ======= " + new Date());
////        ftp.downLoad();
//        System.out.println("==============下载完成========== " + new Date());
//        ftp.close();

//            System.out.println("==========开始==========" + new Date());
//            Ftpable ftp = new BatchFtp();
//            ftp.setIp("10.230.3.139");
//            ftp.setPort("21");
//            ftp.setUsername("chuhang");
//            ftp.setPassword("123");
//            ftp.setRemotepath("/");         ///ftp/ftpgather/
//            ftp.setRemotefilename("22*.txt");
//            ftp.setLocalpath("d:/");
//            ftp.connect();
//            System.out.println("==============下载1 ======= " + new Date());
////            ftp.downLoad();
//            ftp.upLoad();
//            System.out.println("==============下载完成========== " + new Date());
//            ftp.close();


            Ftpable ftp = new EdtFtp();
            ftp.setIp("192.168.0.118");
            ftp.setPort("21");
            ftp.setUsername("pp");
            ftp.setPassword("pp");
            ftp.setRemotepath("/hpms");         ///ftp/ftpgather/
            ftp.setRemotefilename("aaaaa.txt");
            ftp.setLocalpath("D:\\ftp\\");
            ftp.setLocalfilename("a.txt");
            ftp.connect();
            ftp.upLoad();
            ftp.close();
//

//        Ftpable ftp = new PollFolderFtp();
//            ftp.setIp("10.186.50.134");
//            ftp.setPort("21");
//            ftp.setUsername("ftpuser22");
//            ftp.setPassword("ftpuser22");
//            ftp.setRemotepath("/u01/file/22/request/");         ///ftp/ftpgather/
//            ftp.setLocalpath("E:/hpms/ftp/request/");
//            ftp.connect();
//            ftp.downLoad();
//            ftp.close();

    }
}
