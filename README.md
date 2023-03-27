# Sistema de Gestão de Salas de Aula em Java com Interface Gráfica em Swing

Este projeto é uma reimplementação do Sistema de Gestão de Salas de Aula desenvolvido em C++ como parte da disciplina de Programação Orientada a Objetos lecionada na Universidade Federal de Ouro Preto - UFOP. O objetivo do projeto foi implementar um sistema de gestão de salas de aula em Java, utilizando a biblioteca gráfica Swing para construir a interface do usuário.

O sistema possui as mesmas funcionalidades da versão em C++, permitindo o cadastro de alunos, professores, gestores, cursos e salas de aula, bem como a visualização, atualização e exclusão dos dados cadastrados. No entanto, a interface gráfica em Swing proporciona uma experiência mais intuitiva e agradável ao usuário, com menus e janelas organizadas de forma clara e simples.

O sistema permite o cadastro de alunos, professores, gestores, cursos e salas de aula, com informações como nome, telefone, CPF e curso. Além disso, os gestores possuem login e senha para acesso ao sistema definidor como `admin` por padrão. O cadastro de cursos e professores é feito de forma que cada curso só possa ser designado para um professor.

Os gestores têm acesso ao sistema para inserir, visualizar, atualizar e excluir dados. Os alunos e professores podem acessar o sistema sem login e senha, mas só podem visualizar informações e não têm acesso a dados pessoais. Por exemplo, os professores podem visualizar a sala reservada para o curso, e os alunos matriculados. Os alunos podem visualizar o curso que ocorrerá em cada sala e o professor que ministrará o curso.

A implementação do sistema em Java com interface gráfica em Swing torna possível gerenciar de forma mais eficiente a alocação das salas de aula, bem como o controle das informações de alunos, professores e gestores. Para desenvolver a aplicação, foram utilizados conceitos de programação orientada a objetos, tais como a definição de classes e objetos, encapsulamento de informações, herança e polimorfismo


## Como Executar

Para executar o sistema, é necessário ter o `Java Development Kit (JDK)` instalado em seu computador. Após isso, basta compilar os arquivos e executar o arquivo Main.java presente no diretório src do projeto. A partir da interface gráfica em Swing, é possível acessar todas as funcionalidades do sistema.

**Caso haja alguma dependência faltando, é necessário instalar antes de compilar o programa.**

É importante destacar que o programa foi desenvolvido e testado em um ambiente Windows, portanto, o processo de compilação e execução pode variar em outros sistemas operacionais.

Para compilar o codigo digite o seguinte no terminal: `javac -d bin src/*.java`. O codigo ao lado irá gerar uma pasta chamada "bin" no diretorio com todos os arquivos .class. Para compilar o programa digite a seguinte linha de cógigo no terminal `java -cp bin Main`.

```
javac -d bin src/*.java

java -cp bin Main
```

Representação simples dos menus:
![Menu Image](https://i.imgur.com/XGxpDCu.png "Classroom Manager CRUD")

# Funcionalidades

O sistema possui diversas funcionalidades que permitem uma gestão completa das salas de aula. Dentre elas, destacam-se:

## Cadastro de Dados

O sistema permite o cadastro de diferentes tipos de dados, como alunos, professores, gestores, cursos e salas de aula. Cada um desses cadastros é realizado de forma independente e requer informações específicas.

## Consulta de Dados

É possível visualizar os dados cadastrados em todas as categorias. Os gestores possuem acesso total às informações, enquanto os alunos e professores possuem acesso apenas a algumas informações limitadas.

## Edição de Dados

Caso seja necessário atualizar alguma informação, o sistema permite a edição dos dados cadastrados. Para tanto, é necessário possuir acesso de gestor e fazer login no sistema.

## Exclusão de Dados

Caso seja necessário remover algum dado cadastrado, o sistema permite a exclusão dos mesmos. Apenas gestores têm permissão para realizar esta ação.

Em resumo, o sistema permite uma gestão completa das salas de aula e de seus integrantes, permitindo que gestores, professores e alunos possam acompanhar informações importantes relacionadas aos cursos e salas de aula.

    - Gerenciamento completo das salas de aula e seus integrantes;
    
    - Cadastro de alunos, professores, gestores, cursos e salas de aula;
    
    - Consulta de dados cadastrados;
    
    - Edição de dados cadastrados;
    
    - Exclusão de dados cadastrados;
    
    - Acompanhamento de informações importantes pelos gestores, professores e alunos, relacionadas aos cursos e salas de aula.


## Licença

Este projeto é licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
[MIT License](./LICENSE)
