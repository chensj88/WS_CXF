package cn.com.winning.ssgj.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chenshijie
 * @title ${file_name}
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.webservice
 * @date 2018-02-05 8:59
 */
@WebService(
        name = "HelloWS",
        targetNamespace = "http://www.demo.chensj.org/services/hello"
)
public interface HelloWS {

    @WebMethod
    String welcome(@WebParam(name = "name") String name);
}
