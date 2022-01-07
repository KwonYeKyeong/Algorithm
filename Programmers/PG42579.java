import java.util.*;

public class PG42579 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<Integer, Integer> songPlays = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        // 많이 재생된 장르 순으로 정렬
        for (int i = 0; i < genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreList = new ArrayList<>(genrePlays.keySet());
        Collections.sort(genreList, (g1, g2) -> genrePlays.get(g2).compareTo(genrePlays.get(g1)));

        // 재생 수가 많은 노래 순으로 정렬
        for (int i = 0; i < plays.length; i++) {
            songPlays.put(i, plays[i]);
        }
        List<Integer> songList = new ArrayList<>(songPlays.keySet());
        Collections.sort(songList, (i1, i2) -> songPlays.get(i2).compareTo(songPlays.get(i1)));

        // 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범 생성
        for (String genre : genreList) {
            int count = 0;
            for (int index : songList) {
                if (genres[index].equals(genre)) {
                    bestAlbum.add(index);
                    count++;
                }

                if (count >= 2) break;
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

}
