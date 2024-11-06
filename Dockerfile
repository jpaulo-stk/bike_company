# Usar a imagem oficial do MySQL como base
FROM mysql:8.0

# Copiar o script SQL para o diretório de inicialização
COPY db/init.sql /docker-entrypoint-initdb.d/