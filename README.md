# Comparador de velocidades de red

## Clase VelocidadSubidaBajada  

Compara velocidades de red que tengan el [Formato 1](https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-1).

#### Constructor 1  

VelocidadBajadaSubida (String  literalVelocidadRed)

    VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("VPN IP FTTH0 500Mbps-500Mbps");
    VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Fibra oro 1 Gbps - 500 Mbps");
    
#### Constructor 2   

VelocidadBajadaSubida (float velocidadBajada, UnidadVelocidad unidad, float velocidadSubida, UnidadVelocidad unidad)

    VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(500, UnidadVelocidad.MEGABITS_SEGUNDO, 500, UnidadVelocidad.MEGABITS_SEGUNDO);
    VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(1, UnidadVelocidad.GIGABITS_SEGUNDO, 500, UnidadVelocidad.MEGABITS_SEGUNDO);

#### Funciones de comparación (pendiente) 

## Clase VelocidadRed

Compara velocidades de red que tengan el [Formato 2](https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-2).

#### Constructor 1  

VelocidadRed (String  literalVelocidadRed)

    VelocidadRed velocidad1 = new VelocidadRed("500 Mbps");
    VelocidadRed velocidad2 = new VelocidadRed("1 Gbps");
    
#### Constructor 2   

VelocidadBajadaSubida (float velocidadBajada, UnidadVelocidad unidad)

    VelocidadRed velocidad1 = new VelocidadRed(500, UnidadVelocidad.MEGABITS_SEGUNDO);
    VelocidadRed velocidad2 = new VelocidadRed(1, UnidadVelocidad.GIGABITS_SEGUNDO);

#### Funciones de comparación  

	velocidad1.esIgual(velocidad2); // false
	velocidad1.esMayor(velocidad2); // false
	velocidad1.esMenor(velocidad2); // true
___
 
 ###  Formato 1

 Pertenece a este formato cualquier literal que contenga una velocidad de red especificada de la siguiente manera: 
 
 "[\*]**{velocidadBajada}**[s]**{unidadBajada}**[\*]**{separador}**[\*]**{unidadSubida}**[s]**{unidadBajada}**[\*]"
 
 - **{velocidadBajada}** y **{velocidadSubida}** Son numeros enteros o decimales. En caso de ser decimales pueden usar comas o puntos. (obligatorio)
 
 -  **{unidadBajada} y {unidadSubida}** Puede tener un valor de 'Kbps', 'Mbps', 'Gbps', 'K', 'M' o 'G' . La unidad de subida y de bajada puede ser diferente (obligatorio)

 - **[separador]** Puede ser el carácter '-' o '/' (obligatorio)
 
  - [*] Puede ser cualquier literal o espacio en blanco (opcional)
  
 - [s] Puede ser un espacio en blanco (opcional)
  
Ejemplos de velocidades en este formato:    <br>
"[100Kbps-100Kbps]"  <br>
"1 Gbps - 2 Mbps"  <br>
"50G/50K"  <br>
"{1499 Mbps} - {1499 Mbps}"  <br>
"Acceso VPN IP 1000M-1000M"  <br>

**El regex que utiliza para identificar la velocidad en este formato es:** <br>

    .*?(\d+[\,\.]??\d*?)\s??(Kbps|Mbps|Gbps|K|M|G).*?(\/|\-).*?(\d+[\,\.]??\d?)\s??(Kbps|Mbps|Gbps|K|M|G).*
    
Las combinaciones validas de este formato son muchas. Se puede probar diferentes variantes de este formato en:  https://regex101.com/r/Nq17H2/1 . El literal cumplira este formato si en los grupos 1 y 4 del regex están las velocidades, en los grupos 2 y 5 las unidades y en el grupo 3 el separador.
 
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

Ejemplos de velocidades en este formato:  <br>
"[1.58-Mbps]"  <br>
"1001 - Kbps"  <br>
"15,5 Kbps"  <br>
"150Gbps"  <br>
{150 Gbps}  

Las combinaciones validas de este formato son muchas. Se puede probar diferentes variantes de este formato en:  https://regex101.com/r/GcGdiJ/1 . El literal cumplira este formato si en el grupo 1 está la velocidad y en el grupo 2 está la unidad.


