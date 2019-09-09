## Socket Calculator (Teste de Carga Single/Multi Thread)
Teste de carga de calculadora com sockets.<br>
A execução pode ser feita a partir de um servidor <i>Single Thread</i> ou um servidor <i>Multi Thread</i>.<br>
O cliente envia ao servidor uma requisição contendo operação (ADD, SUB, MULT e DIV), e dois números para serem usados nessa operação. O servidor retornará o resultado.<br>
Por se tratar de um teste de carga, o código atual criará 200 threads clientes, então a diferença entre os tempos de execução serão percebidas entre o servidor <i>Single Thread</i> e o servidor <i>Multi Thread</i>.

<p><b>EXEMPLO DE EXECUÇÃO</b><br>Single Thread<br>
Servidor: <code>java SingleServerAPI</code><br>
Cliente: <code>java ClientView</code></p>

<p><b>EXEMPLO DE EXECUÇÃO</b><br>Multi Thread<br>
Servidor: <code>java MultiServerAPI</code><br>
Cliente: <code>java ClientView</code></p>