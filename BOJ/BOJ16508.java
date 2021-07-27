import java.io.*;
import java.util.*;

class Book {
    int price;
    String title;

    Book(int p, String t){
        price = p;
        title = t;
    }
}
public class BOJ16508 {
    static ArrayList<Book> bookList = new ArrayList<>();
    static int[] cnt = new int[26];
    static int[] selectCnt = new int[26];
    static String t;
    static int n, minPrice = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = br.readLine();
        for(int i=0;i<t.length();i++)
            cnt[t.charAt(i)-'A']++;

        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            String w = st.nextToken();
            bookList.add(new Book(c, w));
        }

        dfs(0, 0);

        System.out.print(minPrice==987654321 ? -1 : minPrice);
    }
    public static void dfs(int idx, int totalPrice){
        if(idx==n){
            if(check())
                minPrice = Math.min(totalPrice, minPrice);
            return;
        }

        for(int i=0;i<bookList.get(idx).title.length();i++)
            selectCnt[bookList.get(idx).title.charAt(i)-'A']++;
        
        dfs(idx+1, totalPrice+bookList.get(idx).price);

        for(int i=0;i<bookList.get(idx).title.length();i++)
            selectCnt[bookList.get(idx).title.charAt(i)-'A']--;

        dfs(idx+1, totalPrice);
    }
    public static boolean check(){
        for(int i=0;i<26;i++){
            if(cnt[i]>selectCnt[i])
                return false;
        }
        return true;
    }
}
