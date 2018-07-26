package com.zhonggu.easyrpc.netty.client;

import com.zhonggu.easyrpc.Protocol;
import com.zhonggu.easyrpc.network.Client;
import com.zhonggu.easyrpc.network.NetworkHandle;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;

/**
 * @author: polfdark
 */
public class NettyClient implements Client {
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);
    private EventLoopGroup workerGroup;
    private Channel channel;
    private Protocol protocol;
    private NetworkHandle networkHandle;

    @Override
    public void start(SocketAddress socketAddress,Protocol protocol, NetworkHandle networkHandle) {
        workerGroup = new NioEventLoopGroup();

        Bootstrap b1 = new Bootstrap();
        ChannelFuture channelFuture;
        try {
            channelFuture = b1.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new NettyClientInitalizer(networkHandle)).connect(socketAddress).sync().await();
        } catch (InterruptedException e) {
            logger.error("channel  connection time out!  socketAddress={}", socketAddress);
            throw new RuntimeException("channel  connection time out!");
        }
    }
}
