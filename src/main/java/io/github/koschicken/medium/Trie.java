package io.github.koschicken.medium;

/**
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/">208. 实现Trie（前缀树）</a>
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));   // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        char[] array = word.toCharArray();
        for (char ch : array) {
            // 计算当前字符对应的子节点位置
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                // 如果当前字符对应的节点位置为空，则创建一个新的节点并放入数组
                currentNode.children[index] = new TrieNode();
            }
            // 将指针指向当前字符对应的节点
            currentNode = currentNode.children[index];
        }
        currentNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        char[] array = word.toCharArray();
        for (char c : array) {
            // 计算当前字符对应的子节点位置
            int index = c - 'a';
            if (currentNode.children[index] == null) {
                // 如果当前字符对应的节点位置为空，说明要搜索的字符串不存在，结束搜索
                return false;
            }
            // 将指针指向当前字符对应的节点
            currentNode = currentNode.children[index];
        }
        // 即使要搜索的字符串中所有字符都依序存在，也要看最后一个字符所在的节点是否被标记为单词的结尾，否则就只是搜索到了前缀而不是单词
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        char[] array = prefix.toCharArray();
        for (char c : array) {
            // 计算当前字符对应的子节点位置
            int index = c - 'a';
            if (currentNode.children[index] == null) {
                // 如果当前字符对应的节点位置为空，说明要搜索的字符串不存在，结束搜索
                return false;
            }
            currentNode = currentNode.children[index];
        }
        // 要搜索的字符串中所有字符都依序存在，所要搜索的前缀存在
        return true;
    }

    /**
     * 前缀树节点
     * <pre>
     * 每个节点都包含一个节点数组存储其子节点。
     * 除了根节点外，每个节点也都处在父节点的节点数组中，且该节点的位置代表这个节点对应的字符。
     * 节点在数组中的位置是根据节点代表的字符的ASCII码计算的。
     * 此外每个节点还有一个标记用来标识当前节点是否是一个单词的结尾。
     * </pre>
     */
    public static class TrieNode {
        // 子节点数组，因为只存放小写英文字母，所以初始化为长度26的数组，依次存放a到z
        public final TrieNode[] children = new TrieNode[26];
        // 标记当前节点是否是单词的最后一个字符
        public boolean isWord;

    }
}