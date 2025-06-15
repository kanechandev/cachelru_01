package com.kanechan.cachelru_01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para a implementação CacheLRU.
 * Os testes validam comportamento esperado, bordas e política de remoção LRU.
 */
class CacheLRUTest {

    // Testa inserção e recuperação de dados básicos
    @Test
    void testPutAndGet() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "A");
        cache.put(2, "B");

        assertEquals("A", cache.get(1));
        assertEquals("B", cache.get(2));
    }

    // Testa a política de remoção LRU com base na ordem de acesso
    @Test
    void testEvictionByAccessOrder() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        // Acessa 1 e 2; 3 se torna o menos recentemente usado
        cache.get(1);
        cache.get(2);

        // Ao adicionar o 4, a chave 3 deve ser removida
        cache.put(4, "D");

        assertNull(cache.get(3));
        assertEquals("A", cache.get(1));
        assertEquals("B", cache.get(2));
        assertEquals("D", cache.get(4));
    }

    // Testa sobrescrita de valor para uma chave já existente
    @Test
    void testOverwriteKey() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "A");
        cache.put(1, "B");

        assertEquals("B", cache.get(1));
        assertEquals(1, cache.size());
    }

    // Testa remoção de chave existente
    @Test
    void testRemove() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "A");
        cache.remove(1);

        assertNull(cache.get(1));
        assertEquals(0, cache.size());
    }

    // Testa remoção de chave inexistente (deve ser inofensiva)
    @Test
    void testRemoveNonExistentKey() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "A");
        cache.remove(2);

        assertEquals(1, cache.size());
        assertEquals("A", cache.get(1));
    }

    // Testa o método size()
    @Test
    void testSize() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);
        cache.put(1, "A");
        cache.put(2, "B");

        assertEquals(2, cache.size());
    }

    // Testa comportamento com capacidade mínima de 1
    @Test
    void testSingleElementCache() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(1);
        cache.put(1, "A");
        cache.put(2, "B"); // deve remover o primeiro

        assertNull(cache.get(1));
        assertEquals("B", cache.get(2));
    }

    // Testa leitura de chave inexistente na cache (deve retornar null)
    @Test
    void testGetFromEmptyCacheReturnsNull() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        assertNull(cache.get(42));
    }
}
