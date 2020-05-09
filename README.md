# Comparador de velocidades de red

## Descripcion

Clase de utilidad para comparar velocidades de red. Las velocidades tienen que estar en el mismo formato para poder compararse.

## Resumen de formatos reconocidos

- Formato 1: **"[numero][unidad][separador][numero][unidad]"** Ejemplos:  "100M-100M"  , "50G/50G"  ,  "50M-50G" ,  "Fibra Adsl 10G-5G" , "[4G-4G]" , {30M/30M}
- Formato 2: **"[numero] [unidad]"** Ejemplos:  "40 Kbps"  "10 Kbps"  "1 Gbps"  "2,5 Gbps"   "2.5 Gbps"

 ##  Formato 1
 
 Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera: <br> 
 "[velocidadBajada][unidad][separador][velocidadSubida][unidad]"
 
 - [velocidadBajada] y  [velocidadSubida] son un numeros entero 
 - [unidad] literal que puede tener un valor de 'Mbps', 'Gbps', 'M' o 'G' (megabits o gigabits)
 - [separador] puede ser el carácter '-' o '/'

El regex que utiliza para identificar la velocidad en este formato es: <br>
(\d+).??(Mbps|Gbps|M|G).*?(\/|\-).*?(\d+).??(Mbps|Gbps|M|G)

Se puede probar en: <br>
(https://regex101.com/)

 En este formato se considera que la ***velocidad1*** es mayor que la ***velocidad2*** cuando la velocidad **de bajada y subida** **es mayor** que la de la ***velocidad2***.

Ejemplo:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/5G"); // True
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/10G"); // False
    
 Como el algoritmo que se utiliza para la comparacion de las velocidades en este formato ignora los literales que no correspondan a la velocidad de la red se pueden comparar literales mientras la velocidad tenga este formato.
 
     VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Acceso VPN IP FTTH 200 250M/250M", "200M-200M"); // True
    
    comparador.compara("Acceso VPN IP 100M/1000M", "Adsl 200M-200M Fibra 2.0"); // False
 
 
 ##  Formato 2
