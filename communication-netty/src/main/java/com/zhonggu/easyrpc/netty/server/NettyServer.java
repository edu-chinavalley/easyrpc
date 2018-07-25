package com.zhonggu.easyrpc.netty.server;

import com.zhonggu.easyrpc.Protocol;
import com.zhonggu.easyrpc.Serializer;
import com.zhonggu.easyrpc.network.NetworkHandle;
import com.zhonggu.easyrpc.network.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;

/**
 * @author: polfdark
 */
public class NettyServer implements Server {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;


    @Override
    public void start(Protocol protocol, Serializer serializer, int port, NetworkHandle networkHandle, Executor executor) {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new NettyServerInitializer(executor,networkHandle))
                // TODO: 2018/7/25 默认设置需要添加option
                .option(ChannelOption.SO_KEEPALIVE, true)
                .bind(port);
    }
}
