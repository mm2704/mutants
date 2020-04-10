# mutants

El proyecto esta desarrollado en Java 8. Se utilizó Maven para el packaging y dependencias, SpringBoot para la creacion de la API rest, Lombok y Apache Commons.
El war esta subido a Elastic Beanstalk, utilizando una base de datos DynamoDB.

Para las credenciasles de AWS, mandarme un mail a martinmanuel2704@gmail.com

URL de API:
http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com

#Servicios

#Es mutante:
Para saber si un ADN es mutante, consumir el servicio POST http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com/mutant/ con body:
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

##Resultados:
Mutante -> 200-OK
Humano ->  403-FORBIDDEN


Stats:
Para conocer la cantidad de humanos, mutantes y su ratio, consumir el servicio GET http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com/stats

Resultado:
JSON -> {“count_mutant_dna”:40, “count_human_dna”:100, “ratio”:0.4}




