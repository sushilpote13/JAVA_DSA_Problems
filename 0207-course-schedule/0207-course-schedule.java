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
        // mark the curr course visted
        vis[curr] = true;
        stack[curr] = true;

        // vist all the neighbore of curr
        for (int i = 0; i < graph[curr].size(); i++) {
            // if the node is visted or not 
            Edge e = graph[curr].get(i);

            //case 1. if it is not visted 
            if (!vis[e.dest]) {
                // check cycle for that neighbore
                if (hasCycle(e.dest, graph, vis, stack)) {
                    return true;
                }
            }

            // case 2. if it is visted then check in the current DFS
            if (stack[e.dest]) {
                return true;
            }
        }
        // we are done exploring this node remove curr from the stack 
        stack[curr] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph first
        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        // create an ArrayList for every courses;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];
            // prerequisite -> course

            graph[prerequisite].add(new Edge(prerequisite, course));
        }
        // Visited array
        boolean[] vis = new boolean[numCourses];

        // Current DFS path
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