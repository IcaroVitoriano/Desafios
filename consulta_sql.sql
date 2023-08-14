SELECT e.id, e.name, AVG(s.value) AS average_salary
FROM employee e
JOIN salary s ON e.id = s.employee_id
WHERE s.payment_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
GROUP BY e.id, e.name
ORDER BY average_salary DESC
LIMIT 3;

#SELECT e.id, e.name, AVG(s.value) AS average_salary: Aqui, estamos definindo os campos que queremos selecionar na consulta. e.id e e.name são os campos
#da tabela employee que representam o ID e o nome do funcionário, respectivamente. AVG(s.value) é uma função de agregação que calcula a média dos valores 
#da coluna value da tabela salary. Estamos renomeando essa média como average_salary para facilitar a referência posteriormente.
#FROM employee e: Aqui, estamos definindo a fonte da nossa consulta, que é a tabela employee. Estamos usando o alias e para referenciar
#a tabela employee ao longo da consulta.
#JOIN salary s ON e.id = s.employee_id: Esta é a cláusula que define a junção entre as tabelas employee (representada pelo alias e) e
#salary (representada pelo alias s). Estamos juntando essas tabelas usando a condição de que o campo id da tabela employee deve ser igual
#ao campo employee_id da tabela salary. Isso nos permite combinar as informações dos funcionários com os seus salários correspondentes.
#WHERE s.payment_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH): Aqui, estamos aplicando um filtro para garantir que só sejam considerados os 
#salários que foram pagos nos últimos 3 meses. NOW() retorna a data e hora atuais, e DATE_SUB() é usado para subtrair um intervalo de tempo. 
#Nesse caso, estamos subtraindo 3 meses da data atual para obter a data limite a partir da qual queremos considerar os salários.
#GROUP BY e.id, e.name: Esta cláusula indica como os resultados devem ser agrupados. Estamos agrupando os resultados com base nos campos 
#id e name da tabela employee. Isso significa que a média salarial será calculada para cada funcionário individualmente.
#ORDER BY average_salary DESC: Esta cláusula especifica a ordem em que os resultados devem ser apresentados. Estamos ordenando os resultados
#com base na média salarial (average_salary) em ordem decrescente (DESC), ou seja, do maior salário médio para o menor.
#LIMIT 3: Por fim, estamos limitando o número de resultados retornados para apenas 3 registros. Isso significa que a consulta retornará apenas 
#as três melhores médias salariais.
#Em resumo, essa consulta SQL retorna os IDs, nomes e médias salariais dos três funcionários com as maiores médias salariais nos últimos três meses, 
#com base nas informações das tabelas employee e salary.
