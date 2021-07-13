import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        String s = br.readLine();

        for(int i=0;i<s.length();i++){
            String str = s.substring(i);
            list.add(str);
        }

        list.sort(Comparator.naturalOrder());

        for(String str : list)
            System.out.println(str);
    }
}
