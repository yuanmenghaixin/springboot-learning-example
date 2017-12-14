package org.spring.springboot.service.impl.cxf;

import org.spring.springboot.domain.cxf.User;
import org.spring.springboot.service.cxf.UserService;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import java.io.*;

/**
 * Created by Peng.lv on 2017/12/13.
 */
@WebService(serviceName = "UserService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.leftso.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "org.spring.springboot.service.cxf.UserService"// 接口地址
)
@Component
public class UserServiceImp implements UserService {

    /**
     * <修改用户信息，包括上传用户的图像
     * 创 建 人:  XX
     * 创建时间:  2012-9-26 下午04:50:23
     * @param user
     * @see [类、类#方法、类#成员]
     */
    @Override
    public void updateUser(User user){
        System.out.println("姓名："+user.getName()+"，年龄："+user.getAge());
        DataHandler handler = user.getImageData();
        try {
            InputStream is = handler.getInputStream();
            OutputStream os = new FileOutputStream(new File("c:\\test11.jpg"));
            byte[] b = new byte[100000];
            int bytesRead = 0;
            while ((bytesRead = is.read(b)) != -1) {
                os.write(b, 0, bytesRead);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询用户信息，包括以附件的形式返回用户的图像
     * 创 建 人:  XX
     * 创建时间:  2012-9-26 下午04:49:43
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    public User getUser(){
        User user =new User(11L,"李四",21);
        user.setImageData(new DataHandler(new FileDataSource(new File("d:"+File.separator)+"test.jpg")));
        System.out.println("处理完成，返回结果");
        return user;
    }
}