package se.lazystone.spotbugs4;

public class Runner {

  private final String unusedVariable = "detect me";

  public static void main(String... args) {
    var a = 10;
    var b = 11;
    System.out.println(a);
  }
}
