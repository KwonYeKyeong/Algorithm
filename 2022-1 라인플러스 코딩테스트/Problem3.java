import java.util.*;

public class Problem3 {

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> work = new HashMap<>(employees.length + 1); // true : 재택, false : 출근
        for (int i = 1; i <= num_teams; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int i = 0; i < employees.length; i++) {
            String[] info = employees[i].split(" ");
            boolean check = true;
            for (int j = 0; j < info.length; j++) {
                if (j == 0) {
                    List<Integer> list = map.get(Integer.parseInt(info[0]));
                    list.add(i + 1);
                    continue;
                }
                if (!isRemoteTask(info[j], remote_tasks)) {
                    check = false;
                    break;
                }
            }

            work.put(i + 1, check);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            boolean remote = true;
            for (int employee : list) {
                if (!work.get(employee)) {
                    remote = false;
                }
            }
            if (remote) { // 팀 전체가 재택 대상자일 때
                Collections.sort(list);
                work.put(list.get(0), false);
            }
        }

        List<Integer> remoteWorkers = new LinkedList<>();
        for (int key : work.keySet()) {
            if (key == 0) {
                continue;
            }
            if (work.get(key)) {
                remoteWorkers.add(key);
            }
        }
        return remoteWorkers.stream().mapToInt(i -> i).toArray();
    }

    private boolean isRemoteTask(String task, String[] remote_tasks) {
        for (int i = 0; i < remote_tasks.length; i++) {
            if (task.equals(remote_tasks[i])) {
                return true;
            }
        }
        return false;
    }

}
