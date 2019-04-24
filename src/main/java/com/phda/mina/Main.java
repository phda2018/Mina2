package com.phda.mina;

/**
 * 服务层入口
 * @author phda
 *
 */
public class Main {
	
	public Main() {
	}
	
	public static void Run(String ip ,int port) {
		MinaServer server = new MinaServer(ip, port);
		server.buildServerForUDP();
	}
	/**
	 * 参数{ip,port}
	 * @param args
	 */
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 9001;
		if(args.length == 2) {
			ip = args[0];
			port = Integer.parseInt(args[1]);
		}
		Run(ip,port);
	}
	
	
}
