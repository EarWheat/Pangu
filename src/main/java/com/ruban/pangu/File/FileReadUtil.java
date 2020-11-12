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

    public Object fileRead(DataProcess<T> dataProcess){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] content = new byte[1024];
            while (fileInputStream.read(content) != -1){
                System.out.println("=======" + Arrays.toString(content));
//                dataProcess.process(content);
            }
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(FileReadUtil.class.getResource("/").getPath());
        String filePath = "/Users/didi/IdeaProjects/pangu/src/main/java/com/ruban/pangu/File/WordCountText";
        DataProcess dataProcess = new WordCount();
        FileReadUtil fileReadUtil = new FileReadUtil(filePath);
        fileReadUtil.fileRead(dataProcess);
    }
}
