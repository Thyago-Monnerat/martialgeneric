![image](https://th.bing.com/th/id/OIP.lwDa90HV9bdav2987iyL6QHaHa?w=200&h=200&rs=1&pid=ImgDetMain)

# Gerenciamento de alunos e eventos
#### Projeto feito para prototipar um sistema de gerência de alunos para uma academia de Taekwondo
----
  
Este projeto é um esboço do sistema que venho trabalhando, sendo um campo de treinamento para reforçar o aprendizado na linguagem Java.

Consiste em uma tabela de alunos, uma de eventos e uma relação entre elas, a Registration.
Um aluno pode estar em 0..* eventos, assim como um evento pode ter 0..* alunos. Essa abordagem de associação demandou uma lógica mais aprimorada no mapeamento com JPA.

Também utilizei de queries SQL mais aprofundadas no RegistrationRepository, retornando uma tabela unida com JOIN de alunos e eventos.

Utilizei Mappers para conversão de Model em DTO e vice-versa, eliminando essa lógica da própria classe, assim, obedecendo o Príncipio de Responsabilidade Única (Single-responbility principle - A letra S dos príncipios SOLID).

Outra coisa interessante nesse projeto, foi o uso de Projections para mapear os dados retornados pelas consultas personalizadas.

---

### Endpoints
/students
~~~
    /getAll
        Retorna todos os alunos

    /get/{id}
        Retorna um aluno

    /create
       Cria um aluno com base no payload

    /update/{id}
        Atualiza o aluno com base no id e dados vindo no payload

    /delete/{id}
        Deleta um aluno com base no id
~~~
/events
~~~
    /getAll
        Retorna todos os eventos

    /get/{id}
        Retorna um evento

    /create
       Cria um evento com base no payload

    /update/{id}
        Atualiza o evento com base no id e dados vindo no payload

    /delete/{id}
        Deleta um evento com base no id
~~~
/Registration
~~~
    /getAll
        Retorna todas as associações de alunos e eventos

    /get/user/{id}
        Retorna uma associação com base no id do aluno

    /create
       Cria uma associação de aluno e evento com base no payload


    /delete
        Deleta uma associação com base no payload
~~~

### No mais, é isso ❤️

Tecnologias usadas:
~~~
    - Java 17
    - Maven
    - Spring Boot
    - Spring Web
    - Spring JPA
    - H2
    - Lombok
~~~
