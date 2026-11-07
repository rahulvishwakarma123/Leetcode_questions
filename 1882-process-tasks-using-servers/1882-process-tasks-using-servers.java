
import java.util.*;

class Solution {

    static class Server {
        int weight;
        int index;
        long finishTime;

        Server(int weight, int index, long finishTime) {
            this.weight = weight;
            this.index = index;
            this.finishTime = finishTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<Server> free = new PriorityQueue<>(
            (a, b) -> {
                if (a.weight != b.weight)
                    return Integer.compare(a.weight, b.weight);

                return Integer.compare(a.index, b.index);
            }
        );

        PriorityQueue<Server> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a.finishTime != b.finishTime)
                    return Long.compare(a.finishTime, b.finishTime);

                if (a.weight != b.weight)
                    return Integer.compare(a.weight, b.weight);

                return Integer.compare(a.index, b.index);
            }
        );

        int n = servers.length;
        int[] ans = new int[tasks.length];

        for (int i = 0; i < n; i++) {
            free.offer(new Server(servers[i], i, 0));
        }

        long currentTime = 0;

        for (int i = 0; i < tasks.length; i++) {

            // Time cannot go backwards.
            currentTime = Math.max(currentTime, i);

            // Release all available servers.
            while (!busy.isEmpty() &&
                   busy.peek().finishTime <= currentTime) {

                free.offer(busy.poll());
            }

            // If no server is free, advance time.
            if (free.isEmpty()) {

                currentTime = busy.peek().finishTime;

                // Release all servers finishing at this time.
                while (!busy.isEmpty() &&
                       busy.peek().finishTime <= currentTime) {

                    free.offer(busy.poll());
                }
            }

            // Select the best available server.
            Server selected = free.poll();

            ans[i] = selected.index;

            // Update its finishing time.
            selected.finishTime = currentTime + tasks[i];

            busy.offer(selected);
        }

        return ans;
    }
}
