package com.zhonggu.easyrpc.netty.server;


import com.zhonggu.easyrpc.network.NetworkHandle;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;


public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final Logger logger = LoggerFactory.getLogger(NettyServerInitializer.class);

    private Executor executor;
    private NetworkHandle networkHandle;

    public NettyServerInitializer(Executor executor, NetworkHandle networkHandle) {
        this.executor = executor;
        this.networkHandle = networkHandle;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addFirst(new NettyServerChannelHandle(executor,networkHandle));
    }
}
