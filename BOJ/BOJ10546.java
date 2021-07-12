import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String name = br.readLine();
            if(map.containsKey(name))
                map.replace(name, map.get(name)+1);
            else map.put(name, 1);
        }

        for(int i=0;i<N-1;i++){
            String name = br.readLine();
            map.replace(name, map.get(name)-1);
        }

        for(String key : map.keySet()){
            if(map.get(key)!=0){
                System.out.println(key);
                break;
            }
        }
    }
}
