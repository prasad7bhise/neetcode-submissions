class PrefixTree {

   private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private boolean isEnd = false;
    }
    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, k -> new Node());
        }
        curr.isEnd =true; 
    }

    public boolean search(String word) {
        Node node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private Node traverse(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                return null; // Character pathway does not exist
            }
        }
        return curr;
    }
}
