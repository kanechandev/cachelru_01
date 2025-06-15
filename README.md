# 🧠 CacheLRU - Java

Este projeto contém uma implementação simples e eficiente de uma estrutura de dados **LRU Cache (Least Recently Used)** em Java, com foco em regras de negócio, cobertura de casos extremos e testes unitários.

---

## 📦 Funcionalidades da classe `CacheLRU`

- Inserção de pares chave-valor com `put(K key, V value)`
- Recuperação de valores com `get(K key)`
- Remoção com `remove(K key)`
- Consulta ao tamanho atual com `size()`
- Política LRU para remoção automática de itens menos acessados quando a capacidade é atingida

---

## 🧪 Testes Unitários

Os testes foram desenvolvidos com **JUnit 5**, seguindo boas práticas de isolamento, reprodutibilidade e clareza de cenários. As validações incluem:

- Inserções e acessos simples
- Sobrescrita de chave
- Remoção de chave existente e inexistente
- Capacidade mínima (1 elemento)
- Validação da lógica LRU por ordem de acesso
- Comportamento defensivo ao buscar chaves ausentes
- Verificação da política de remoção ao estourar capacidade

Todos os testes estão localizados em `CacheLRUTest.java`.

---

## 🛠️ Como rodar os testes

1. Certifique-se de ter o JDK 17+ instalado.
2. Clone o projeto.
3. Compile com Maven:

```bash
mvn compile
```

4. Execute os testes com:

```bash
mvn test
```

---

## 📝 Exemplo de uso

```java
CacheLRU<Integer, String> cache = new CacheLRU<>(2);
cache.put(1, "Valor A");
cache.put(2, "Valor B");
cache.get(1); // "Valor A"
cache.put(3, "Valor C"); // Remove o 2 (menos recentemente usado)
```

---

## 🧠 Motivação

LRU Caches são frequentemente usadas em:

- Cache de autenticação/token
- Cache de configurações
- Controle de sessões
- Limitação de chamadas (rate limiting)

Esse projeto demonstra domínio de estrutura de dados, atenção a tolerância a falhas e construção de testes de qualidade.

---

## ✍️ Autor

**Kane San Chan**  
Desenvolvedor Java e entusiasta de boas práticas de arquitetura, qualidade de código e documentação de APIs.

---

## 📄 Licença

Este projeto está sob a licença MIT. Você pode usá-lo, modificá-lo e distribuí-lo conforme desejar.
