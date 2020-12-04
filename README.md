# spring-cloud-producer-rest

# Pré-requisito

O projeto usa o RabbitMQ

Podemos utilizar o RabbitMQ via Docker ou instalado diretamente no SO, aqui esta instruções para instalação via Docker.
Este procedimento foi realizado e testado no Ubuntu 19:10

Primeiro, atualize sua lista atual de pacotes:

`$sudo apt update`

Em seguida, instale alguns pacotes de pré-requisitos que permitem que o apt utilize pacotes via HTTPS:

`sudo apt install apt-transport-https ca-certificates curl software-properties-common`

Então adicione a chave GPG para o repositório oficial do Docker em seu sistema:

`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`

Adicione o repositório do Docker às fontes do APT:

`sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"`

A seguir, atualize o banco de dados de pacotes com os pacotes Docker do repositório recém adicionado:

`sudo apt update`

Certifique-se de que você irá instalar a partir do repositório do Docker em vez do repositório padrão do Ubuntu:

`apt-cache policy docker-ce`

Observe que o docker-ce não está instalado, mas o candidato para instalação é do repositório do Docker para o Ubuntu 18.04 (bionic) ou superior
Finalmente, instale o Docker:

`sudo apt install docker-ce`

O Docker agora deve ser instalado, o daemon iniciado e o processo ativado para iniciar na inicialização.
Verifique se ele está sendo executado:

`sudo systemctl status docker`

A saída deve ser semelhante à seguinte, mostrando que o serviço está ativo e executando:

`● docker.service - Docker Application Container Engine
    Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
    Active: active (running) since Tue 2019-12-03 20:39:41 -03; 13min ago
      Docs: https://docs.docker.com
  Main PID: 26134 (dockerd)
     Tasks: 32
    Memory: 233.1M
    CGroup: /system.slice/docker.service
            ├─26134 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
            ├─28362 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 15672 -container-ip 172.17.0.2 -container-port 15672
            └─28376 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 5672 -container-ip 172.17.0.2 -container-port 5672`

Para simplificar o uso do RabbitMQ, utilizaremos uma imagem docker do RabbitMQ, sendo necessário apenas executar o seguinte comando no terminal:

`docker run -d --hostname local-rabbit --name rabbit-mq -p 15672:15672 -p 5672:5672 rabbitmq:3.6.9-management`

Após execução desse comando, a imagem docker será baixada, caso seja a primeira vez que ela esteja sendo utilizada, e posteriormente o container será iniciado. Para verificar se o container está sendo executado, utilize o comando abaixo:

`docker ps`

Deverá ser exibido um log semelhante a este no console:

`CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS              PORTS                                                                                        NAMES
42261fde6345        rabbitmq:3.6.9-management   "docker-entrypoint.s…"   15 minutes ago      Up 15 minutes       4369/tcp, 5671/tcp, 0.0.0.0:5672->5672/tcp, 15671/tcp, 25672/tcp, 0.0.0.0:15672->15672/tcp   rabbit-mq`

Se tudo deu certo até agora, essa imagem docker do RabbitMQ também irá prover uma interface gráfica para utilização do message broker. Através do browser é possível acessar esta interface utilizando o seguinte endereço e credenciais:

`http://localhost:15672`

 `username: guest`
  
 `password: guest`
 
 Usando o postman para enviar a mensagem
  
 POST:
 
 `http://localhost:8093/product/process`

 Body:

`{
 	"name" : "Calçados",
 	"category" : "Categoria",
 	"value": "2.1",
 	"quantity": "1"
 }` 
 
 Referência:
 
 `https://medium.com/@jvoliveiran/spring-cloud-stream-simplificando-o-uso-de-message-broker-71f1731f5f5`
  
 `https://medium.com/@jvoliveiran/spring-cloud-stream-simplificando-o-uso-de-message-broker-parte-2-e82d02e1371c`
  
 Instalando o RabbitMQ direto no Ubuntu, ou seja, não utilizando o Docker
 Teste realizado no Ubuntu 19.10
 
 sudo apt-get install rabbitmq-server
 sudo systemctl enable rabbitmq-server
 sudo systemctl stop rabbitmq-server
 sudo systemctl start rabbitmq-server
 sudo rabbitmqctl add_user admin admin 
 sudo rabbitmqctl set_user_tags admin administrator
 sudo rabbitmqctl set_permissions -p / admin ".*" ".*" ".*"
 sudo rabbitmq-plugins enable rabbitmq_management
 RabbitMQ dashboard starts on port 15672
