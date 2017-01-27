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

    static void moveOne(int from, int to) {
        int disk = piles.get(from).removeLast();

        piles.get(to).add(disk);
    }

    static void hanoi(int n, int from, int to, int work) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, work, to);
        moveOne(from, to);
        printPiles();
        hanoi(n - 1, to, work, from);
    }

    static void printPiles() {
        System.out.println("--");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + ":");

            for (int disk : piles.get(i)) {
                System.out.print(" " + disk);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(n);

        initialize(n);
        printPiles();

        hanoi(n, 0, 2, 1);
    }
}
