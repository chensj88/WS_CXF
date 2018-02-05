package cn.com.winning.ssgj.webservice;

import cn.com.winning.ssgj.webservice.impl.HelloWSImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

/**
 * @author chenshijie
 * @title ${file_name}
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.webservice
 * @date 2018-02-05 9:02
 */
public class WebServiceServer {

    public static void main(String[] args){
       publishByCXF();
    }

    /**
     * 第一种发布方式：通过CXF提供的JaxWsServerFactoryBean来发布webservice
     */
    private static void publishByCXF(){
        //创建WebService发布Server工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置服务接口
        factory.setServiceClass(HelloWS.class);
        //设置发布服务的地址
        factory.setAddress("http://localhost:9999/service/hello");
        //设置服务接口实现类
        factory.setServiceBean(new HelloWSImpl());
        //创建服务，外部访问
        factory.create();
    }

    /**
     * 第二种方式，通过JAX-WS提供的Endpoint来发布webservice
     */
    private static  void publishByJAXWS(){
        //服务所在地址
        String address = "http://localhost:9999/service/hello";
        //发布服务
        Endpoint.create(address,new HelloWSImpl());
    }
}
