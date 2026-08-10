class Solution {
    public class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public boolean hasCycle(int curr, ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // Node not visited
            if (!vis[e.dest]) {
                if (hasCycle(e.dest, graph, vis, stack)) {
                    return true;
                }
            }
            // Node already visited and still in current DFS path
            else if (stack[e.dest]) {
                return true;
            }
        }
        // Remove from current DFS path
        stack[curr] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            // prerequisite -> course
            graph[prerequisite].add(
                    new Edge(prerequisite, course));
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (hasCycle(i, graph, vis, stack)) {
                    return false;
                }
            }
        }
        return true;
    }
}