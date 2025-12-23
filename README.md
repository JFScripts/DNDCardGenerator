# 🃏 Gerador de Cartas de RPG
> Uma ferramenta desenvolvida para transformar textos brutos em cartas de RPG personalizadas (estilo D&D/Magic), prontas para impressão.

## 📖 A História por trás do Projeto

Este projeto nasceu de uma necessidade real na minha mesa de RPG.

Como Mestre, percebi que meus jogadores (e eu mesmo) perdíamos muito tempo consultando livros ou folhas de papel bagunçadas para ler os detalhes de magias e habilidades durante o combate. Eu queria oferecer a experiência tátil e prática de ter **cartas físicas** na mesa, facilitando a gestão de recursos.

Porém, formatar carta por carta manualmente em editores de imagem era exaustivo e difícil de padronizar. Decidi então **automatizar esse processo**.

Uni o útil ao agradável:
- **O Problema:** A necessidade de agilidade e organização nas sessões de D&D.
- **A Solução:** Um software capaz de ler dados simples e gerar um layout HTML/CSS profissional automaticamente.
- **O Aprendizado:** Aprofundar meus conhecimentos em Java, focando em manipulação de arquivos (*File I/O*), Streams e Arquitetura de Software (Separação de Responsabilidades).

---

## 🎨 Exemplos Gerados
Aqui estão alguns exemplos de cartas geradas pelo sistema para os personagens da campanha.

<div align="center">
  <img src="assets\Cartas Luria.png" alt="Carta da Luria" width="200"/>
  <img src="assets\Cartas Qarr.png" alt="Carta do Qarr" width="200"/>
  <img src="assets\Cartas Audin.png" alt="Carta do Audin" width="200"/>
  <img src="assets\Cartas Sylkie.png" alt="Carta da Sylkie" width="200"/>
</div>

> *As cartas são geradas em HTML e CSS puro, permitindo fácil customização visual.*

---

## 🛠️ Funcionalidades

- **Fábrica de Cartas:** Interface via terminal para criação rápida de Magias, Armas ou Habilidades.
- **Persistência de Dados:** Salva e lê as cartas automaticamente em um arquivo de texto (`magias.txt`), funcionando como um banco de dados leve.
- **Exportação Visual:** Gera um arquivo `cartas.html` formatado com CSS embutido (tamanho padrão de cartas TCG: 63mm x 88mm).
- **Formatação Inteligente:** Lida com quebras de linha, negrito e layouts automaticamente.
- **Execução Automática:** Abre o navegador padrão com as cartas prontas ao finalizar a geração.

---

## 🚀 Como usar

### Pré-requisitos
- Ter o **Java (JDK)** instalado na máquina.

### Passo a Passo
1. Clone este repositório ou baixe os arquivos.
2. Compile e execute a classe principal `Main.java`.
3. No menu do terminal, você terá as opções:
   - **[1] Criar Cartas:** Digite os dados da magia/item conforme solicitado.
   - **[2] Gerar HTML:** O programa lê o banco de dados e cria o arquivo visual.
4. O navegador abrirá automaticamente com o arquivo `cartas.html`.
5. Pressione `CTRL + P` para imprimir.
   - **Importante:** Nas configurações de impressão, marque a opção **"Gráficos de plano de fundo"** para que as bordas e cores apareçam.

---

## 📦 Tecnologias Utilizadas
- **Java:** Lógica principal, `Scanner`, `FileWriter`, `PrintWriter` (Streams).
- **HTML5 & CSS3:** Estrutura e estilização visual das cartas.
- **Git:** Controle de versão.

---

## 📝 Estrutura do Projeto
O código foi refatorado para seguir o princípio de responsabilidade única:
- `Main.java`: Gerencia o fluxo do programa e o menu.
- `GeradorDeArquivo.java`: Cuida da leitura e escrita no "banco de dados" (`.txt`).
- `GeradorHtml.java`: "Fábrica" que contém os moldes (templates) e o CSS para montar a visualização final.

---
