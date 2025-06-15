package com.kanechan.cachelru_01;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRU<K, V> {

    private final int capacidade;
    private final Map<K, V> cache;

    public CacheLRU(int capacidade) {
        this.capacidade = capacidade;
        this.cache = new LinkedHashMap<K, V>(capacidade, 0.75f, true) {
        	private static final long serialVersionUID = 1L;
        	
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                boolean remover = size() > CacheLRU.this.capacidade;
                if (remover) {
                    System.out.println("[LRU] Removendo elemento menos usado: " + eldest.getKey() + " -> " + eldest.getValue());
                }
                return remover;
            }
        };
        System.out.println("[INIT] Cache LRU criada com capacidade máxima: " + capacidade);
    }

    public void put(K key, V value) {
        cache.put(key, value);
        System.out.println("[PUT] Inserido: " + key + " -> " + value);
        System.out.println("[CACHE] Estado atual: " + cache);
    }

    public V get(K key) {
        V value = cache.get(key);
        System.out.println("[GET] Acessando chave: " + key + " -> " + (value != null ? value : "null"));
        System.out.println("[CACHE] Estado atual: " + cache);
        return value;
    }

    public void remove(K key) {
        if (cache.containsKey(key)) {
            V removed = cache.remove(key);
            System.out.println("[REMOVE] Removido: " + key + " -> " + removed);
        } else {
            System.out.println("[REMOVE] Chave não encontrada: " + key);
        }
        System.out.println("[CACHE] Estado atual: " + cache);
    }

    public int size() {
        int tamanho = cache.size();
        System.out.println("[SIZE] Tamanho atual da cache: " + tamanho);
        return tamanho;
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
