package cn.nascent;

import cn.nascent.pojo.LogInfo;
import cn.nascent.service.ESSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DemoTest {

    @Autowired
    private static ESSearchService esSearchService;

    public static void main(String[] args) throws IOException {
        List<LogInfo> logInfos = esSearchService.queryLogByProjectName("ehd");
        System.out.println(logInfos);
    }
}
