# cadmus-prova
Prova Técnica da Cadmus 07/07/2015

A prova foi feita usando Maven e Java 7. Pode-se alterar o valor para Java 8 para isso alterar o POM.xml no plugin maven-compiler-plugin.

A resposta para o problema 2 - Conjectura de Collatz - para a pergunta "Qual inteiro positivo abaixo de 1 milhão, produz a sequência com mais itens?" é: 837799

Não me preocupei em fazer validação da entrada nem tratamento avançado de exceções ou logs. O foco foi resolver os problemas propostos.

Todos os três problemas estão no mesmo projeto porém com uma divisão por pacotes para maior organização.

O projeto possui testes unitarios e todos eles estão exibindo mensagens tratadas para simples inspeção das informações. 

O framework de testes é o J-Unit.