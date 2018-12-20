package cn.nascent.service;


import cn.nascent.pojo.LogInfo;

import java.io.IOException;
import java.util.List;

public interface ESSearchService {
    List<LogInfo> queryLogByProjectName(String projectName) throws IOException;
    List<LogInfo> queryLogByLogLevel(String logLevel) throws IOException;
    List<LogInfo> queryLogByMethodPath(String methodPath) throws IOException;
    List<LogInfo> queryLogByMessage(String message) throws IOException;
    List<LogInfo> queryLogByDateRange(String startTime, String endTime) throws IOException;
}
