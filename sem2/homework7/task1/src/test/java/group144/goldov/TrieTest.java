package group144.goldov;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    @Test
    public void validAddTest() {
        Trie trie = new Trie();
        assertTrue(trie.add("aaa"));
    }
    @Test
    public void invalidAddTest() {
        Trie trie = new Trie();
        trie.add("aaa");
        assertFalse(trie.add("aaa"));
    }

    @Test
    public void validRemoveTest() {
        Trie trie = new Trie();
        trie.add("aaa");
        assertTrue(trie.remove("aaa"));
    }

    @Test
    public void invalidRemoveTest() {
        Trie trie = new Trie();
        trie.add("aaa");
        assertFalse(trie.remove("aab"));
    }

    @Test
    public void emptyHowManyPrefixTest() {
        Trie trie = new Trie();
        trie.add("aaa");
        trie.add("aac");
        trie.add("aab");
        trie.add("aad");
        assertEquals(0, trie.howManyStartWithPrefix("b"));
    }

    @Test
    public void howManyStartWithPrefixTest() {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("abaaas");
        trie.add("bcd");
        trie.add("baaas");
        trie.add("baaasyadsf");
        trie.add("baaasasdasdf");
        trie.add("baaasasfdasdf");
        trie.add("baaasadsfasdf");
        trie.add("baaasasdfsaf");
        trie.add("baaasasdasd");
        trie.add("baaasadsadsad");
        trie.add("baaasadsadsd");
        trie.add("baaasadsads");
        trie.add("baaasasdad");
        trie.add("baaaspppp");
        trie.add("baaasqqqqq");
        trie.add("baaasasdasdzzz");
        trie.add("baaasmnnnijfk");
        trie.add("baaasmnnnnbnbnnbnbnzzzl");
        trie.add("baaasmnnnouououunfjfjfjf");
        trie.add("baaasmnnnakkkkkkkkb");
        trie.add("baaasmnnnbzbzbbzbz");
        trie.add("baaasmnnnuu");
        trie.add("baaasmnnnalsdl");
        trie.add("baaasmnnnmbmbmbmbmbm");
        trie.add("baaasmnnnqrrkkkkk");
        trie.add("baaasmnnnjqjqjqjqjqjq");
        trie.add("baaasmnnnhhghghghg");
        trie.add("baaasmnnnaaqpppppmm");
        trie.add("baaasmnnnooooooofuufuf");
        trie.add("baaasmnnnkkkk");
        trie.add("baaasmnnnasdsad");
        trie.add("baaasmnnna");
        trie.add("baaasmnnnb");
        assertEquals(31, trie.howManyStartWithPrefix("baaas"));
    }

    @Test
    public void serialisationTest() throws IOException {
        Trie trie = new Trie();
        trie.add("a");
        trie.add("b");
        trie.add("c");
        trie.add("d");
        trie.add("e");
        String file = "test.txt";
        trie.serialise(new FileOutputStream(new File(file)));
        FileInputStream input = new FileInputStream(new File(file));
        trie.deserialise(input);
        assertEquals(5, trie.getSize());
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("b"));
        assertTrue(trie.contains("c"));
        assertTrue(trie.contains("d"));
        assertTrue(trie.contains("e"));

    }
}