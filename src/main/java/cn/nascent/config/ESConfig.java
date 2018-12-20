package cn.nascent.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 *
 * 配置ES连接对象TransportClinet
 * @author Zhan
 */
@Configuration
public class ESConfig implements InitializingBean,FactoryBean<TransportClient> {
    // ES集群信息
    @Value("${es.master-host}")
    private String MAST_HOST;
    @Value("${es.port}")
    private  int PORT;
    @Value("${es.cluster-name}")
    private String CLUSTER_NAME; //集群名称

    // 连接对象
    private TransportClient client;

    @Override
    public TransportClient getObject() throws Exception {
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TransportClient的一些配置  集群名称
        Settings settings = Settings.builder()
                .put("cluster.name", CLUSTER_NAME)
                .put("client.transport.sniff", true)
                .build();
        client = new PreBuiltTransportClient(settings);
        System.out.println(CLUSTER_NAME+"-------------------------"+PORT);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(MAST_HOST), PORT));
    }
}
