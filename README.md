# Comparador de velocidades de red

**Descripcion**

Clase de utilidad para comparar velocidades en distintos formatos.

## Formatos reconocidos

  **Formato 1**

 Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera: <br> 
 "[numero][unidad][separador][numero][unidad]"
 
 - [numero] es un numero entero 
 - [unidad] literal que puede tener un valor de 'M' o 'G' (megabits o gigabits)
 - [separador] puede ser el carácter '-' o '/'

Ejemplos de velocidades válidas con este formato: <br>
"**100M-100M**" <br>
"**100G-100G**" <br>
"**100G/100M**" <br>
"**100M/100M**" <br>
"**100M-100M**" <br>
"Adsl **1G-1G**" <br>
"Adsl **10G/1G**" <br>
"Adsl **500M-500M** fibra oro" <br>

 En este formato se considera que la ***velocidad1*** es mayor que la ***velocidad2*** cuando la velocidad **de bajada y subida** **es mayor** que la de la ***velocidad2***.

Ejemplo:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/5G"); // True
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/10G"); // False
    
 Como el algoritmo que se utiliza para la comparacion de las velocidades en este formato ignora los literales que no correspondan a la velocidad de la red se pueden comparar literales ditintos siempre y cuando en ambos exista una velocidad representada con el formato  "[numero][unidad][separador][numero][unidad]".
 
     VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Acceso VPN IP FTTH 200 250M/250M", "200M-200M"); // True
    
    comparador.compara("Acceso VPN IP 100M/1000M", "Adsl 200M-200M Fibra 2.0"); // False
 
 
