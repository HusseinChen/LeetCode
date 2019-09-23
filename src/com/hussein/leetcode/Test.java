package com.hussein.leetcode;

import java.util.Set;

public class Test<T> {

    private Set<T> set;

    public Set<T> get() {
        return this.set;
    }

    public Test(Set<T> set) {
        this.set = set;
    }

    public static void main(String[] args) {
        System.out.println(Math.round(0.99 * 10));
    }
}
