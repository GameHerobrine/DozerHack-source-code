package net.minecraft.src;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class Packet3Chat extends Packet {
    public String message;
    public ArrayList messages = new ArrayList();




    public Packet3Chat() {
    }

    public Packet3Chat(String var1) {
        if (var1.length() > 99999999) {
            var1 = var1.substring(0, 99999999);
        }

        this.message = var1;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.message = readString(var1, 119);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        writeString(this.message, var1);
    }

    public void processPacket(NetHandler var1) {
    	System.out.println(this.message);
    	/*
    	if (!message.startsWith("<") && !message.startsWith("¡±") && !message.startsWith("Players online: ¡±7(")
                && !message.contains("joined the game.") && !message.contains("¡±e") && !message.contains("left the game.") &&!message.contains("[Server]")) {
            messages.add(message); 
    	}
    	try {
    		String path = "C:\\Users\\user\\Desktop\\PlayerList.txt";
    		final boolean append = true, autoFlush = true;
    		PrintStream printStream = new PrintStream(new FileOutputStream(path,append),autoFlush);
    		  for(int i = 0; i <messages.size(); i++) {
                  printStream.append((CharSequence) messages.get(i));
              }
    		  String mod;
              BufferedReader reader = new BufferedReader(new FileReader(path));
              while ((mod = reader.readLine()) != null) {
                  if(mod.contains(",")) {
                      String as[] = mod.split(", ");
                      for (int i = 0; i < as.length; i++) {
                          if (!hacks.playerlist.contains(as[i])) {
                        	  hacks.playerlist.add(as[i]);
                          }
                      }
                  }
              }
              reader.close();
    		
    	}catch(Exception e) {
    		
    	}
    	*/
    	var1.handleChat(this);
    }




    public int getPacketSize() {
        return this.message.length();
    }
}
