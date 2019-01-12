package cn.com.hanbinit;

import cn.com.hanbinit.handler.PreServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author icer
 * Created by icer on 2017/10/24.
 */
@Service
public class HandlerInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private PreServerHandler preServerHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new IdleStateHandler(0, 0, 10, TimeUnit.SECONDS));
        p.addLast(new ByteArrayDecoder());
        p.addLast(new ByteArrayEncoder());
        // 这里还需要继续添加一个业务处理handler集合

        p.addLast(preServerHandler);
    }

}
