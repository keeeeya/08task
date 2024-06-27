package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

  // 課題
  // 入出力を実際に実装して、作ったファイルに文章を追加する。
  // その作ったファイルを削除してもう一度実行すると例外になるので、その例外をキャッチして、例外処理を行う。
  // catchした中でさらにファイルに書き込もうとして例外になった場合、どうなるのかを確認してください。
  public static void main(String[] args) {
    try {
      Path path = Path.of("Foods.txt");
      Files.writeString(path, "、そば、うどん、ラーメン、焼肉", StandardOpenOption.APPEND);
      System.out.println(Files.readString(path));
    } catch (IOException e1) {
      e1.printStackTrace();
      System.out.println("例外１が発生しました");
      try {
        Path path = Path.of("Foods.txt");
        Files.writeString(path, "、おにぎり、餃子、エビマヨ、唐揚げ", StandardOpenOption.APPEND);
        System.out.println(Files.readString(path));
      } catch (IOException e2) {
        e2.printStackTrace();
        System.out.println("例外２が発生しました");
      }
    }

  }
}