package cn.com.winning.ssgj;

import cn.com.winning.ssgj.ws.client.HelloWS;
import cn.com.winning.ssgj.ws.client.HelloWSService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chenshijie
 * @title WS 接口调用实现类
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj
 * @date 2018-02-05 10:08
 */
public class WSClient {
    /**
     * WS服务测试
     */
    @Test
    public void wsServiceTest(){

        String wsdlURL = "http://localhost:9999/service/hello?wsdl";
        try {
            useJAXWS(wsdlURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        useCXF(wsdlURL);
    }

    /**
     * jaxws调用
     * @param  url 访问wsdl资源
     * @throws MalformedURLException
     */
    private void useJAXWS(String url) throws MalformedURLException {
        //URL不是必须的，除非服务的地址有改变
       /* URL wsdlURL = new URL(url);
        HelloWSService helloWSServiceForURL = new HelloWSService(wsdlURL);*/
        HelloWSService helloWSService = new HelloWSService();
        HelloWS helloWS = helloWSService.getHelloWSPort();
        String welcome = helloWS.welcome("JAXWS");
        System.out.println(welcome);
    }

    /**
     * cxf调用
     * @param url 访问wsdl资源
     */
    public void useCXF(String url){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWS.class);
        factory.setAddress(url);
        HelloWS helloWS = factory.create(HelloWS.class);
        String welcome = helloWS.welcome("CXF");
        System.out.println(welcome);
    }
}
