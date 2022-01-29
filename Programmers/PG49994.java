public class PG49994 {

    public class Visited {
        public boolean up;
        public boolean down;
        public boolean left;
        public boolean right;

        Visited() {
            this.up = true;
            this.down = true;
            this.left = true;
            this.right = true;
        }
    }

    public int solution(String dirs) {
        int currentX = 5, currentY = 5;
        Visited[][] map = new Visited[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new Visited();
            }
        }
        int answer = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int nextX = currentX, nextY = currentY;
            switch (dirs.charAt(i)) {
                case 'U' -> nextX = currentX - 1;
                case 'D' -> nextX = currentX + 1;
                case 'L' -> nextY = currentY - 1;
                case 'R' -> nextY = currentY + 1;
            }
            if (!outOfBound(nextX, nextY)) {
                switch (dirs.charAt(i)) {
                    case 'U' -> {
                        if (map[currentX][currentY].up == true && map[nextX][nextY].down == true) {
                            answer++;
                        }
                        map[currentX][currentY].up = false;
                        map[nextX][nextY].down = false;
                    }
                    case 'D' -> {
                        if (map[currentX][currentY].down == true && map[nextX][nextY].up == true) {
                            answer++;
                        }
                        map[currentX][currentY].down = false;
                        map[nextX][nextY].up = false;
                    }
                    case 'L' -> {
                        if (map[currentX][currentY].left == true && map[nextX][nextY].right == true) {
                            answer++;
                        }
                        map[currentX][currentY].left = false;
                        map[nextX][nextY].right = false;
                    }
                    case 'R' -> {
                        if (map[currentX][currentY].right == true && map[nextX][nextY].left == true) {
                            answer++;
                        }
                        map[currentX][currentY].right = false;
                        map[nextX][nextY].left = false;
                    }
                }
                currentX = nextX;
                currentY = nextY;
            }
        }

        return answer;
    }

    private boolean outOfBound(int x, int y) {
        if (x >= 0 && x <= 10 && y >= 0 && y <= 10) {
            return false;
        }
        return true;
    }

}
