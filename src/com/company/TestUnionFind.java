package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnionFind {

    @Test
    public void testConnectedFunc() {
        UnionFind unionFind = new UnionFind(2);
        unionFind.union(0, 1);
        assertTrue(unionFind.connected(1, 0));
    }

    @Test
    public void testFindFunc() {
        //tests both "connected element is new max" and "connected element is not max"
        UnionFind unionFind = new UnionFind(4);
        unionFind.union(1, 0);//1 will be root
        unionFind.union(0, 3);//connects max element
        assertEquals(3, unionFind.find(0));
        unionFind.union(0, 2);//connects not max element
        assertEquals(3, unionFind.find(0));
    }

    @Test
    public void noSenseBigFuckingTest() {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(4, 3);
        assertEquals(4, unionFind.find(3));
        assertTrue(unionFind.connected(3, 4));

        unionFind.union(3, 8);
        assertEquals(8, unionFind.find(3));
        assertTrue(unionFind.connected(3, 8));

        unionFind.union(6, 5);
        assertEquals(6, unionFind.find(6));
        assertTrue(unionFind.connected(6, 5));

        unionFind.union(9, 4);
        assertEquals(9, unionFind.find(4));
        assertTrue(unionFind.connected(8, 9));

        unionFind.union(2, 1);
        assertEquals(2, unionFind.find(2));
        assertTrue(unionFind.connected(1, 2));

        unionFind.union(5, 0);
        assertEquals(6, unionFind.find(5));
        assertTrue(unionFind.connected(0, 5));

        unionFind.union(7, 2);
        assertEquals(7, unionFind.find(1));
        assertTrue(unionFind.connected(1, 7));

        unionFind.union(6, 1);
        assertEquals(7, unionFind.find(1));
        assertTrue(unionFind.connected(5, 1));

        unionFind.union(7, 3);
        assertEquals(9, unionFind.find(0));
        assertTrue(unionFind.connected(5, 3));
    }

    @Test
    public void totalSuperTest() {
        UnionFind unionFind = new UnionFind(5);
        assertTrue(unionFind.connected(0, 0));
        assertFalse(unionFind.connected(0, 1));
        assertFalse(unionFind.connected(0, 2));
        assertFalse(unionFind.connected(0, 3));
        assertFalse(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 1));
        assertFalse(unionFind.connected(1, 2));
        assertFalse(unionFind.connected(1, 3));
        assertFalse(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 2));
        assertFalse(unionFind.connected(2, 3));
        assertFalse(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 3));
        assertFalse(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(4, 4));

        assertEquals(0, unionFind.find(0));
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        //

        unionFind.union(0, 1);

        assertTrue(unionFind.connected(0, 0));
        assertTrue(unionFind.connected(0, 1));
        assertFalse(unionFind.connected(0, 2));
        assertFalse(unionFind.connected(0, 3));
        assertFalse(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 1));
        assertFalse(unionFind.connected(1, 2));
        assertFalse(unionFind.connected(1, 3));
        assertFalse(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 2));
        assertFalse(unionFind.connected(2, 3));
        assertFalse(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 3));
        assertFalse(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(4, 4));

        assertEquals(1, unionFind.find(0));
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        //

        unionFind.union(1, 2);

        assertTrue(unionFind.connected(0, 0));
        assertTrue(unionFind.connected(0, 1));
        assertTrue(unionFind.connected(0, 2));
        assertFalse(unionFind.connected(0, 3));
        assertFalse(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 1));
        assertTrue(unionFind.connected(1, 2));
        assertFalse(unionFind.connected(1, 3));
        assertFalse(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 2));
        assertFalse(unionFind.connected(2, 3));
        assertFalse(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 3));
        assertFalse(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(4, 4));

        assertEquals(2, unionFind.find(0));
        assertEquals(2, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        //

        unionFind.union(4, 3);

        assertTrue(unionFind.connected(0, 0));
        assertTrue(unionFind.connected(0, 1));
        assertTrue(unionFind.connected(0, 2));
        assertFalse(unionFind.connected(0, 3));
        assertFalse(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 1));
        assertTrue(unionFind.connected(1, 2));
        assertFalse(unionFind.connected(1, 3));
        assertFalse(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 2));
        assertFalse(unionFind.connected(2, 3));
        assertFalse(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 3));
        assertTrue(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(4, 4));

        assertEquals(2, unionFind.find(0));
        assertEquals(2, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(4, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        //

        unionFind.union(4, 0);

        assertTrue(unionFind.connected(0, 0));
        assertTrue(unionFind.connected(0, 1));
        assertTrue(unionFind.connected(0, 2));
        assertTrue(unionFind.connected(0, 3));
        assertTrue(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 1));
        assertTrue(unionFind.connected(1, 2));
        assertTrue(unionFind.connected(1, 3));
        assertTrue(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 2));
        assertTrue(unionFind.connected(2, 3));
        assertTrue(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 3));
        assertTrue(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(4, 4));

        assertEquals(4, unionFind.find(0));
        assertEquals(4, unionFind.find(1));
        assertEquals(4, unionFind.find(2));
        assertEquals(4, unionFind.find(3));
        assertEquals(4, unionFind.find(4));
    }

}
