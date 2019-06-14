#!/bin/bash

if [ ! -d log ]
then
    mkdir log
fi

processos_memoria() {

    processos=$(ps -e -o pid --sort -size | head -n 11 | grep [0-9])

    for pid in $processos
    do
        nome_processo=$(ps -p $pid -o comm=)
        alocacao_processo=$(ps -p $pid -o size | grep [0-9])
        data_processo=$(date +%F)
        hora_processo=$(date +%H:%M:%S)

        echo "$data_processo, $hora_processo, $(bc <<< "scale=2;$alocacao_processo/1024") MB" >> log/$nome_processo.log 
    done
}

processos_memoria 2>erros.txt
if [ $? -eq 0 ]
then
    echo "Os arquivos foram salvos com sucesso"
else
    echo "Houve um problema ao salvar os arquivos"
fi
