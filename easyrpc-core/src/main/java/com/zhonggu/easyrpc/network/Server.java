package com.zhonggu.easyrpc.network;

import com.zhonggu.easyrpc.Protocol;
import com.zhonggu.easyrpc.Serializer;

import java.util.concurrent.Executor;

/**
 * @author: polfdark
 */
public interface Server {

    void start(Protocol protocol, Serializer serializer,int port,NetworkHandle networkHandle, Executor executor);
}
