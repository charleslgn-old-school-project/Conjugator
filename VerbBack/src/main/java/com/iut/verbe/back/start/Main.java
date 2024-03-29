package com.iut.verbe.back.start;

import com.iut.verbe.back.impl.ServerImpl;
import com.iut.verbe.comon.constant.ServerConstant;
import com.iut.verbe.comon.link.ServerInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
  public static void main(String[] args) {
    try {
      Registry rmiRegistry = LocateRegistry.createRegistry(ServerConstant.PORT);
      ServerInterface serverInterface = (ServerInterface) UnicastRemoteObject
              .exportObject(new ServerImpl(), ServerConstant.PORT);
      rmiRegistry.bind("serverInterface", serverInterface);
      System.out.println("server ready");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
