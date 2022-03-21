import java.util.*;

public class Problem2 {

    class Read {
        int startTime;
        int duration;
        int startIndex;
        int endIndex;

        Read(int startTime, int duration, int startIndex, int endIndex) {
            this.startTime = startTime;
            this.duration = duration;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    class Write {
        int startTime;
        int duration;
        int startIndex;
        int endIndex;
        String word;

        Write(int startTime, int duration, int startIndex, int endIndex, String word) {
            this.startTime = startTime;
            this.duration = duration;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.word = word;
        }
    }

    public String[] solution(String[] arr, String[] processes) {
        List<String> answer = new ArrayList<>();
        Queue<Read> readQueue = new LinkedList<>();
        Queue<Write> writeQueue = new LinkedList<>();

        for (String process : processes) {
            String action = process.split(" ")[0];
            if (action.equals("read")) {
                readQueue.add(new Read(
                        Integer.parseInt(process.split(" ")[1]), Integer.parseInt(process.split(" ")[2]),
                        Integer.parseInt(process.split(" ")[3]), Integer.parseInt(process.split(" ")[4])));
            } else if (action.equals("write")) {
                writeQueue.add(new Write(
                        Integer.parseInt(process.split(" ")[1]), Integer.parseInt(process.split(" ")[2]),
                        Integer.parseInt(process.split(" ")[3]), Integer.parseInt(process.split(" ")[4]),
                        process.split(" ")[5]));
            }
        }

        int clock = 0, runningTime = 0, restTime = 0;
        boolean reading = false, writing = false;
        while (!writeQueue.isEmpty() || !readQueue.isEmpty() || clock < runningTime) {
            while (!reading && !writing && !writeQueue.isEmpty()) {
                Write w = writeQueue.peek();
                if (clock >= w.startTime) {
                    writeQueue.poll();
                    for (int i = w.startIndex; i <= w.endIndex; i++) {
                        arr[i] = w.word;
                    }
                    writing = true;
                    runningTime = Math.max(runningTime, clock + w.duration);
                } else {
                    break;
                }
            }
            while (!writing && !readQueue.isEmpty()) {
                Read r = readQueue.peek();
                if (clock >= r.startTime && (writeQueue.isEmpty() || clock < writeQueue.peek().startTime)) {
                    readQueue.poll();
                    StringBuilder sb = new StringBuilder();
                    for (int i = r.startIndex; i <= r.endIndex; i++) {
                        sb.append(arr[i]);
                    }
                    answer.add(sb.toString());
                    reading = true;
                    runningTime = Math.max(runningTime, clock + r.duration);
                } else {
                    break;
                }
            }
            
            if (reading || writing) {
                if (clock == runningTime - 1) {
                    reading = false;
                    writing = false;
                }
            } else {
                restTime++;
            }
            clock++;
        }

        answer.add(String.valueOf(clock - restTime));

        return answer.toArray(String[]::new);
    }

}