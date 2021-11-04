Feature: Acessar o site e preencher os campos com dados corretos e aleatorios

  Scenario: Preencher campos com sucesso e realizar uma cotacao
    Given que usuario acessa o site sampleapp tricentis
    And preenche o formulario de veiculo
    And preenche o formulario de seguro
    And preenche o formulario de produto
    And preenche o formulario de preco
    And preenche o formulario de cotacao
    When clica em Send
    Then mensagem Sending e-mail success! eh exibida 