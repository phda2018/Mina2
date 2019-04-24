package com.phda.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理server请求的Handler
 * @author phda
 *
 */
public class ServerHandler extends IoHandlerAdapter {
	
	private Logger log = LoggerFactory.getLogger(ServerHandler.class);
	private String className = "ServerHandler";
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		log.info("连接建立了");
		
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.info("连接关闭了");
	}
	
	
	
	
}
