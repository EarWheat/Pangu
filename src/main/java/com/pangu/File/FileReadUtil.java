package com.pangu.File;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

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

    public void fileRead(DataProcess dataProcess){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] content = new byte[1024];
            while (fileInputStream.read(content) != -1){
                dataProcess.process(content);
            }
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object fileReadLine(FileProcessLine dataProcess){
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null){
                dataProcess.readLine(line);
            }
            Object result = dataProcess.process();
            System.out.println(JSONObject.toJSONString(result));
            return result;
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(FileReadUtil.class.getResource("/").getPath());
//        String filePath = "/Users/didi/IdeaProjects/pangu/src/main/java/com/ruban/pangu/File/WordCountText";
//        WordCount wordCount = new WordCount();
//        FileReadUtil fileReadUtil = new FileReadUtil(filePath);
//        fileReadUtil.fileRead(wordCount);
//        System.out.println("total Word:" + wordCount.length());
//        DataProcess charCount = new CharCount();
//        fileReadUtil.fileRead(charCount);
//        System.out.println("total Char:" + charCount.length());
    }
}
