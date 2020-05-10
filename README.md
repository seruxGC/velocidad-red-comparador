# Comparador de velocidades de red

## Descripcion

Clase de utilidad para comparar velocidades de red. Las velocidades tienen que estar en el mismo formato para poder compararse.

 ###  Formato 1

 Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera: 
 
 "[\*]**{velocidadBajada}**[s]**{unidad}**[\*]**{separador}**[\*]**{velocidadSubida}**[s]**{unidad}**[\*]"
 
 - {velocidadBajada} y {velocidadSubida} son numeros enteros o decimales. En caso de ser decimales pueden usar comas o puntos. (obligatorio)
 
 - [unidad] literal que puede tener un valor de 'Kbps', 'Mbps', 'Gbps','K', 'M' o 'G' (kilobits/segundo, megabits/segundo o gigabits/segundo)
 
  - [*] Puede ser cualquier literal o espacio en blanco (opcional)
  
 - [s] Puede ser cualquier literal o espacio en blanco (opcional)
  
 - [separador] puede ser el carácter '-' o '/' (obligatorio)

**El regex que utiliza para identificar la velocidad en este formato es:** <br>

    .*?(\d+[\,\.]??\d*?)\s??(Kbps|Mbps|Gbps|K|M|G).*?(\/|\-).*?(\d+[\,\.]??\d?).??(Kbps|Mbps|Gbps|K|M|G).*

Se puede probar diferentes variantes de este formato en:  https://regex101.com

**Comparacion**
 
 La comparacion considera que la ***velocidad1*** es mayor que la ***velocidad2*** cuando  **la velocidad de bajada y subida** **es mayor** que la de la ***velocidad2***.

Ejemplo:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/5G"); // True
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/10G"); // False
    
 Como el algoritmo que se utiliza para la comparacion de las velocidades en este formato ignora los literales que no correspondan a la velocidad de la red se pueden comparar literales mientras la velocidad tenga este formato.
 
     VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("VPN IP FTTH 2.0 [250Mbps-250Mbps]", "200M-200M"); // True
    
    comparador.compara("VPN IP 100 Gbps-1000 Gbps", "Adsl 200 Gbps-200 Gbps Fibra 2.0"); // False
 
 
 ###  Formato 2
 
Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera:
