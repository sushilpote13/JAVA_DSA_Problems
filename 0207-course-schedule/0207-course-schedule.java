class Solution {

    public class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build graph
        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build directed graph
        // prerequisite -> course
        for (int[] p : prerequisites) {

            int course = p[0];
            int prerequisite = p[1];

            graph[prerequisite].add(
                new Edge(prerequisite, course)
            );
        }

        // Calculate indegree of every course
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                Edge e = graph[i].get(j);

                indegree[e.dest]++;
            }
        }

        // Add courses having indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Count courses processed
        int count = 0;

        // BFS
        while (!q.isEmpty()) {

            int curr = q.remove();

            count++;

            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);

                // Remove current course from dependency
                indegree[e.dest]--;

                // If no prerequisites remain
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // If all courses were processed,
        // there is no cycle
        return count == numCourses;
    }
}