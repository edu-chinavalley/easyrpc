package com.zhonggu.easyrpc.network;

import com.zhonggu.easyrpc.Protocol;

import java.net.SocketAddress;

/**
 * @author: polfdark
 */
public interface Client {

    void start(SocketAddress socketAddress,Protocol protocol, NetworkHandle networkHandle);
}
