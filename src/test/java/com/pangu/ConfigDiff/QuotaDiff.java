package com.pangu.ConfigDiff;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/11 上午10:52
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class QuotaDiff {

    public static void main(String[] args) {
        int[] abandoned = new int[]{62544,64886,62530,88306,62612,62762,62558,62722,62592,62542,62550,62540,62552,62618,88658,62590,64878,62554,62556,62546,62538,62548,62622,93874,62588};
        List<Integer> abandonedId = Arrays.stream(abandoned).boxed().collect(Collectors.toList());
//        String test = "{\"completion_rate\":{\"meta_data\":{\"open\":true,\"quota_rank\":0},\"ui_data\":{\"icon_url\":\"https://img0.didiglobal.com/static/gstar/img/jv8lxE08uW1571644920756.png\",\"h5_title\":\"@string/index_menu_config||default_express||profile_quota||deal_rate_new2||h5_title\",\"url_type\":0,\"title\":\"@string/index_menu_config||default_express||profile_quota||deal_rate_new2||title\",\"tips\":\"\",\"url\":\"https://page.didiglobal.com/driver-page/rate-v2/index.html?fromChannel=1\"}},\"country_code\":\"BR\",\"county_id\":0,\"product_id\":0,\"service_core\":{\"meta_data\":{\"open\":false},\"ui_data\":{\"icon_url\":\"\",\"h5_title\":\"\",\"url_type\":0,\"title\":\"\",\"tips\":\"\",\"url\":\"\"}},\"star_core\":{\"meta_data\":{\"open\":true},\"ui_data\":{\"icon_url\":\"https://img0.didiglobal.com/static/gstar/img/4R2O3of5wF1571124607431.png\",\"h5_title\":\"@string/index_menu_config||default_express||profile_quota||comformation_rate_new||h5_title\",\"url_type\":0,\"title\":\"@string/index_menu_config||default_express||profile_quota||comformation_rate_new||title\",\"tips\":\"\",\"url\":\"https://page.didiglobal.com/driver-page/star-rate/index.html\"}},\"__experiment\":{\"experiment_group\":\"\",\"experiment_key\":\"\",\"experiment_params\":\"\"},\"acceptance_rate\":{\"meta_data\":{\"open\":true},\"ui_data\":{\"icon_url\":\"https://img0.didiglobal.com/static/gstar/img/tSDEorgm8F1571644926847.png\",\"h5_title\":\"@string/index_menu_config||default_express||profile_quota||accept_rate||h5_title\",\"url_type\":0,\"title\":\"@string/index_menu_config||default_express||profile_quota||accept_rate||title\",\"tips\":\"\",\"url\":\"https://page.didiglobal.com/driver-page/rate-v2/index.html?fromChannel=2\"}},\"category\":0,\"sync_id\":93874,\"city_id\":0}";
//        JSONObject param = JSON.parseObject(test);
//        System.out.println(getValue(param));
        try {
            List<String> apiConf = fileLoad("/Users/didi/IdeaProjects/Pangu/driver_info_components");
            List<String> themisConf = fileLoad("/Users/didi/IdeaProjects/Pangu/driver_quota_config");
            System.out.println("api conf size:"+apiConf.size());
            System.out.println("themis conf size:"+themisConf.size());
            Map<String, QuotaInfo> apiMap = new HashMap<>();
            Map<String, QuotaInfo> themisMap = new HashMap<>();
            conf2Map(apiConf,apiMap,"api");
            conf2Map(themisConf, themisMap, "themis");
            // 遍历API的配置
            for(Map.Entry<String, QuotaInfo> entry : apiMap.entrySet()){
                String key = "";
                QuotaInfo apiValue = entry.getValue();
                try {
                    key = entry.getKey();
                    // themis包含配置
                    if (themisMap.containsKey(key)) {
                        QuotaInfo themisValue = themisMap.get(key);
                        if (!apiValue.equals(themisValue)) {
                            if(!abandonedId.contains(apiValue.getId()) && !abandonedId.contains(themisValue.getId())){
                                System.out.println("key:"+ key + "--apiValue:" + JSONObject.toJSONString(apiValue) + "--themisValue:" + JSONObject.toJSONString(themisValue));
                            }
                        }
                    } else {    // themis不含有的配置
                        key = key.split("-")[0];
                        if(!themisMap.containsKey(key)){
                            // 取国家配置
                            String[] keyWord = key.split("_");
                            String newKey = keyWord[0]+"_0_0_0";
                            if(!themisMap.containsKey(newKey)){ // 没有国家配置
                                System.out.println("error! no country config! old key:"+ key + "--new key:" + newKey);
                            } else {
                                QuotaInfo themisValue = themisMap.get(newKey);
                                if (!apiValue.equals(themisValue)) {
                                    if(!abandonedId.contains(apiValue.getId()) && !abandonedId.contains(themisValue.getId())){
                                        System.out.println("key:"+ key + "--apiValue:" + JSONObject.toJSONString(apiValue) + "--themisValue:" + JSONObject.toJSONString(themisValue));
                                    }
                                }
                            }
                        } else {
                            QuotaInfo themisValue = themisMap.get(key);
                            if (!apiValue.equals(themisValue)) {
                                if(!abandonedId.contains(apiValue.getId()) && !abandonedId.contains(themisValue.getId())){
                                    System.out.println("key:"+ key + "--apiValue:" + JSONObject.toJSONString(apiValue) + "--themisValue:" + JSONObject.toJSONString(themisValue));
                                }
                            }
                        }
                    }
                } catch (Exception e){
                    System.out.println("exception key:"+ key + "--value:" + JSONObject.toJSONString(apiValue));
//                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> fileLoad(String Path){
        List<String> confList = new ArrayList<>();
        try {
            File file = new File(Path);
            FileReader fileReader;
            File[] tempList = file.listFiles();
            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile()) {
                    fileReader = new FileReader(tempList[i]);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String conf = bufferedReader.readLine();
                    confList.add(conf);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return confList;
    }

    public static void conf2Map(List<String> confList, Map<String, QuotaInfo> map, String caller){
        int i = 0;
        try {
            for (String conf : confList){
                JSONObject jsonObject = JSON.parseObject(conf);
                JSONObject toggle = JSON.parseObject(jsonObject.getString("toggle"));
                JSONObject experiment = JSON.parseObject(toggle.getString("experiment"));
                JSONArray jsonArray = JSONArray.parseArray(experiment.getString("groups"));
                JSONObject group1 = jsonArray.getJSONObject(0);
                JSONObject params = JSON.parseObject(group1.getString("params"));
                String key = getKey(params);
                QuotaInfo value = getValue(params, caller);
                if(map.containsKey(key)){
                    key += "-" + i;
                    i++;
                }
                map.put(key,value);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getKey(JSONObject params){
        String countryCode = params.getString("country_code");
        String cityId = params.getString("city_id");
        String countyId = params.getString("county_id");
        String productId = params.getString("product_id");
        return countryCode.concat("_").concat(cityId).concat("_").concat(countyId).concat("_").concat(productId);
    }

    public static QuotaInfo getValue(JSONObject params, String caller){
        try {
            AcceptanceRate acceptanceRate = new AcceptanceRate();
            JSONObject acceptance= JSON.parseObject(params.getString("acceptance_rate"));
            JSONObject metaData = JSON.parseObject(acceptance.getString("meta_data"));
            acceptanceRate.setOpen(metaData.getString("open").equals("1") ? "true" : (metaData.getString("open").equals("0") ? "false" : metaData.getString("open")));
            JSONObject uiData = JSON.parseObject(acceptance.getString("ui_data"));
            acceptanceRate.setH5Title(uiData.getString("h5_title"));
            acceptanceRate.setIconUrl(uiData.getString("icon_url"));
            acceptanceRate.setTitle(uiData.getString("title"));
            acceptanceRate.setUrl(uiData.getString("url"));
            acceptanceRate.setUrlType(uiData.getString("url_type"));


            CompletionRate completionRate = new CompletionRate();
            JSONObject completion = JSON.parseObject(params.getString("completion_rate"));
            metaData = JSON.parseObject(completion.getString("meta_data"));
            completionRate.setOpen(metaData.getString("open").equals("1") ? "true" : (metaData.getString("open").equals("0") ? "false" : metaData.getString("open")));
            uiData = JSON.parseObject(completion.getString("ui_data"));
            completionRate.setH5Title(uiData.getString("h5_title"));
            completionRate.setIconUrl(uiData.getString("icon_url"));
            completionRate.setTitle(uiData.getString("title"));
            completionRate.setUrl(uiData.getString("url"));
            completionRate.setUrlType(uiData.getString("url_type"));

            StarScore starScore = new StarScore();
            JSONObject score;
            if(caller.equals("themis")){
                 score  = JSON.parseObject(params.getString("star_core"));
            } else {
                score  = JSON.parseObject(params.getString("star_score"));
            }
            metaData = JSON.parseObject(score.getString("meta_data"));
            starScore.setOpen(metaData.getString("open").equals("1") ? "true" : (metaData.getString("open").equals("0") ? "false" : metaData.getString("open")));
            uiData = JSON.parseObject(score.getString("ui_data"));
            starScore.setH5Title(uiData.getString("h5_title"));
            starScore.setIconUrl(uiData.getString("icon_url"));
            starScore.setTitle(uiData.getString("title"));
            starScore.setUrl(uiData.getString("url"));
            starScore.setUrlType(uiData.getString("url_type"));

            QuotaInfo quotaInfo = new QuotaInfo();
            quotaInfo.setAcceptanceRate(acceptanceRate);
            quotaInfo.setCompletionRate(completionRate);
            quotaInfo.setStarScore(starScore);
            Integer syncId = params.getInteger("sync_id");
            quotaInfo.setId(syncId);
            return quotaInfo;
        } catch (Exception e){
            System.out.println("caller:" + caller + "exception value:"+params.toJSONString());
        }
        return null;
    }
}
