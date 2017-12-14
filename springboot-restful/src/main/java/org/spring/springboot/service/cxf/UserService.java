package org.spring.springboot.service.cxf;
import org.spring.springboot.domain.cxf.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Peng.lv on 2017/12/13.
 */
@WebService(name = "UserService", // 暴露服务名称
        targetNamespace = "http://webservice.leftso.com/"// 命名空间,一般是接口的包名倒序
)
public interface UserService{
    @WebMethod
    public User getUser();

    @WebMethod
    public void updateUser(@WebParam(name="user")User user);

}