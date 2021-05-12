package com.atguigu.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class S_O_1 extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if(msg instanceof TextWebSocketFrame ) {
            TextWebSocketFrame msg1 = (TextWebSocketFrame) msg;
            System.out.println("S out 111 get msg = " + msg1.text());
            msg=new TextWebSocketFrame("so1, "+ msg1.text());
        }else {
            System.out.println("S out 111 get msg = " + msg);

        }
        ctx.writeAndFlush(msg);
    }
}