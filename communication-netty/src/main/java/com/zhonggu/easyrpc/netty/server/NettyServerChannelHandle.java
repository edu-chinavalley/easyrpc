package com.zhonggu.easyrpc.netty.server;

import com.zhonggu.easyrpc.network.NetworkHandle;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Executor;

/**
 * @author: polfdark
 */
public class NettyServerChannelHandle extends ChannelInboundHandlerAdapter {

    private Executor executor;

    private NetworkHandle networkHandle;

    public NettyServerChannelHandle(Executor executor, NetworkHandle networkHandle){
        this.executor = executor;
        this.networkHandle = networkHandle;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead");
        super.channelRead(ctx, msg);
    }
}
