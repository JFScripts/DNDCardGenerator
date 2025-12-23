public class GeradorHtml {

    // PARTE 1: O Cabeçalho com o CSS (Estilo)
    public static String pegarCabecalho() {
        return "<html><head><meta charset='UTF-8'>" +
               "<style>" +
               // Configura a página para A4 e remove margens da impressora
               "@page { size: A4; margin: 0; }" +
               "body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 20px; }" +
               
               // O container que segura todas as cartas juntas
               ".folha { display: flex; flex-wrap: wrap; gap: 10px; justify-content: start; }" +
               
               // O DESIGN DA CARTA (Tamanho padrão Magic/Pokemon: 63mm x 88mm)
               ".carta { " +
               "   width: 63mm; height: 88mm; " +
               "   border: 2px solid #333; border-radius: 8px; " +
               "   background-color: white; " +
               "   display: flex; flex-direction: column; " +
               "   overflow: hidden; box-shadow: 2px 2px 5px rgba(0,0,0,0.3); " +
               "   page-break-inside: avoid; " + // Evita cortar a carta no meio da folha
               "}" +

               // Cabeçalho da carta (Nome)
               ".cabecalho { background-color: #222; color: white; padding: 5px; text-align: center; }" +
               ".nome { font-weight: bold; font-size: 14px; display: block; }" +
               ".subtitulo { font-size: 10px; font-style: italic; color: #ccc; }" +

               // Linha de status (Tempo, Alcance, etc)
               ".status { background-color: #ddd; font-size: 9px; padding: 4px; border-bottom: 1px solid #999; text-align: center; font-weight: bold; }" +

               // Corpo do texto
               ".corpo { flex-grow: 1; padding: 8px; font-size: 11px; text-align: justify; overflow-y: auto; }" +

               // Rodapé (Niveis superiores)
               ".rodape { background-color: #eee; font-size: 9px; padding: 5px; border-top: 1px solid #ccc; font-style: italic; }" +
               
               "</style></head><body><div class='folha'>";
    }

    // PARTE 2: O Molde da Carta com os "Buracos" (Placeholders)
    // Os lugares onde tem {{NOME}} serão substituídos pelo seu Java
    public static String pegarMolde() {
        return "<div class='carta'>" +
               "  <div class='cabecalho'>" +
               "    <span class='nome'>{{NOME}}</span>" +
               "    <span class='subtitulo'>{{SUBTITULO}}</span>" +
               "  </div>" +
               "  <div class='status'>{{DADOS}}</div>" +
               "  <div class='corpo'>{{DESCRICAO}}</div>" +
               "  <div class='rodape'><b>Em Niveis Superiores:</b> {{NIVEIS}}</div>" +
               "</div>";
    }

    // PARTE 3: Fechar as tags
    public static String pegarRodape() {
        return "</div></body></html>";
    }
}