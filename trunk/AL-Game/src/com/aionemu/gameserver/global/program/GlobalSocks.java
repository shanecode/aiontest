package com.aionemu.gameserver.global.program;

import com.aionemu.gameserver.global.additions.MessagerAddition;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalSocks {
   private static final Logger log = LoggerFactory.getLogger(GlobalSocks.class);
   
   public static void init() {
       ServerSocket echoServer = null;
       String line;
       DataInputStream is;
       PrintStream os;
       Socket clientSocket = null;
       try {
           echoServer = new ServerSocket(8765);
       }
       catch (IOException e) {
           log.info("[Global] Error in Socks");
       }
       try {
           clientSocket = echoServer.accept();
           is = new DataInputStream(clientSocket.getInputStream());
           os = new PrintStream(clientSocket.getOutputStream());
       
       while (true) {
           line = is.readLine();
           os.println(line);
           MessagerAddition.announceAll("[Global]:"+ line, 0);
           log.info("[Global]Entering String :" + line);
       }
       }
       catch (IOException e) {
    log.info("[Global]Socks: Error in Socket(Line)");
}
}
}
