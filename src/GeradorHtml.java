public class GeradorHtml {

    public static String pegarCabecalho() {
        return "<html><head><meta charset='UTF-8'>" +
               "<style>" +
               "@page { size: A4; margin: 0; }" +
               "body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 20px; }" +
               
               ".folha { display: flex; flex-wrap: wrap; gap: 10px; justify-content: start; }" +
               
               ".carta { " +
               "   width: 63mm; height: 88mm; " +
               "   border: 2px solid #333; border-radius: 8px; " +
               "   background-color: white; " +
               "   display: flex; flex-direction: column; " +
               "   overflow: hidden; box-shadow: 2px 2px 5px rgba(0,0,0,0.3); " +
               "   page-break-inside: avoid; " +
               "   cursor: grab; " + 
               "}" +


               ".carta:active { cursor: grabbing; }" +
               ".fantasma { opacity: 0.4; background-color: #c8ebfb; border: 2px dashed #000; }" +

               ".cabecalho { background-color: #222; color: white; padding: 5px; text-align: center; }" +
               ".nome { font-weight: bold; font-size: 14px; display: block; }" +
               ".subtitulo { font-size: 10px; font-style: italic; color: #ccc; }" +
               ".status { background-color: #ddd; font-size: 9px; padding: 4px; border-bottom: 1px solid #999; text-align: center; font-weight: bold; }" +
               ".corpo { flex-grow: 1; padding: 8px; font-size: 11px; text-align: justify; overflow-y: auto; }" +
               ".rodape { background-color: #eee; font-size: 9px; padding: 5px; border-top: 1px solid #ccc; font-style: italic; }" +
               
               "</style></head><body><div class='folha'>";
    }

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

    public static String pegarRodape() {
        return "</div>" + 
               

               "<script src='https://cdnjs.cloudflare.com/ajax/libs/Sortable/1.14.0/Sortable.min.js'></script>" +
               "<script>" +
               "  var container = document.querySelector('.folha');" +
               "  new Sortable(container, { animation: 150, ghostClass: 'fantasma' });" +
               "</script>" +
               
               "</body></html>";
    }
}