# mutants

El proyecto esta desarrollado en Java 8. Se utilizó Maven para el packaging y dependencias, SpringBoot para la creacion de la API rest, Lombok y Apache Commons.<br/>
El war esta subido a Elastic Beanstalk, utilizando una base de datos DynamoDB.

Para levantar el proyecto localmente, se debe correr la clase App para inciar SpringBoot. La base esta configurada en el proyecto, por lo que no deberia haber problemas de conectividad. <br/>
Para las credenciasles de AWS, mandarme un mail a martinmanuel2704@gmail.com<br/>

## URL de API:
http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com

# Servicios

## Es mutante:
Para saber si un ADN es mutante, consumir el servicio POST http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com/mutant/ con body:<br/>
{<br/>
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]<br/>
}<br/><br/>

El servicio solo contara como mutantes, las cadenas de letras que contengan A,T,C,G.<br/>

### Resultados:
Mutante -> 200-OK <br/>
Humano ->  403-FORBIDDEN


## Stats:
Para conocer la cantidad de humanos, mutantes y su ratio, consumir el servicio GET http://mutants-env.eba-3rq7bcub.sa-east-1.elasticbeanstalk.com/stats

### Resultado:
JSON -> {“count_mutant_dna”:40, “count_human_dna”:100, “ratio”:0.4}




