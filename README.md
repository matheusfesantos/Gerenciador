# MY STORE - Gerenciador de Compras 🛒

O **MY STORE** é um sistema desenvolvido em **Java** para gerenciar compras de um estabelecimento. Ele utiliza arquivos `.txt` para armazenar dados, processa compras com ajustes automáticos no estoque e exibe informações no terminal da IDE. Além disso, as informações de cada venda são mostradas na **Tela de Vendas**.

## Funcionalidades ⚙️

- Leitura de dados do estoque a partir de um arquivo `.txt` usando listas e o método `BufferedReader`.
- Controle automático de estoque após cada compra, ajustando a quantidade automaticamente.
- Exibição do status das ações no terminal para garantir que tudo esteja funcionando corretamente.
- **Tela de Vendas**: Após cada compra, as informações são exibidas na tela de vendas, incluindo o nome do produto, data da compra, quantidade adquirida e o valor total da compra.
- **Tela de Produtos**: Exibe todos os produtos disponíveis para compra, permitindo ao usuário visualizar o estoque e informações dos itens.
- **Tela de Adicionar Produtos**: Permite ao usuário adicionar novos produtos ao sistema, com dados como nome, quantidade e preço.
- **Tela Principal**: A tela inicial onde o usuário pode acessar todas as funcionalidades do sistema, como navegação para adicionar produtos, visualizar vendas e consultar estoque.

## Estrutura do Código 🛠️

### **Package `entities`**

A **package `entities`** contém as classes que automatizam o funcionamento do sistema, lidando com a leitura e manipulação de dados, além de enviar as informações para o front-end JavaFX. As principais classes dessa package são:

- **`Clientes`**: Esta classe é responsável por armazenar os dados dos clientes, processar as informações de vendas, e também por interagir com o arquivo `.txt` para ler e gravar as informações dos clientes.
- **`Produtos`**: A classe `Produtos` lida com o estoque de produtos, armazenando os dados dos produtos e realizando as atualizações no estoque com base nas compras. Ela também lê e envia os dados para o front-end JavaFX, exibindo os produtos disponíveis para compra.

Essas classes são essenciais para o funcionamento do sistema, pois fazem a ponte entre o armazenamento dos dados (em arquivos `.txt`) e a interface gráfica, enviando as informações necessárias para que o usuário interaja com o sistema através do **JavaFX**.

### **Package `application`**

A **package `application`** contém todas as telas e o **front-end** do sistema. Nessa package estão implementadas as interfaces gráficas do usuário, onde o sistema interage visualmente com o usuário, usando **JavaFX** para criar as janelas, botões, tabelas e outras interações.

As principais telas desta package são:

- **Tela Principal**: A tela inicial onde o usuário pode navegar para outras funcionalidades, como adicionar produtos, visualizar vendas ou consultar o estoque.
- **Tela de Adicionar Produtos**: Tela responsável por permitir que o usuário adicione novos produtos ao sistema, definindo o nome, quantidade e preço.
- **Tela de Produtos**: Exibe todos os produtos cadastrados no sistema, com informações detalhadas de cada item disponível.
- **Tela de Vendas**: Exibe as compras realizadas, com detalhes como o nome do produto, data da compra, quantidade e valor total. Cada venda é registrada e mostrada de forma clara para o usuário.
- **Venda Cliente**: Tela onde o cliente pode finalizar a compra, visualizando os itens selecionados e o valor total antes de finalizar a transação.

Essas telas foram implementadas utilizando **JavaFX**, o que permite criar uma interface gráfica moderna e interativa para o usuário.

### **Diretório `resources`**

O diretório **`resources`** armazena todos os **estilos da aplicação** e as **fotos** usadas para representar os produtos na interface gráfica. Este diretório é dividido em duas partes principais:

1. **Estilos (CSS)**: Os estilos da aplicação são organizados em arquivos CSS dentro deste diretório, onde são definidos todos os estilos visuais para as telas, botões, tabelas e outros componentes da interface gráfica. Esses arquivos são aplicados no front-end JavaFX para garantir uma interface consistente e agradável.
   
2. **Fotos de Produtos**: As imagens utilizadas para representar os produtos na interface do usuário também estão armazenadas no diretório **`resources`**. Cada produto pode ter uma imagem associada, que será exibida na tela de produtos e em outras áreas do sistema para proporcionar uma experiência visual mais rica ao usuário.

## Como Funciona 💡

- **Leitura dos Dados**: O sistema usa listas para armazenar os dados dos produtos e clientes lidos de arquivos `.txt`, utilizando `BufferedReader` para ler cada linha e armazenar as informações em memória.
- **Controle de Estoque**: A cada compra realizada, o sistema ajusta automaticamente a quantidade de estoque dos produtos. O controle é feito de forma dinâmica, utilizando o `BufferedReader` para reprocessar os dados sempre que necessário.
- **Exibição no Terminal**: Todas as ações realizadas, como a leitura dos dados, compras e ajustes no estoque, são exibidas no terminal da IDE. Isso permite verificar se o processo está sendo executado corretamente.
- **Tela de Vendas**: Ao realizar uma compra, as informações da venda (produto, data, quantidade e valor) são registradas e exibidas na tela de vendas, permitindo que o usuário acompanhe todas as transações realizadas.

## Telas do Sistema 🖥️

### Tela Principal
![Tela Principal](https://drive.google.com/uc?export=view&id=1den2k_hISj8odpxz8XRkRYD_ezafFK_w)

### Tela de Produtos
![Tela de Produtos](https://drive.google.com/uc?export=view&id=1baS_FjhrfzVs3QjQG-i2_6eKOBYMDCE_)

### Venda Cliente
![Venda Cliente](https://drive.google.com/uc?export=view&id=1XgHUcr5DC63_kdulWVNa50qC9OQ1YuLw)

### Adicionar Produtos
![Adicionar Produtos](https://drive.google.com/uc?export=view&id=1kk8nCk3cu2ZD-6rmdua62DphA0kcNSUE)

### Tela de Vendas
![Tela de Vendas](https://drive.google.com/uc?export=view&id=16OHdHQQA5OQOCPxO2enHYbShFKPlhSCP)

### Primeiro Design Imaginado para o MY STORE
![Primeiro Design](https://drive.google.com/uc?export=view&id=1fL_0oU0bkh4P1x6aoMwTAFvXXhjCwUWO)

## Tecnologias Utilizadas 🔨

- **Java**: Linguagem principal do projeto ☕.
- **JavaFX**: Para a criação da interface gráfica 🖥️.
- **CSS**: Para estilização da interface 🎨.
- **Arquivos .txt**: Utilizados como banco de dados simples para armazenamento e manipulação de informações 📁.

## Como Executar o Projeto 🚀

1. Clone este repositório:
   ```bash
   git clone https://github.com/matheusfesantos/gerenciador-java.git
   ```
2. Importe o projeto em sua IDE de preferência (Eclipse, IntelliJ, etc.) ⚙️.
3. Certifique-se de que o JavaFX esteja configurado corretamente em seu ambiente ⚡.
4. Execute o arquivo principal da aplicação ▶️.

## 💼 **Créditos**

- **👨‍💻 Desenvolvedor**: Matheus Ferreira  
- **🌐 Contato GitHub**: [matheusfesantos](https://github.com/matheusfesantos)  
- **📧 Email**: theucontatos@gmail.com
