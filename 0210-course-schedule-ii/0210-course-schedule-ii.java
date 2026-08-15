class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        for (int[] edges : prerequisites) {
            adj[edges[1]][edges[0]]++;
        }

        int[] indegree = new int[numCourses];
        for (int[] edges : prerequisites) {
            indegree[edges[0]]++;
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
            for (int i = 0; i < adj[cur].length; i++) {
                if (adj[cur][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}