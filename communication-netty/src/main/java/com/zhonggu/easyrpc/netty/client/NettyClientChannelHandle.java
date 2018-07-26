package com.zhonggu.easyrpc.netty.client;

import com.zhonggu.easyrpc.network.NetworkHandle;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: polfdark
 */
public class NettyClientChannelHandle extends ChannelInboundHandlerAdapter {

    private NetworkHandle networkHandle;

    public NettyClientChannelHandle(NetworkHandle networkHandle){
        this.networkHandle = networkHandle;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
