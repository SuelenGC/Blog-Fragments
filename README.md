Post-Fragments
==============

Código usado no post <b><a href="http://suelengc.com.br/blog/?p=360">Android - Usando o poder da API Fragments</a></b> no meu <a href="http://suelengc.com.br/blog/">blog</a>. Segue um excerto do post que resume o problema resolvido com este código:

É bem comum criarmos um app que tenha um menu com vários botões e cada botão inicie uma nova funcionalidade. Normalmente, por questões de adequação ao espaço disponível em cada device, esperamos que o comportamento deste app seja diferente se aberto em um Smartphone ou Tablet.

No Smartphone o que costuma ocorrer é de o menu ocupar toda a tela inicial e ao clicar em um item, o novo conteúdo se sobrepõe ao menu, ficando visível somente o conteúdo novo.

Já em um Tablet espera-se que o conteúdo do menu fique na lateral esquerda e que o conteúdo de cada item seja aberto na lateral direita, mantendo tanto menu como funcionalidade visível na mesma tela. Veja as imagens abaixo que demonstram esta situação.

No Smartphone esperamos algo assim:

<img src="http://suelengc.com.br/blog/wp-content/uploads/2013/04/smartphone.png" width="300" height="244" />

No Tablet esperamos algo assim:

<img src="http://suelengc.com.br/blog/wp-content/uploads/2013/04/tablet.png" width="300" height="181" />
