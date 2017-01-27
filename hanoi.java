// ハノイの塔の解説 - 初期設定、出力
import java.util.*;

class Main {
    /*
      piles    : 3 本の杭を list に格納
      名前なし : 杭は LinkedList で円盤を格納
      名前なし : 円盤の大きさを整数で表す
    */
    static List<LinkedList<Integer>> piles;

    static void initialize(int n) {
        piles = new LinkedList<>();

        // 3 本の杭を作る
        for (int i = 0; i < 3; i++) {
            piles.add(new LinkedList<>());
        }

        // 0 番の杭に n 枚の円盤を追加する
        for (int i = n; i > 0; i--) {
            piles.get(0).add(i);
        }
    }

    public static void main(String[] args) {
        int n = 100;

        System.out.println(n);
    }
}
