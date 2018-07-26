package com.zhonggu.easyrpc.client;

import com.zhonggu.easyrpc.Protocol;
import com.zhonggu.easyrpc.Serializer;
import com.zhonggu.easyrpc.network.Client;
import com.zhonggu.easyrpc.network.Server;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author: polfdark
 */
public class RpcClient {

    private Protocol protocol;

    private Serializer serializer;

    private Client client;

    private int port;

    private String host;
    public RpcClient(Client client,Protocol protocol,Serializer serializer,String host,int port){
        this.client = client;
        this.protocol = protocol;
        this.serializer = serializer;
        this.host = host;
        this.port = port;
    }

    public void start(){
        InetSocketAddress serviceAddress = InetSocketAddress.createUnresolved(host, port);
        client.start(serviceAddress);

    }

    public void shutdown(){


    }
}
