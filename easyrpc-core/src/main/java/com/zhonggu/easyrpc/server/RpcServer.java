package com.zhonggu.easyrpc.server;

import com.zhonggu.easyrpc.Protocol;
import com.zhonggu.easyrpc.Serializer;
import com.zhonggu.easyrpc.network.NetworkHandle;
import com.zhonggu.easyrpc.network.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: polfdark
 */
public class RpcServer {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private Server server;

    private Protocol protocol;

    private Serializer serializer;

    private int port;

    private NetworkHandle networkHandle;

    private Executor executor = Executors.newCachedThreadPool();

    public RpcServer(Server server,Protocol protocol,Serializer serializer,int port,NetworkHandle networkHandle){
        this.server = server;
        this.protocol = protocol;
        this.serializer = serializer;
        this.port = port;
    }

    public void start(){
        server.start(protocol,serializer,port,networkHandle,executor);
    }


    public void shutdown(){

    }

}
