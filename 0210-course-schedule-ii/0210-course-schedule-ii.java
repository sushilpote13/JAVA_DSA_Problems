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
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(new Edges(edge[1], edge[0]));
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < graph.length; i++) {
            for (Edges e : graph[i]) {
                indegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

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

        if (index != numCourses) {
            return new int[0];
        }
        
        return result;
    }
}