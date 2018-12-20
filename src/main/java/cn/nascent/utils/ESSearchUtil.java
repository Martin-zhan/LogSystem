package cn.nascent.utils;

import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.UnknownHostException;
/**
 * ES搜索工具类
 * @author Zhan
 * @date 2018/12/20 11:44
 */
@Controller
public class ESSearchUtil {
    private Logger logger = Logger.getLogger(ESSearchUtil.class);
    // ES连接对象TransportClient
    @Autowired
    private TransportClient client;

    /**
     *
     *  词项搜索
     */
    public SearchHits TermQuery(String indexName, String fieldName, String value){
        // 设置查询条件
        TermQueryBuilder termQuery = QueryBuilders.termQuery(fieldName, value);
        System.out.println(client);
        SearchResponse response = client.prepareSearch(indexName).setQuery(termQuery).get();
        SearchHits hits = response.getHits();
        // 打印提示
        return hits;
    }

    /**
     *
     *   根据时间范围查询
     */
    public SearchHits RangeQuery(String indexName, String fieldName, String from, String to) {
        // 设置查询条件
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery(fieldName);
        if (from != null) {
            rangeQuery.from(from);
        }
        if (to != null) {
            rangeQuery.to(to);
        }
        rangeQuery.includeLower(true).includeUpper(true);
        // 执行查询
        SearchResponse response = client.prepareSearch(indexName).setQuery(rangeQuery).get();
        return response.getHits();
    }

    /**
     * 测试用: 过后需删除
     * 打印出hit信息
     */
    public void printHitsMessage(SearchHits hits) {
        for (SearchHit hit : hits) {
            System.out.println("Source:"+hit.getSourceAsString());
            System.out.println("Source As Map:"+hit.getSourceAsMap());
            System.out.println("Index:"+hit.getIndex());
            System.out.println("Type:"+hit.getType());
            System.out.println("ID:"+hit.getId());
        }
    }

}
