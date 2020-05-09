# Comparador de velocidades de red
**Formatos reconocidos**

  **Formato 1**

 Cualquier literal que contenga una velocidad de red especificada en el siguiente formato: "[numero][unidad][separador][numero][unidad]"
 
 - [numero] es un numero entero 
 - [unidad] literal que puede tener un valor de 'M' o 'G' (megabits o gigabits)
 -  [separador] puede ser el carácter '-' o '/'

Ejemplos de velocidades válidas con este formato:
"**100M-100M**" 
"**100G-100G**" 
"**100G/100M**" 
"**100M/100M**"
"**100M-100M**"
"Adsl **1G-1G**"
"Adsl **10G/1G**"
"Adsl **500M-500M** fibra oro"

 En este formato se considera que la ***velocidad1*** es mayor que la ***velocidad2*** cuando la velocidad de bajada y subida de la ***velocidad1*** es mayor que la de la ***velocidad2***.

Ejemplo:

    VelocidadRedComparador comparador = new VelocidadRedComparador();
    
    comparador.compara("Adsl 10G/10G", "Adsl 5G/10G"); // True
