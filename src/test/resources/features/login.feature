#language:pt
Funcionalidade: Login

  Contexto:
    Dado que a modal esteja aberta
  @fecharModal
  Cenario: fechar a modal quando clicar forada mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada
  @fecharModalIcone
  Cenario: fechar a modal ao clicar no icone fechar
    Quando realizado um clique no icone de fechar a modal
    Entao a janela modal deve ser fechada
  @createNewAccount
  Cenario: Link create New account
    Quando for realizado um clique no Link Create New Account
    Entao a pagina Create Account deve ser exibida
  @loginComSucesso
  Esquema do Cenario: Realizar Login com <cenario>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema
    Exemplos:
      | cenario             | login  | password | remember |
      | Campos Obrigatorios | Danilo | Senha1234    | False   |
      | todos os campos     | Danilo | Senha1234    | True    |

  @loginInvalido
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sitema deve exibir uma mensagem de erro
    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | senha1234    | remember |
      | senha invalido   | Danilo   | invaido  | remember |
  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado
    Exemplos:
      | identificacao     | login  | password | remember |
      | usuario em branco |        | senha    | false    |
      | senha em branco   | Danilo |          | false    |







