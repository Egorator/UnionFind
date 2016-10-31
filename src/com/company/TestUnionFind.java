package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnionFind {

    @Test
    public void testConnectedFunc() {
        //TODO how can we test connected() if we require union() func to work properly for it, and how can we test
        //TODO union() func without checking it by connected() func? We need to assume that one of them at least
        //TODO works properly! [ASK]
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
    public void testWeighting() {
        //tests both "connected component #1 is bigger then #2" and "connected component #2 is bigger then #1"
        UnionFind unionFind = new UnionFind(6);
        unionFind.union(0, 1);
        unionFind.union(2, 3);//2 is root
        unionFind.union(3, 4);
        unionFind.union(0, 4);//connected component with 0 is smaller then one with 4
        assertEquals(2, unionFind.root(0));
        unionFind.union(5, 4);
        assertEquals(2, unionFind.root(5));
    }
}
