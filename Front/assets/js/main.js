document.addEventListener('DOMContentLoaded', function () {
    // Função para gerar botões dinamicamente
    function generateButtons(containerId, buttonCount) {
      var container = document.getElementById(containerId);
      for (var i = 1; i <= buttonCount; i++) {
        var button = document.createElement('button');
        button.textContent = 'lista' + i;
        container.appendChild(button);
      }
    }
  
    // Chamando a função para cada seção
    generateButtons('mono', 2);
    generateButtons('duo', 3);
    generateButtons('three', 3);
    generateButtons('four', 3);
    generateButtons('five', 3);
  });