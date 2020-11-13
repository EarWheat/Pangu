package com.ruban.pangu.File;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-13 17:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class CharCount extends DataProcess {
    public Long charCount;

    public CharCount(){
        this.charCount = 0L;
    }

    @Override
    public Long process(byte[] bytes) {
        String temp = new String(bytes);
        for(int i = 0; i < temp.length();i++){
            if(temp.charAt(i) != ' ' && temp.charAt(i) != '\n'){
                charCount++;
            }
        }
        return charCount;
    }

    @Override
    public Long length() {
        return charCount;
    }
}
