package cn.nascent.controller;

import cn.nascent.pojo.LogInfo;
import cn.nascent.service.ESSearchService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 *
 * ES搜索Controller类
 * @author ZhanWenze
 * @date 2018/12/20 11:27
 */
@Controller
@RequestMapping("/esearch")
public class ESSearchController {
    @Autowired
    private ESSearchService esSearchService;

    @Autowired
    private TransportClient client;


    @ResponseBody
    @RequestMapping("/test")
    public String queryLogByProjectName() {
        System.out.println(client);
        return "test";
    }
    /**
     * 根据项目名查询日志信息
     */
    @ResponseBody
    @RequestMapping("/findLogByProjectName")
    public List<LogInfo> queryLogByProjectName(@RequestParam String projectName) {
        List<LogInfo> logInfos = null;
        try {
            logInfos = esSearchService.queryLogByProjectName(projectName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logInfos;
    }

    /**
     * 根据日志等级查询日志信息
     */
    @ResponseBody
    @RequestMapping("/findLogByLogLevel")
    public List<LogInfo> queryLogByLogLevel(@RequestParam String logLevel) {
        List<LogInfo> logInfos = null;
        try {
            logInfos = esSearchService.queryLogByLogLevel(logLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logInfos;
    }

    /**
     * 根据日志等级查询日志信息
     */
    @ResponseBody
    @RequestMapping("/findLogByMethodPath")
    public List<LogInfo> queryLogByMethodPath(@RequestParam String methodPath) {
        List<LogInfo> logInfos = null;
        try {
            logInfos = esSearchService.queryLogByMethodPath(methodPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logInfos;
    }

    /**
     * 根据日志消息查询日志信息
     */
    @ResponseBody
    @RequestMapping("/findLogByMessage")
    public List<LogInfo> queryLogByMessage(@RequestParam String message) {
        List<LogInfo> logInfos = null;
        try {
            logInfos = esSearchService.queryLogByMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logInfos;
    }
    /**
     * 根据时间范围查询日志信息
     */
    @ResponseBody
    @RequestMapping("/findLogByDateRange")
    public List<LogInfo> queryLogByDateRange(@RequestParam String startTime, @RequestParam String endTime) {
        List<LogInfo> logInfos = null;
        try {
            logInfos = esSearchService.queryLogByDateRange(startTime, endTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logInfos;
    }
}
