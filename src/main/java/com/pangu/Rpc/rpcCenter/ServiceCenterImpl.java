package com.pangu.Rpc.rpcCenter;

import com.pangu.Rpc.rpcServer.RpcServer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 7:06 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Service
public class ServiceCenterImpl implements ServiceCenter, ApplicationContextAware {

    public ApplicationContext context;

    public List<RemoteServiceInfo> remoteServices = new ArrayList<>();

    @Value("${rpc.server.ip}")
    private String ip;

    @Value("${rpc.server.port}")
    private int port;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        Map<String, RpcServer> rpcServers = applicationContext.getBeansOfType(RpcServer.class);
        rpcServers.forEach((k, v) -> {
            Method[] methods = v.getClass().getMethods();
            Arrays.stream(methods).forEach(method -> {
                remoteServices.add(RemoteServiceInfo.builder()
                        .ip(ip)
                        .port(port)
                        .clazz(v.getClass())
                        .method(method)
                        .build());
            });
        });
        // 启动Socket线程
        try {
            ServerSocket serverSocket = new ServerSocket(port);
//            serverSocket.bind(new InetSocketAddress(port));
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,600, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            executor.execute(new ServiceTask(serverSocket));
        } catch (IOException e){

        }
        catch (Exception e){

        }
    }

    @Override
    public RemoteServiceInfo getRemoteService(Class<?> clazz, Method method) {

        return null;
    }
}
