package org.spring.springboot.service.impl.cxf;

import org.spring.springboot.service.cxf.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
/**
 * Created by Peng.lv on 2017/12/13.
 */
//http://localhost:8080/ws/commonService?wsdl
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.leftso.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "org.spring.springboot.service.cxf.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService {

    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }

    @Override
    public String sayChinese(String name) {
        return "你好 ," + name;
    }

}