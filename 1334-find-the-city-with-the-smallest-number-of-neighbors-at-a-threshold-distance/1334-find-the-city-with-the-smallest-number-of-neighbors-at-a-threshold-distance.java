class Solution {
    public class Edges {
        int from;
        int to;
        int wt;

        public Edges(int from, int to, int wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] frequency = new int[n];

        // create a graph first 
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int wt = edges[i][2];

            graph[from].add(new Edges(from, to, wt));
            graph[to].add(new Edges(to, from, wt));
        }

        // travel the graph 
        for (int i = 0; i < n; i++) {
            int vertex = i;

            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[vertex] = 0;

            PriorityQueue<Edges> pq = new PriorityQueue<>(
                    (a, b) -> a.wt - b.wt);

            pq.add(new Edges(vertex, vertex, 0));

            while (!pq.isEmpty()) {
                Edges current = pq.remove();

                int currentVertex = current.to;
                int currentDistance = current.wt;

                if (currentDistance > distance[currentVertex]) {
                    continue;
                }

                for (int j = 0; j < graph[currentVertex].size(); j++) {
                    Edges neighbore = graph[currentVertex].get(j);

                    int newDistance = currentDistance + neighbore.wt;

                    if (newDistance < distance[neighbore.to] &&
                            newDistance <= distanceThreshold) {

                        distance[neighbore.to] = newDistance;
                        pq.add(new Edges(
                                currentVertex,
                                neighbore.to,
                                newDistance));
                    }
                }
            }

            int total = 0;

            for (int j = 0; j < n; j++) {
                if (j != vertex && distance[j] <= distanceThreshold) {
                    total++;
                }
            }

            frequency[i] = total;
        }

        int answer = 0;
        int minFrequency = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (frequency[i] <= minFrequency) {
                minFrequency = frequency[i];
                answer = i;
            }
        }

        return answer;
    }
}