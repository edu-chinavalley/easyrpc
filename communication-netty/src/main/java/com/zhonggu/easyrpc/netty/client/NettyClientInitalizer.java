package com.zhonggu.easyrpc.netty.client;

import com.zhonggu.easyrpc.network.NetworkHandle;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author: polfdark
 */
public class NettyClientInitalizer extends ChannelInitializer<SocketChannel> {

    private NetworkHandle networkHandle;
    public NettyClientInitalizer(NetworkHandle networkHandle){
        this.networkHandle = networkHandle;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addFirst(new NettyClientChannelHandle(networkHandle));

    }
}
