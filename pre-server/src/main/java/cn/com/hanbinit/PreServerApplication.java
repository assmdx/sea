package cn.com.hanbinit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author icer
 */
@EnableEurekaClient
@SpringBootApplication
public class PreServerApplication extends Thread{

	private static final Logger logger = LoggerFactory.getLogger(PreServerApplication.class);

	private final int PORT = 10000;

	@Autowired
	private HandlerInitializer handlerInitializer;

	public void run() {
		// Configure the server.
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(handlerInitializer);

			// start server
			ChannelFuture f = b.bind(PORT).sync();

			logger.info(PreServerApplication.class.getName() + " started and listen on " + f.channel().localAddress());

			// Wait until the server socket is closed.
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		} catch (ReadTimeoutException e) {
			logger.error(e.getMessage());
		} finally {
			// Shut down all event loops to terminate all threads.
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	@PostConstruct
	public void serverStart() {
		this.start();
	}

	@PreDestroy
	public void serverStop(){
		this.interrupt();
	}

	public static void main(String[] args) {
		SpringApplication.run(PreServerApplication.class, args);
	}
}
