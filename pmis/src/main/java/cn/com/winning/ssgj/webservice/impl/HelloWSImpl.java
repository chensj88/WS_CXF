package cn.com.winning.ssgj.webservice.impl;

import cn.com.winning.ssgj.webservice.HelloWS;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenshijie
 * @title ${file_name}
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.webservice.impl
 * @date 2018-02-05 9:01
 */
public class HelloWSImpl implements HelloWS {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
    @Override
    public String welcome(String name) {
        System.out.println(name + " login," + sdf.format(new Date()));
        return "hello " + name + " !";
    }
}
