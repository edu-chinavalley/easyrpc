package com.zhonggu.easyrpc;

import com.zhonggu.easyrpc.netty.server.NettyServer;
import com.zhonggu.easyrpc.network.NetworkHandle;
import com.zhonggu.easyrpc.server.RpcServer;

/**
 * Hello world!
 *
 */
public class ServerMain
{
    public static void main( String[] args )
    {
        RpcServer rpc = new RpcServer(new NettyServer(),null,null,8888,null);
        rpc.start();
    }
}
