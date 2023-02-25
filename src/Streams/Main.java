package Streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
  
  public static void main(String[] args) throws IOException {
    var contents = Files.readString(Paths.get("gutenberg/alice30.txt"));
    List<String> words = List.of(contents.split("\\PL+"));
    
    int count = 0;
    for (String w : words)
      if (w.length() > 12) count++;
    
    System.out.println("Count of Long Words : " + count);
    System.out.println("Count of Long Words Using Streams : " + words.stream()
            .filter(w -> w.length() > 12)
            .count());
    System.out.println("Count of Long Words Using Parallel Streams : " + words.parallelStream()
            .filter(w -> w.length() > 12)
            .count());
//    Stream<String> infiniteEcho = Stream.generate(() -> "Echo");
//    infiniteEcho.forEach(System.out::println);
//    Stream<Double> infiniteRandomNum = Stream.generate(Math::random);
//    infiniteRandomNum.forEach(System.out::println);
    
    BigInteger limit = BigInteger.valueOf(1_000_000);
    Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,
            n -> n.compareTo(limit) < 0,
            n -> n.add(n));
    
    Stream<String> Words = Pattern.compile("\\PL+").splitAsStream(contents);
    Stream<String> WoRds = new Scanner(contents).useDelimiter(" ").tokens();
//    WoRds.forEach(System.out::println);
    
    try (Stream<String> lines = Files.lines(Paths.get("gutenberg/alice30.txt"))) {
      lines.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
}
