package com.zhonggu.easyrpc;

import com.zhonggu.easyrpc.client.RpcClient;
import com.zhonggu.easyrpc.netty.client.NettyClient;

/**
 * @author: polfdark
 */
public class ClientMain {

    RpcClient rpc = new RpcClient(new NettyClient(null,null),null,null,"127.0.0.1",8888);
}
