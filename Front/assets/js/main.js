// Exemplo de dados recebidos do servidor
//---------------------------------------
const serverResponse = [
  {
    "Color": "Mono",
    "Name": "Mono-Green",
    "Cards": [
      {"Name": "Nome1", "Qtd": 2},
      {"Name": "Nome2", "Qtd": 1},
      {"Name": "Nome3", "Qtd": 2},
      {"Name": "Nome4", "Qtd": 4},
      {"Name": "Nome5", "Qtd": 5},
      {"Name": "Nome6", "Qtd": 2}
    ]
  }
];
//---------------------------------------

function createObjectsFromServerResponse(response) {
  return response.map(item => {
    return {
      Color: item.Color,
      Name: item.Name,
      Cards: item.Cards.map(card => ({
        Name: card.Name,
        Qtd: card.Qtd
      }))
    };
  });
}

document.addEventListener('DOMContentLoaded', function () {
  // Função para gerar botões dinamicamente
  function generateButtons(containerId, buttonCount) {
    var container = document.getElementById(containerId);
    for (var i = 1; i <= buttonCount; i++) {
      var button = document.createElement('button');
      button.textContent = 'lista' + i;
      button.id = containerId + i;
      container.appendChild(button);

      // Adiciona um ouvinte de clique para cada botão
      button.addEventListener('click', function () {
        // Chama a função passando o ID do botão
        handleButtonClick(this.id);
      });
    }
  }

  function generateList() {
    
    // URL do endpoint
    const endpointURL = 'https://exemplo.com/api/dados';

    // Opções da requisição
    const requestOptions = {
      method: 'GET', // Método da requisição 
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json', 
      }
    };

    // Realiza a requisição usando fetch
    fetch(endpointURL, requestOptions)
      .then(response => {
        // Verifica se a requisição foi bem-sucedida (status code 2xx)
        if (!response.ok) {
          throw new Error(`Erro na requisição: ${response.status}`);
        }
   
        return createObjectsFromServerResponse(response.json());
      })
      .then(data => {
        // Manipula os dados recebidos
        console.log('Dados recebidos:', data);
      })
      .catch(error => {
        // Manipula erros durante a requisição
        console.error('Erro durante a requisição:', error);
      });
  }

// Função para gerar e baixar o arquivo de texto
function downloadTxtFile(data) {
  data.forEach(item => {
    const filename = `${item.Name.replace(/\s/g, '_').toLowerCase()}.txt`;
    let content = '';

    // Itera sobre os objetos e formata o conteúdo do arquivo
    content += `${item.Cards.map(card => `${card.Qtd} ${card.Name}`).join('\n')}\n\n`;

    // Cria um link para download
    const blob = new Blob([content], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    link.download = filename;

    // Simula um clique no link para iniciar o download
    link.click();
  });
}

  // Função para lidar com o clique nos botões
  function handleButtonClick(buttonId) {
    // Exemplo: Imprimir o ID do botão no console
    console.log('Botão clicado:', buttonId);

    const structuredData = createObjectsFromServerResponse(serverResponse);//generateList();

    downloadTxtFile(structuredData);
  }

 

  // Chamando a função para cada seção
  generateButtons('mono', 2);
  generateButtons('duo', 3);
  generateButtons('three', 3);
  generateButtons('four', 3);
  generateButtons('five', 3);
});


