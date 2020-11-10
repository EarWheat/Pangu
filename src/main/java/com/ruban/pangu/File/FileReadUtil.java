package com.ruban.pangu.File;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-10 19:26
 * @desc 文件读取类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class FileReadUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileReadUtil.class);

    private String filePath;
    private File file;
    public FileReadUtil(String filePath){
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public T fileRead(DataProcess<T> dataProcess){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] read = new byte[1024];
            while (fileInputStream.read(read) != -1){
                dataProcess.process();
            }
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dataProcess.process();
    }
}
