package com.qks.makerSpace.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qks.makerSpace.entity.database.*;

import java.sql.Timestamp;
import java.util.*;

public class OldParserUtils {

    /**
     * 获取某个对象
     * @param map
     * @return
     */
    public static Old parser(JSONObject map) {
        Old old = new Old();

        old.setOldId(map.getString("creditCode"));
        old.setRegisterAddress(map.getString("registerAddress"));
        old.setRegisterCapital(map.getString("registerCapital"));
        old.setRealAddress(map.getString("realAddress"));
        old.setRealCapital(map.getString("realCapital"));
        old.setLastIncome(map.getString("lastIncome"));
        old.setLastTax(map.getString("lastTax"));
        old.setEmployees(map.getString("employees"));
        old.setOriginNumber(map.getString("originNumber"));
        old.setSetDate(map.getString("setDate"));
        old.setNature(map.getString("nature"));
        old.setInvolved(map.getString("involved"));
        old.setMainBusiness(map.getString("mainBusiness"));
        old.setWay(map.getString("way"));
        old.setBusiness(map.getString("business"));
        old.setCooperation(map.getString("cooperation"));

        return old;
    }

    public static List<OldShareholder> OldShareholderParser(JSONArray obj){
        List<OldShareholder> resultList = new ArrayList<>();
        String OldShareholderId = UUID.randomUUID().toString();

        for (int i = 0; i < obj.size(); i++) {
            OldShareholder oldShareholder = new OldShareholder();

            oldShareholder.setId(UUID.randomUUID().toString());
            oldShareholder.setOldShareholderId(OldShareholderId);
            oldShareholder.setName(obj.getJSONObject(i).getString("name"));
            oldShareholder.setStake(obj.getJSONObject(i).getString("stake"));
            oldShareholder.setNature(obj.getJSONObject(i).getString("nature"));

            resultList.add(oldShareholder);
        }

        return resultList;
    }

    public static List<OldMainPerson> OldMainPersonParser(JSONArray obj) {
        List<OldMainPerson> resultList = new ArrayList<>();
        String OldMainPersonId = UUID.randomUUID().toString();

        for (int i = 0; i < obj.size(); i++) {
            OldMainPerson oldMainPerson = new OldMainPerson();

            oldMainPerson.setId(UUID.randomUUID().toString());
            oldMainPerson.setOldMainpersonId(OldMainPersonId);
            oldMainPerson.setName(obj.getJSONObject(i).getString("name"));
            oldMainPerson.setBorn(obj.getJSONObject(i).getString("born"));
            oldMainPerson.setJob(obj.getJSONObject(i).getString("job"));
            oldMainPerson.setSchool(obj.getJSONObject(i).getString("school"));
            oldMainPerson.setTitle(obj.getJSONObject(i).getString("title"));
            oldMainPerson.setBackground(obj.getJSONObject(i).getString("background"));
            oldMainPerson.setProfessional(obj.getJSONObject(i).getString("professional"));

            resultList.add(oldMainPerson);

        }

        return resultList;
    }

    public static List<OldProject> OldProjectsParser(JSONArray obj) {
        List<OldProject> resultList = new ArrayList<>();
        String OldProjectsId = UUID.randomUUID().toString();

        for (int i = 0; i < obj.size(); i++) {
            OldProject oldProject = new OldProject();

            oldProject.setId(UUID.randomUUID().toString());
            oldProject.setOldProjectId(OldProjectsId);
            oldProject.setProjectBrief(obj.getJSONObject(i).getString("projectBrief"));
            oldProject.setAdvantage(obj.getJSONObject(i).getString("advantage"));
            oldProject.setMarket(obj.getJSONObject(i).getString("market"));
            oldProject.setEnergy(obj.getJSONObject(i).getString("energy"));
            oldProject.setPollution(obj.getJSONObject(i).getString("pollution"));
            oldProject.setNoise(obj.getJSONObject(i).getString("noise"));
            oldProject.setOthers(obj.getJSONObject(i).getString("others"));

            resultList.add(oldProject);
        }

        return resultList;
    }

    public static List<OldIntellectual> OldIntellectualParser(JSONArray obj) {
        List<OldIntellectual> resultList = new ArrayList<>();
        String OldIntellectualId = UUID.randomUUID().toString();

        for (int i = 0; i < obj.size(); i++) {
            OldIntellectual oldIntellectual = new OldIntellectual();

            oldIntellectual.setId(UUID.randomUUID().toString());
            oldIntellectual.setOldIntellectualId(OldIntellectualId);
            oldIntellectual.setName(obj.getJSONObject(i).getString("name"));
            oldIntellectual.setKind(obj.getJSONObject(i).getString("kind"));
            oldIntellectual.setApplyTime(obj.getJSONObject(i).getString("applyTime"));
            oldIntellectual.setApplyTime(obj.getJSONObject(i).getString("approvalTime"));

            resultList.add(oldIntellectual);
        }

        return resultList;
    }

    public static List<OldFunding> OldFundingParser(JSONArray map) {
        List<OldFunding> resultList = new ArrayList<>();
        String OldFundingId = UUID.randomUUID().toString();

        for (int i = 0; i < map.size(); i++) {
            OldFunding oldFunding = new OldFunding();

            oldFunding.setId(UUID.randomUUID().toString());
            oldFunding.setFundingId(OldFundingId);
            oldFunding.setName(map.getJSONObject(i).getString("name"));
            oldFunding.setLevel(map.getJSONObject(i).getString("level"));
            oldFunding.setTime(map.getJSONObject(i).getString("time"));
            oldFunding.setGrants(map.getJSONObject(i).getString("grants"));
            oldFunding.setAward(map.getJSONObject(i).getString("award"));

            resultList.add(oldFunding);
        }

        return resultList;
    }

    public static Map<String, Object> OldGetResponse(Old old){
        Map<String, Object> result = new HashMap<>();

        result.put("registerAddress", old.getRegisterAddress());
        result.put("license", old.getLicense());
        result.put("registerCapital", old.getRegisterCapital());
        result.put("realAddress", old.getRealAddress());
        result.put("realCapital", old.getRealCapital());
        result.put("lastIncome", old.getLastIncome());
        result.put("lastTax", old.getLastTax());
        result.put("employees", old.getEmployees());
        result.put("originNumber", old.getOriginNumber());
        result.put("setDate", old.getSetDate());
        result.put("nature", old.getNature());
        result.put("certificate", old.getCertificate());
        result.put("involved", old.getInvolved());
        result.put("mainBusiness", old.getMainBusiness());
        result.put("way", old.getWay());
        result.put("business", old.getBusiness());

        return result;
    }
}
