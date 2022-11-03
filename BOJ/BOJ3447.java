import java.io.*;

public class BOJ3447 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        String regex = ".*BUG.*";
        while ((str = br.readLine()) != null) {
            while (str.matches(regex)) {
                str = str.replaceAll("BUG", "");
            }
            System.out.println(str);
        }
    }

}
