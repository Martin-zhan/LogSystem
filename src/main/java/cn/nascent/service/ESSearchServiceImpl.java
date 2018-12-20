package cn.nascent.service;

import cn.nascent.pojo.LogInfo;
import cn.nascent.utils.ESSearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ESSearchServiceImpl implements ESSearchService{
    @Autowired
    private ESSearchUtil esSearchUtil;

    /**
     *  通过项目名称查询日志信息
     * @param projectName
     */
    @Override
    public List<LogInfo> queryLogByProjectName(String projectName) throws IOException {
        List<LogInfo> logInfoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        SearchHits hits = esSearchUtil.TermQuery("log-test", "lname", projectName);
        System.out.println(hits);
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            // 将json字符串转换成实体类
            logInfoList.add(mapper.readValue(hit.getSourceAsString(),LogInfo.class));
        }
        return logInfoList;
    }

    /**
     *  通过日志等级查询日志信息
     * @param logLevel
     */
    @Override
    public List<LogInfo> queryLogByLogLevel(String logLevel) throws IOException {
        List<LogInfo> logInfoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        SearchHits hits = esSearchUtil.TermQuery("log-test", "ltype", logLevel);
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            // 将json字符串转换成实体类
            logInfoList.add(mapper.readValue(hit.getSourceAsString(),LogInfo.class));
        }
        return logInfoList;
    }

    /**
     *  通过方法路径查询日志信息
     * @param methodPath
     */
    @Override
    public List<LogInfo> queryLogByMethodPath(String methodPath) throws IOException {
        List<LogInfo> logInfoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        SearchHits hits = esSearchUtil.TermQuery("log-test", "lpath", methodPath);
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            // 将json字符串转换成实体类
            logInfoList.add(mapper.readValue(hit.getSourceAsString(),LogInfo.class));
        }
        return logInfoList;
    }

    /**
     *  通过消息查询日志信息
     * @param message
     */
    @Override
    public List<LogInfo> queryLogByMessage(String message) throws IOException {
        List<LogInfo> logInfoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        SearchHits hits = esSearchUtil.TermQuery("log-test", "lmessage", message);
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            // 将json字符串转换成实体类
            logInfoList.add(mapper.readValue(hit.getSourceAsString(),LogInfo.class));
        }
        return logInfoList;
    }

    /**
     *
     * 通过时间范围查询日志
     */
    @Override
    public List<LogInfo> queryLogByDateRange(String startTime, String endTime) throws IOException {
        List<LogInfo> logInfoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        SearchHits hits = esSearchUtil.RangeQuery("log-test2", "ltimestamp", startTime,endTime);
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            // 将json字符串转换成实体类
            logInfoList.add(mapper.readValue(hit.getSourceAsString(),LogInfo.class));
        }
        return logInfoList;
    }
}
