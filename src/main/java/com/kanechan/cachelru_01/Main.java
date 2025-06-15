package com.kanechan.cachelru_01;

public class Main {
    public static void main(String[] args) {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.get(1);
        cache.put(3, "C"); // deve remover B
        cache.get(2);      // null
        cache.get(1);      // A
        cache.remove(1);   // remove A
        cache.size();      // deve imprimir tamanho atual
    }
}
