## Non-Blocking Chat
O chat não bloqueante consiste em criar um loop dentro do cliente
para que a conexão não seja perdida até que ele resolva cancelar
a comunicação, e então, fechar o socket, além do servidor
possuir a capacidade de continuar recebendo conexções paralelas.<p>

Na implementação desse programa, o servidor cria uma thread para
cada conexão recebida, e então fica na espera de receber novas
mensagens.

<b>Exemplo de execução:</b><p>
Servidor: <code>java ChatServer "PORT" </code><p>
Cliente: <code> java ChatClient "SERVER" "PORT"
