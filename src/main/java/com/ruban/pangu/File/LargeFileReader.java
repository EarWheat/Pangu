package com.ruban.pangu.File;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-09 17:05
 * @desc 超大文件多线程读取类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class LargeFileReader {
    private int threadNum = 1;  // 默认单线程
    private String filePath;
//    private DataProcessHandler dataProcessHandler;
    private ExecutorService executorService;

    public LargeFileReader(String filePath, int threadNum){
        this.filePath = filePath;
        this.threadNum = threadNum;
    }

    public Object startRead(){
        FileChannel fileChannel = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"r");
            fileChannel = randomAccessFile.getChannel();
            long fileSize = fileChannel.size();
            long subSize = fileSize / threadNum;
            for(int i = 0; i < threadNum; i++){

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
