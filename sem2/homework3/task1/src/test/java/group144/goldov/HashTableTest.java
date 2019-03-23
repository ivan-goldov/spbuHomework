package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    public void countEmptyRowsTest() {
        HashFunction hashFunction = new PolynomialHash(1009);
        HashTable hashTable = new HashTable(hashFunction);
        hashTable.add("absdsad");
        assertEquals(1008, hashTable.countEmptyRows());
    }

    @Test
    public void isInTableTest() {
        HashFunction hashFunction = new PolynomialHash(1009);
        HashTable hashTable = new HashTable(hashFunction);
        hashTable.add("a");
        assertTrue(hashTable.isInTable("a"));
    }

    @Test
    public void removeTest() {
        HashFunction hashFunction = new PolynomialHash(1009);
        HashTable hashTable = new HashTable(hashFunction);
        hashTable.add("a");
        hashTable.remove("a");
        assertEquals(1009, hashTable.countEmptyRows());
    }

    @Test
    public void getLoadFactorTest() {
        HashFunction hashFunction = new PolynomialHash(1009);
        HashTable hashTable = new HashTable(hashFunction);
        hashTable.add("abcsasd");
        assertEquals(1.0/1009, hashTable.getLoadFactor());
    }
}