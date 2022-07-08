#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "leticia@south.com.br"
    E a senha "leticia"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar

  Esquema do Cenário: Deve validar regras cadastro contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem>"
    Exemplos:
      | conta          | mensagem                      |
      | Conta de Teste | Conta adicionada com sucesso! |

  Esquema do Cenário: Deve validar regras cadastro contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem insufiente "<mensagem>"
    Exemplos:
      | conta | mensagem                |
      |       | Informe o nome da conta |

  Esquema do Cenário: Deve validar regras cadastro contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem ja cadastrado "<mensagem>"
    Exemplos:
      | conta          | mensagem                           |
      | Conta de Teste | Já existe uma conta com esse nome! |

