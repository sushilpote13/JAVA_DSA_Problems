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

        // create graph first
        ArrayList<Edges>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // fill the graph
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(new Edges(edge[1], edge[0]));
        }

        // calculate indegree
        int[] indegree = new int[numCourses];

        for (int i = 0; i < graph.length; i++) {
            for (Edges e : graph[i]) {
                indegree[e.dest]++;
            }
        }

        // add indegree 0 courses in queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // topological sort
        int[] result = new int[numCourses];
        int index = 0;

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

        // cycle detected
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}