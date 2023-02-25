package Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress[] addresses = InetAddress.getAllByName("google.com");
    for (InetAddress i : addresses)
      System.out.println(i);
    
    InetAddress localHostAddress = InetAddress.getLocalHost();
    System.out.println(localHostAddress);
  }
}
