import java.util.*;

public class PG92341 {

    // 방법 1) original ver.
    public class Car {
        String entranceTime;
        String exitTime;
        int parkingTime;

        Car() {
            this.parkingTime = 0;
        }

        public void getIn(String entranceTime) {
            this.entranceTime = entranceTime;
            this.exitTime = "";
        }

        public void getOut(String exitTime) {
            this.exitTime = exitTime;
            calculate();
        }

        private void calculate() {
            int entranceHour = Integer.parseInt(entranceTime.split(":")[0]);
            int entranceMinute = Integer.parseInt(entranceTime.split(":")[1]);
            int exitHour = Integer.parseInt(exitTime.split(":")[0]);
            int exitMinute = Integer.parseInt(exitTime.split(":")[1]);

            this.parkingTime += (exitHour * 60 + exitMinute) - (entranceHour * 60 + entranceMinute);
        }
    }

    public int[] solution1(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFare = fees[1];
        int perTime = fees[2];
        int perFare = fees[3];

        Map<String, Car> parkingGarage = new HashMap<>();
        for (String record : records) {
            String time = record.split(" ")[0];
            String number = record.split(" ")[1];
            String inOrOut = record.split(" ")[2];
            switch (inOrOut) {
                case "IN" -> {
                    if (!parkingGarage.containsKey(number)) {
                        parkingGarage.put(number, new Car());
                    }
                    Car car = parkingGarage.get(number);
                    car.getIn(time);
                }
                case "OUT" -> {
                    Car car = parkingGarage.get(number);
                    car.getOut(time);
                }
            }
        }

        List<String> sortedKeys = new ArrayList<>();
        parkingGarage.keySet().stream().forEach(key -> sortedKeys.add(key));
        Collections.sort(sortedKeys);

        int[] answer = new int[sortedKeys.size()];
        int idx = 0;
        for (String key : sortedKeys) {
            Car car = parkingGarage.get(key);
            if (car.exitTime.equals("")) {
                car.getOut("23:59");
            }

            if (car.parkingTime <= basicTime) {
                answer[idx++] = basicFare;
            } else {
                if ((car.parkingTime - basicTime) % perTime == 0) {
                    answer[idx++] = basicFare + (car.parkingTime - basicTime) / perTime * perFare;
                } else {
                    answer[idx++] = basicFare + ((car.parkingTime - basicTime) / perTime + 1) * perFare;
                }
            }
        }

        return answer;
    }

    // 방법 2) TreeMap 이용
    public int[] solution2(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFare = fees[1];
        int perTime = fees[2];
        int perFare = fees[3];

        Map<String, Integer> parkingGarage = new TreeMap<>();
        for (String record : records) {
            String number = record.split(" ")[1];
            String inOrOut = record.split(" ")[2];

            int time = inOrOut.equals("IN") ? -1 : 1;
            time *= timeToInt(record.split(" ")[0]);
            parkingGarage.put(number, parkingGarage.getOrDefault(number, 0) + time);
        }

        int[] answer = new int[parkingGarage.size()];
        int idx = 0;
        for (int value : parkingGarage.values()) {
            if (value <= 0) {
                value += 23 * 60 + 59; // OUT -> 23:59
            }
            value -= basicTime;
            int cost = basicFare;
            if (value > 0) {
                cost += (value % perTime == 0 ? value / perTime : value / perTime + 1) * perFare;
            }
            answer[idx++] = cost;
        }

        return answer;
    }

    private int timeToInt(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

}