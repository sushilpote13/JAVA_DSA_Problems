class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph[prerequisite].add(course);
            indegree[course]++;
        }

        // Queue for courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Topological Sort
        while (!queue.isEmpty()) {

            int current = queue.poll();

            result[index++] = current;

            for (int next : graph[current]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}