package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/search-suggestions-system/description/">1268. 搜索推荐系统</a>
 */
public class SuggestedProducts {

    @Test
    void solution() {
        // 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
        // 输出：[
        // ["mobile","moneypot","monitor"],
        // ["mobile","moneypot","monitor"],
        // ["mouse","mousepad"],
        // ["mouse","mousepad"],
        // ["mouse","mousepad"]
        // ]
        // 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
        // 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
        // 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
        List<List<String>> suggestedProducts = suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        for (List<String> products : suggestedProducts) {
            StringBuilder sb = new StringBuilder();
            products.forEach(s -> sb.append(s).append(','));
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> suggestedProducts = new ArrayList<>();
        int min = 0;
        int max = products.length;
        for (int i = 1; i < searchWord.length() + 1; i++) {
            String search = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for (int j = min; j < max; j++) {
                if (products[j].startsWith(search)) {
                    if (list.size() == 3) break;
                    list.add(products[j]);
                    if (list.size() == 1) {
                        min = j;
                    }
                } else {
                    if (!list.isEmpty()) {
                        max = j;
                        break;
                    }
                }
            }
            suggestedProducts.add(list);
        }
        return suggestedProducts;
    }

    public List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> suggestedProducts = new ArrayList<>();
        for (int i = 1; i < searchWord.length() + 1; i++) {
            List<String> search = trie.searchTop3(searchWord.substring(0, i));
            suggestedProducts.add(search);
        }
        return suggestedProducts;
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currentNode = root;
            char[] array = word.toCharArray();
            for (char ch : array) {
                int index = ch - 'a';
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new TrieNode(ch);
                }
                currentNode = currentNode.children[index];
            }
            currentNode.isWord = true;
        }

        public List<String> searchTop3(String word) {
            TrieNode currentNode = root;
            char[] array = word.toCharArray();
            for (char c : array) {
                int index = c - 'a';
                if (currentNode.children[index] == null) {
                    return Collections.emptyList();
                }
                // 将指针指向当前字符对应的节点
                currentNode = currentNode.children[index];
            }
            List<String> list = currentNode.allWords();
            return list.stream().map(e -> word.substring(0, word.length() - 1) + e).toList();
        }

        static class TrieNode {
            final TrieNode[] children = new TrieNode[26];
            boolean isWord;
            char value;

            public TrieNode() {
            }

            public TrieNode(char value) {
                this.value = value;
            }

            public List<String> allWords() {
                List<String> words = new ArrayList<>();
                append(words, "", this);
                return words;
            }

            private void append(List<String> list, String str, TrieNode node) {
                if (list.size() == 3) {
                    return;
                }
                str += node.value;
                if (node.isWord) {
                    list.add(str);
                    if (Arrays.stream(node.children).allMatch(Objects::isNull)) {
                        return;
                    }
                }
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        append(list, str, node.children[i]);
                    }
                }
            }
        }
    }
}
