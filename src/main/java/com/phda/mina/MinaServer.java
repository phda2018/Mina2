package com.phda.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UDP/TCP 方式进行通信
 * @author phda
 *
 */
public class MinaServer {
	
	private Logger log = LoggerFactory.getLogger(MinaServer.class);
	private String ip;
	private int port;
	private IoHandler handler;//通信逻辑处理
	private IoAcceptor server ;//构建通信连接
	
	public MinaServer(String ip,int port) {
		handler = new ServerHandler();
		this.ip = ip;
		this.port = port;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 通过UDP的方式进行数据传输
	 */
	public void buildServerForUDP() {
		log.info("启动服务层【UDP】");
		this.server = new NioDatagramAcceptor();
		server.setHandler(handler);
		server.getFilterChain().addLast("codc", new ProtocolCodecFilter(new TextLineCodecFactory( Charset.forName("UTF-8") )));//按行接收
		
		try {
			server.bind(new InetSocketAddress(ip, port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过TCP的方式进行数据传输
	 */
	public void buildServerForTCP() {
		log.info("启动服务层【TCP】");
		this.server = new NioSocketAcceptor();
		server.setHandler(handler);
		server.getFilterChain().addLast("codc", new ProtocolCodecFilter(new TextLineCodecFactory( Charset.forName("UTF-8") )));//按行接收
		
		try {
			server.bind(new InetSocketAddress(ip, port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}	
