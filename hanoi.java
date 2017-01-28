// ハノイの塔の解説 - 特定のステップの状態を出力 - 移動をまとめる
import java.util.*;

class Main {
    /*
      piles    : 3 本の杭を list に格納
      名前なし : 杭は LinkedList で円盤を格納
      名前なし : 円盤の大きさを整数で表す
    */
    static List<LinkedList<Integer>> piles;
    static int count;
    static int target;

    static void initialize(int n) {
        piles = new LinkedList<>();
        count = 0;

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
        count++;

        if (count == target) {
            printPiles();
            System.exit(0);
        }
    }

    static void movePart(int num, int from, int to) {
        LinkedList<Integer> temp = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            int disk = piles.get(from).removeLast();

            temp.addFirst(disk);
        }

        piles.get(to).addAll(temp);
    }

    static void hanoi(int n, int from, int to, int work) {
        if (n == 0) {
            return;
        }

        if (count + (Math.pow(2, n) - 1) <= target) {
            // まとめて移動
            movePart(n, from, to);
            count += Math.pow(2, n) - 1;

            if (count == target) {
                printPiles();
                System.exit(0);
            }
        } else {
            // 再帰で移動
            hanoi(n - 1, from, work, to);
            moveOne(from, to);
            // printPiles();
            hanoi(n - 1, to, work, from);
        }
    }

    static void printPiles() {
        System.out.println("--");
        System.out.println("count :" + count);

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

        target = 1;
        if (target <= Math.pow(2, n) - 1) {
            System.out.println(n);
        } else {
            System.out.println("Too big:" + (int)(Math.pow(2, n) - 1));
            System.exit(1);
        }

        initialize(n);
        printPiles();

        hanoi(n, 0, 2, 1);
    }
}
