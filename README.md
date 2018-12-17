# Activiti-bpmn
Trabalhando com o Activiti Engine

# Configurando aplicação
# Banco de dados

Se você tem o docker instalado na sua máquina siga os passos listada na seção de docker para subir a imagem para começar a trabalhar

Caso não esteja utilizando docker seguir com as seguintes configurações.
Ter o banco de dados de dua preferência instalado com as seguintes configurações.

Schema: activiti
port: 3306
username: root
password: activiti
host: localhost

# Docker

Para criar e subir o conatiner configurado para o aplicativo, execute a seguinte linha de comando.

docker run --name activiti -e MYSQL_ROOT_PASSWORD=activiti -e MYSQL_DATABASE=activiti -p 3306:3306 -v "/"seu diretorio de backup"/mysql:/var/www" mysql:5.7

# IDE Eclipse

Importe o projeto com Existing Maven Projects e configure o tomcat.






