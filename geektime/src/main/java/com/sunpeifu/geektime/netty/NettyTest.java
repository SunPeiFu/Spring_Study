package com.sunpeifu.geektime.netty;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 作者:  daike
 * 日期:  2020/7/18
 * 描述:
 */
public class NettyTest {

    public static void main(String[] args) throws IOException {
        int port = 100;
        // 1 创建Socket实例
        ServerSocket serverSocket = new ServerSocket(port);
        // 2
        serverSocket.accept();
    }
}
