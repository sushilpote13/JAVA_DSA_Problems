class Solution {
    public class Edges {
        int src;
        int dest;

        public Edges(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edges>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int prerequisite = edge[1];
            int course = edge[0];

            graph[prerequisite].add(
                new Edges(prerequisite, course)
            );
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Kahn's Algorithm
        while (!q.isEmpty()) {
            int cur = q.remove();
            result[index++] = cur;
            for (Edges e : graph[cur]) {
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}