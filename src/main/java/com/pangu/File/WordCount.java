package com.pangu.File;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-10 20:10
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class WordCount extends DataProcess {


    public Long wordCount;

    public WordCount(){
        this.wordCount = 0L;
    }

    @Override
    public Long process(byte[] bytes) {
        String temp = new String(bytes);
        temp.replaceAll("\n"," ");
        String[] words = temp.split(" ");
        if(words.length > 1){
            wordCount += words.length;
        }
        return wordCount;
    }

    @Override
    public Long length() {
        return wordCount + 1;
    }
}
