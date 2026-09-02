class WordDictionary {

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private boolean isEnd = false;
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, k -> new Node());
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, Node curr) {
        // Base case: Reached the end of the search word
        if (index == word.length()) {
            return curr.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard: Try all possible child branches
            for (Node child : curr.children.values()) {
                if (dfsSearch(word, index + 1, child)) {
                    return true; // Match found along this path
                }
            }
            return false; // No branch matched
        } else {
            // Exact character match
            Node nextNode = curr.children.get(c);
            return (nextNode != null) ? dfsSearch(word, index + 1, nextNode) : false;
        }}
}
