public class BFS {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private String start;

    public BFS(Graph g, String start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        edgeTo.put(start, null);
        distTo.put(start, 0);
        bfs(g, start);
    }

    private void bfs(Graph g, String v) {
        List<String> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            String w = queue.removeFirst();
            marked.add(v);
            for (String x : g.getAdj(w)) {
                if (!marked.contains(x)) {
                    edgeTo.put(x, w);
                    distTo.put(x, distTo.get(w) + 1);
                    marked.add(x);
                    queue.add(x);
                }
            }
        }
    }

    public boolean hasPathTo(String v) {
        return edgeTo.containsKey(v);
        // return marked.contains(v);
    }

    public Iterable<String> pathTo(String v) {
        LinkedList<String> path = new LinkedList<>();
        while (v != null) {
            path.add(0, v);
            v = edgeTo.get(v);
        }
        return path;
    }
}