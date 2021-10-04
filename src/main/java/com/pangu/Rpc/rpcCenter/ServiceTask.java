package com.pangu.Rpc.rpcCenter;

import lombok.AllArgsConstructor;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/3 4:14 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ServiceTask implements Runnable{

    @Resource
    private ServiceCenter serviceCenter;

    private final ServerSocket serverSocket;

    public ServiceTask(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            input = new ObjectInputStream(inputStream);
            String serviceName = input.readUTF();
            String methodName = input.readUTF();
//            Object service = input.readObject();
//            Object method = input.readObject();
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            Object[] arguments = (Object[]) input.readObject();
//            Class serviceClass = serviceCenter.getRemoteService(serviceName.getClass(), methodName.getClass());
//            if (serviceClass == null) {
//                throw new ClassNotFoundException(serviceName + " not found");
//            }
//            Method method = serviceClass.getMethod(methodName, parameterTypes);
//            Object result = method.invoke(serviceClass.newInstance(), arguments);

            // 3.将执行结果反序列化，通过socket发送给客户端
            output = new ObjectOutputStream(socket.getOutputStream());
//            output.writeObject(result);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
