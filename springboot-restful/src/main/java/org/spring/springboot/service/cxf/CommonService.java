package org.spring.springboot.service.cxf;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Peng.lv on 2017/12/13.
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://webservice.leftso.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String sayHello(@WebParam(name = "userName") String name);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String sayChinese(@WebParam(name = "userName") String name);


}