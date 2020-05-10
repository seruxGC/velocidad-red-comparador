# Comparador de velocidades de red

## Descripcion

Clase de utilidad para comparar velocidades de red. Las velocidades tienen que estar en el mismo formato para poder compararse.

 ###  Formato 1

 Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera: 
 
 "[\*]**{velocidadBajada}**[s]**{unidadBajada}**[\*]**{separador}**[\*]**{unidadSubida}**[s]**{unidadBajada}**[\*]"
 
 - **{velocidadBajada}** y **{velocidadSubida}** Son numeros enteros o decimales. En caso de ser decimales pueden usar comas o puntos. (obligatorio)
 
 -  **{unidadBajada} y {unidadSubida}** Puede tener un valor de 'Kbps', 'Mbps', 'Gbps', 'K', 'M' o 'G' . La unidad de subida y de bajada puede ser diferente (obligatorio)

 - **[separador]** Puede ser el carácter '-' o '/' (obligatorio)
 
  - [*] Puede ser cualquier literal o espacio en blanco (opcional)
  
 - [s] Puede ser un espacio en blanco (opcional)
  
**El regex que utiliza para identificar la velocidad en este formato es:** <br>

    .*?(\d+[\,\.]??\d*?)\s??(Kbps|Mbps|Gbps|K|M|G).*?(\/|\-).*?(\d+[\,\.]??\d?).??(Kbps|Mbps|Gbps|K|M|G).*

Ejemplos de velocidades en este formato:  
"[100Kbps-100Kbps]"
"1 Gbps - 2 Mbps"
"50G/50K"
"{1499 Mbps} - {1499 Mbps}"
"Acceso VPN IP 1000M-1000M"

Las combinaciones validas de este formato son muchas. Se puede probar diferentes variantes de este formato en:  https://regex101.com . El literal cumplira este formato si en los grupos 1 y 4 del regex están las velocidades, en los grupos 2 y 5 las unidades y en el grupo 3 el separador.

**Comparacion**
 
Devuelve  `true` si la velocidad **de bajada y subida** de la *velocidad1*  es mayor que la de la *velocidad2* y `false` en caso contrario.

Ejemplo:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/5G"); // true
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/10G"); // false
    
 Como el algoritmo que se utiliza para la comparación de las velocidades en este formato ignora los literales que no correspondan a la velocidad de la red se pueden comparar literales mientras la velocidad tenga este formato.
 
    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("VPN IP FTTH 2.0 [250Mbps-250Mbps]", "200M-200M"); // true
    
    comparador.compara("VPN IP 100 Gbps-1000 Gbps", "Adsl 200 Gbps-200 Gbps Fibra 2.0"); // false
 
 
 ###  Formato 2
 
Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera:

 "[cp]**{velocidad}**[s][separador][s]**{unidad}**[cf]"
 
- **{velocidad}** Es un numero entero o decimal En caso de ser decimales pueden usar comas o puntos. (obligatorio)

- **{unidad}** Puede tener un valor de ‘Kbps’, ‘Mbps’ o ‘Gbps’ (kilobits/segundo, megabits/segundo o gigabits/segundo) (obligatorio)

- [cp] Puede ser el caracter "[" o "{" (opcional)

- [s] Puede ser un espacio en blanco (opcional)

- [cf]  Puede ser el caracter "]" o "}" (opcional)

**El regex que utiliza para identificar la velocidad en este formato es:** <br>

    ^[\[,\{]?(\d+[\,\.]?\d*?)\s?\-?\s?(Kbps|Mbps|Gbps)[\},\]]?$

Ejemplos de velocidades en este formato:  
"[1.58-Mbps]"
"1001 - Kbps"
"15,5 Kbps"
"150Gbps"
{150 Gbps}

Las combinaciones validas de este formato son muchas. Se puede probar diferentes variantes de este formato en:  https://regex101.com . El literal cumplira este formato si en el grupo 1 está la velocidad y en el grupo 2 está la unidad.

**Comparacion**
Devuelve  `true` si la *velocidad1*  es mayor que la de la *velocidad2* y `false` en caso contrario.

Ejemplos:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("150 Mbps", "100 Mbps"); // True
    
    comparador.compara("1 Gbps", "500 Mbps); // true

	comparador.compara("{1Gbps}", "2 Gbps); // false

	comparador.compara("[1 Gbps]", "[1,5 Gbps]; // false
