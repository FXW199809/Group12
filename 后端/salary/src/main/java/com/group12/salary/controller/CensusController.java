package com.group12.salary.controller;


import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.*;
import com.group12.salary.model.*;
import com.sun.org.apache.bcel.internal.classfile.Code;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class CensusController {
    /*@CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/censusUserViewer")
    public boolean InsertCensus(String start_time, String end_time, String pageId, String pageName, String userId, String doString) throws IOException, ParseException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        CensusDAOMapper censusDAOMapper = sqlSession.getMapper(CensusDAOMapper.class);
        CensusDAO censusDAO = new CensusDAO();
        System.out.println(start_time);
        Date start_times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp2Date(start_time));
        System.out.println(start_times);
        Date end_times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp2Date(end_time));
        censusDAO.setStartTime(start_times);
        censusDAO.setEndTime(end_times);
        censusDAO.setPageId(pageId);
        censusDAO.setPageName(pageName);
        censusDAO.setUserId(userId);
        censusDAO.setDostring(doString);
        censusDAOMapper.insert(censusDAO);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    *//*


    //获取所有数据
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getcensusList")
    public List<CensusDAO> getcensusList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        CensusDAOMapper censusDAOMapper = sqlSession.getMapper(CensusDAOMapper.class);

        CensusDAOExample censusDAOExample = new CensusDAOExample();
        CensusDAOExample.Criteria criteria = censusDAOExample.createCriteria();

        //all
        criteria.andCensusIdIsNotNull();
        List<CensusDAO> censusDAOList = censusDAOMapper.selectByExample(censusDAOExample);
        return censusDAOList;
    }

    //获取当天的页面浏览量
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getPV")
    public Long[] getPV() throws IOException {
        Long pvNum[] = new Long[15];

        SqlSession sqlSession = MapperTools.getSqlSession();
        CensusDAOMapper censusDAOMapper = sqlSession.getMapper(CensusDAOMapper.class);

        CensusDAOExample censusDAOExample = new CensusDAOExample();
        CensusDAOExample.Criteria criteria = censusDAOExample.createCriteria();
        for(int i = 0; i < 15; i++){
            criteria.andPageIdEqualTo(String.valueOf(i));
            pvNum[i] = censusDAOMapper.countByExample(censusDAOExample);
            censusDAOExample.clear();
        }
        return pvNum;
    }

    //获取UV
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getUV")
    public static int getUV() throws IOException {
        int uvNum = 0;

        SqlSession sqlSession = MapperTools.getSqlSession();
        CensusDAOMapper censusDAOMapper = sqlSession.getMapper(CensusDAOMapper.class);

        CensusDAOExample censusDAOExample = new CensusDAOExample();
        CensusDAOExample.Criteria criteria = censusDAOExample.createCriteria();

        //计算
        criteria.andUserIdIsNotNull();
        String begin = "", end = "";
        List<CensusDAO> censusDAOList = censusDAOMapper.selectByExample(censusDAOExample);
        for (int i = 0; i < censusDAOList.size(); i++){
            begin = censusDAOList.get(i).getUserId();
            if(begin != end) uvNum++;
            end = begin;
        }
        return uvNum;
    }*/

    public static String timeStamp2Date(String seconds) {
        if (Integer.parseInt(seconds) < 0){
            seconds = String.valueOf(Math.abs(Integer.parseInt(seconds)));
        }
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 输出字符串
        return df.format(new Date(new Long(seconds)));
    }

    //pushlog
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/pushlog")
    @ResponseBody
    public static boolean getdata(@RequestBody String json) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        ActionDAO actionDAO = new ActionDAO();
        CodeDAO codeDAO = new CodeDAO();
        InterfaceDAO interfaceDAO = new InterfaceDAO();
        TimeDAO timeDAO = new TimeDAO();

        ActionDAOMapper actionDAOMapper = sqlSession.getMapper(ActionDAOMapper.class);
        CodeDAOMapper codeDAOMapper = sqlSession.getMapper(CodeDAOMapper.class);
        InterfaceDAOMapper interfaceDAOMapper = sqlSession.getMapper(InterfaceDAOMapper.class);
        TimeDAOMapper timeDAOMapper = sqlSession.getMapper(TimeDAOMapper.class);

        JSONObject jsonObject = JSONObject.fromObject(json);

        String uuid = jsonObject.getString("uuid");
        String type;

        JSONArray jsonArray = jsonObject.getJSONArray("acData");
        System.out.println(jsonArray.size());
        for(int index = 0; index < jsonArray.size(); index++){
            jsonObject = JSONObject.fromObject(jsonArray.get(index));
            type = jsonObject.getString("type");
            switch(type){
                case "ACINPUT":
                case "ACPAGE":
                case "ACCLIK":
                    actionDAO.setUuid(uuid);
                    actionDAO.setType(jsonObject.getString("type"));
                    actionDAO.setPath(jsonObject.getString("path"));
                    if(jsonObject.has("eId"))
                        actionDAO.setEid(jsonObject.getString("eId"));
                    if (jsonObject.has("className"))
                        actionDAO.setClassname(jsonObject.getString("className"));
                    if (jsonObject.has("sTme"))
                        actionDAO.setEtme(jsonObject.getString("sTme"));
                    if(jsonObject.has("eTme"))
                        actionDAO.setEtme(jsonObject.getString("eTme"));
                    if(jsonObject.has("val"))
                        actionDAO.setVal(jsonObject.getString("val"));
                    actionDAOMapper.insert(actionDAO);
                    sqlSession.commit();
                        continue;
                case "ACRERR":
                    interfaceDAO.setType("ACRERR");
                    interfaceDAO.setPath(jsonObject.getString("path"));
                    if (jsonObject.has("sIme"))
                        interfaceDAO.setStme(jsonObject.getString("sTme"));
                    if(jsonObject.has("requrl"))
                        interfaceDAO.setRequrl(jsonObject.getString("requrl"));
                    if(jsonObject.has("readyState"))
                        interfaceDAO.setReadystate(jsonObject.getString("readyState"));
                    if(jsonObject.has("status"))
                        interfaceDAO.setStatus(jsonObject.getString("status"));
                    if(jsonObject.has("statusText"))
                        interfaceDAO.setStatustext(jsonObject.getString("statusText"));
                    if(jsonObject.has("textStatus"))
                        interfaceDAO.setTextstatus(jsonObject.getString("textStatus"));
                    interfaceDAOMapper.insert(interfaceDAO);
                    sqlSession.commit();
                    continue;
                case "ACCERR":
                    codeDAO.setType("ACCERR");
                    codeDAO.setPath(jsonObject.getString("path"));
                    if(jsonObject.has("sTme"))
                        codeDAO.setStme(jsonObject.getString("sTme"));
                    if(jsonObject.has("msg"))
                        codeDAO.setMsg(jsonObject.getString("msg"));
                    if(jsonObject.has("line"))
                        codeDAO.setLine(jsonObject.getString("line"));
                    if(jsonObject.has("col"))
                        codeDAO.setCol(jsonObject.getString("col"));
                    if(jsonObject.has("err"))
                        codeDAO.setErr(jsonObject.getString("err"));
                    if(jsonObject.has("ua"))
                        codeDAO.setUa(jsonObject.getString("ua"));
                    codeDAOMapper.insert(codeDAO);
                    sqlSession.commit();
                    continue;
                case "ACTIME":
                    timeDAO.setType("ACTIME");
                    timeDAO.setPath(jsonObject.getString("path"));
                    if(jsonObject.has("DNS"))
                        timeDAO.setDns(jsonObject.getString("DNS"));
                    if(jsonObject.has("TCP"))
                        timeDAO.setTcp(jsonObject.getString("TCP"));
                    if(jsonObject.has("WT"))
                        timeDAO.setWt(jsonObject.getString("WT"));
                    if(jsonObject.has("DR"))
                        timeDAO.setDr(jsonObject.getString("DR"));
                    if(jsonObject.has("ONL"))
                        timeDAO.setOnl(jsonObject.getString("ONL"));
                    if(jsonObject.has("ALLRT"))
                        timeDAO.setAllrt(jsonObject.getString("ALLRT"));
                    if(jsonObject.has("PRDOM"))
                        timeDAO.setPrdom(jsonObject.getString("PRDOM"));
                    if(jsonObject.has("FXHR"))
                        timeDAO.setFxhr(jsonObject.getString("FXHR"));
                    timeDAOMapper.insert(timeDAO);
                    sqlSession.commit();
                    continue;
                default:
                    continue;

            }
        }
        sqlSession.close();
        System.out.println(json);
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getcensusList")
    @ResponseBody
    public List<ActionDAO> getcensusList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ActionDAO actionDAO = new ActionDAO();
        ActionDAOExample actionDAOExample = new ActionDAOExample();
        ActionDAOExample.Criteria criteria = actionDAOExample.createCriteria();
        criteria.andIdIsNotNull();
        ActionDAOMapper actionDAOMapper = sqlSession.getMapper(ActionDAOMapper.class);

        List<ActionDAO> actionDAOList = actionDAOMapper.selectByExample(actionDAOExample);
        return actionDAOList;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getPage")
    @ResponseBody
    public int getPage() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ActionDAO actionDAO = new ActionDAO();
        ActionDAOExample actionDAOExample = new ActionDAOExample();
        ActionDAOExample.Criteria criteria = actionDAOExample.createCriteria();
        ActionDAOMapper actionDAOMapper = sqlSession.getMapper(ActionDAOMapper.class);

        criteria.andTypeEqualTo("ACPAGE");
        int count = (int) actionDAOMapper.countByExample(actionDAOExample);

        return count;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/CodeError")
    @ResponseBody
    public int CodeError() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        CodeDAO codeDAO = new CodeDAO();
        CodeDAOExample codeDAOExample = new CodeDAOExample();
        CodeDAOExample.Criteria criteria = codeDAOExample.createCriteria();
        CodeDAOMapper codeDAOMapper = sqlSession.getMapper(CodeDAOMapper.class);

        criteria.andIdIsNotNull();
        int count = (int) codeDAOMapper.countByExample(codeDAOExample);
        return count;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/DianJi")
    @ResponseBody
    public int DianJi() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ActionDAO actionDAO = new ActionDAO();
        ActionDAOExample actionDAOExample = new ActionDAOExample();
        ActionDAOExample.Criteria criteria = actionDAOExample.createCriteria();
        ActionDAOMapper actionDAOMapper = sqlSession.getMapper(ActionDAOMapper.class);

        criteria.andTypeEqualTo("ACCLIK");
        int count = (int) actionDAOMapper.countByExample(actionDAOExample);
        return count;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/PageError")
    @ResponseBody
    public int PageError() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        InterfaceDAO interfaceDAO = new InterfaceDAO();
        InterfaceDAOExample interfaceDAOExample = new InterfaceDAOExample();
        InterfaceDAOExample.Criteria criteria = interfaceDAOExample.createCriteria();
        InterfaceDAOMapper interfaceDAOMapper = sqlSession.getMapper(InterfaceDAOMapper.class);

        criteria.andIdIsNotNull();
        int count = (int) interfaceDAOMapper.countByExample(interfaceDAOExample);

        return count;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/InputData")
    @ResponseBody
    public int InputData() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ActionDAO actionDAO = new ActionDAO();
        ActionDAOExample actionDAOExample = new ActionDAOExample();
        ActionDAOExample.Criteria criteria = actionDAOExample.createCriteria();
        ActionDAOMapper actionDAOMapper = sqlSession.getMapper(ActionDAOMapper.class);

        criteria.andTypeEqualTo("ACINPUT");
        int count = (int) actionDAOMapper.countByExample(actionDAOExample);
        return count;
    }


}
