# Aprendendo RabbitMQ

RabbitMQ é um software de mensageria que trabalha com enfileiramento e troca de mensagens entre processos, aplicativos
e servidores de forma assíncrona. 

RabbitMQ é amplamente utilizado ao ser trabalhar com mensagens em protocolos AMQP

##### Rodando RabbitMQ
Antes de subir os app de producer e consumer em alguma IDE de sua escolha rode o serviço de RabbitMQ com docker 
no script abaixo.
```
$ ./ rabbitmq-run.sh
```
O que esse script faz: 
 - pull do rabbitmq:3-management no dockerhub;
 - abre as portas 15672 e 5672(15672 para acesso do browser e 5672 para comunicação de api e servidor amqp);
 - define usuario e senha de acesso ao serviço (Login:user/senha:password);

##### Acesso via browser
 Acessando o browser na porta localhost:15672 e digitar login e senha:
 
 ![login-browser](images/login-browser.png)
 
 Teremos acesso aos diversos recursos e métricas que o rabbitmq dispõe como queues, exchanges, routers, métricas 
 e entre outros:
 
![metricas-rabbit](images/metricas-rabbit.png)
 
## Como funciona
O envio e consumo de mensagens no rabbitmq consiste em um producer e um consumer. Basicamente funciona da seguinte forma:
 - Mensagem: algum dado podendo ser json, xml e até stream;
 - Producer: alguma aplicação envia a mensagem para o serviço;
 - Exchange: recebe a mensagem e encaminha para uma queue baseando-se nas regras defindas pelo tipo de exchange;
 - Queue: armazena mensagens vindas das exchanges até que seja consumida;
 - Consumer: Aplicação fica escutando nas queue buscando mensagens e processando-as;

![flow-basic](images/flow-rabbitmq.png)


