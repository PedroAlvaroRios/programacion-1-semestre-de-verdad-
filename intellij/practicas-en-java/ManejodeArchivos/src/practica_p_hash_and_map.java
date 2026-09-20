/*
* 1. ¿Qué es un Map?
Un Map (o "mapa") es una estructura de datos que guarda pares clave-valor.
Piensa en él como un diccionario: para cada clave única, tienes asociado un valor.
Las claves no pueden duplicarse (si insertas la misma clave otra vez, el valor anterior se sobrescribe).
Los valores sí pueden repetirse. esto mas o menos es como funciona un SQL o PHP

Ejemplo conceptual:

Clave: código de materia → Valor: nombre de la materia
"101" → "Matemáticas"
"202" → "Programación"

Clave: DNI → Valor: nombre de persona
"12345678" → "María"
"87654321" → "Carlos"

La interfaz principal en Java es java.util.Map<K, V>, donde K es el tipo de la clave y V el tipo del valor.

Métodos más importantes de Map:

put(K clave, V valor) – agrega o actualiza un par.

get(K clave) – devuelve el valor asociado, o null si no existe.

getOrDefault(K clave, V valorPorDefecto) – como get, pero si no encuentra la clave devuelve valorPorDefecto.

containsKey(K clave) – true si la clave existe.

remove(K clave) – elimina el par.

keySet() – devuelve todas las claves.

values() – devuelve todos los valores.

size() – cantidad de pares.
* */


/*

🗄️ 2. Implementaciones de Map
Java ofrece varias implementaciones, cada una con sus ventajas:

Implementación	Orden	Permite null en claves	Eficiencia típica
HashMap	Sin orden fijo	Sí (una clave null)	O(1) promedio en get/put
LinkedHashMap	Orden de inserción (o acceso)	Sí	O(1) promedio (con lista enlazada)
TreeMap	Orden natural de las claves (o Comparator)	No	O(log n) en get/put (árbol rojo-negro)
La más usada es HashMap porque es muy rápida y no requiere orden.

🔍 3. ¿Cómo funciona internamente un HashMap?
La idea básica: usar una función hash para convertir la clave en un índice entero, y guardar el par en un arreglo de "cubetas" (buckets).

3.1 Estructura interna (simplificada)
Un HashMap mantiene un arreglo de nodos (cada nodo es un par clave-valor + puntero al siguiente). Al insertar una clave:

Calcula el hash code de la clave usando clave.hashCode().

Aplica una función de dispersión para convertirlo en un índice del arreglo:
índice = hash & (n - 1) donde n es la capacidad del arreglo (potencia de 2).

En esa posición del arreglo, se almacena el nodo. Si ya había otro nodo (colisión), se añade a una lista enlazada en esa cubeta.
A partir de Java 8, si la lista se vuelve larga (más de 8 elementos),
se convierte en un árbol rojo-negro para mejorar el rendimiento de búsqueda en colisiones extremas.

3.2 Operación put(K, V)
Calcula el índice a partir de la clave.

Si no hay ningún nodo en esa posición, se crea uno nuevo.

Si ya hay nodos, recorre la lista (o árbol) de esa cubeta comparando las claves con equals(). Si encuentra una clave igual,
reemplaza el valor. Si no, añade el nuevo nodo al final.

Si después de insertar, el número de elementos supera el "factor de carga" (por defecto 0.75) multiplicado por la capacidad,
se redimensiona el arreglo (se duplica la capacidad y se reubican todos los nodos).

3.3 Operación get(K)
Calcula el índice con la misma función hash.

Recorre la cubeta correspondiente comparando las claves con equals().

Si encuentra una clave igual, devuelve el valor; si no, null.

Por eso es importante que las clases usadas como clave implementen bien hashCode() y equals().
Dos objetos iguales (equals true) deben tener el mismo hashCode.

*/

/*🧪 4. Ejemplo de uso en código*/


import java.util.HashMap;
import java.util.Map;

public class practica_p_hash_and_map {
    public static void main(String[] args) {
        // Crear un mapa de String (código) a String (materia)
        Map<String, String> materias = new HashMap<>();

        // Agregar elementos
        materias.put("101", "Matemáticas");
        materias.put("202", "Programación");
        materias.put("303", "Física");

        // Obtener un valor
        String nombre = materias.get("202");           // "Programación"
        String inexistente = materias.get("999");      // null
        // Usar valor por defecto
        String segura = materias.getOrDefault("999", "Sin asignar");

        // Verificar si existe una clave
        if (materias.containsKey("101")) {
            System.out.println("101 ya está registrada");
        }

        // Recorrer todas las claves
        for (String codigo : materias.keySet()) {
            System.out.println(codigo + " -> " + materias.get(codigo));
        }

        // Recorrer pares directamente con entrySet()
        for (Map.Entry<String, String> entrada : materias.entrySet()) {
            System.out.println(entrada.getKey() + " = " + entrada.getValue());
        }

        // Tamaño
        System.out.println("Total materias: " + materias.size());
    }
}


/*
🤔 5. ¿Por qué se usa un HashMap en tu ejercicio de estudiantes?
En tu código:
*/

//  Map<String, String> mapaMaterias = new HashMap<>();

/*

Cargas cada línea del archivo Materias.txt con split(",") y guardas código -> nombre.

Luego, cuando lees un estudiante, obtienes su códigoMat y haces:

*/

//  String nombreMat = mapaMaterias.getOrDefault(codigoMat, "Desconocida");

/*

Esta búsqueda es instantánea (O(1) en promedio). Si en vez de un mapa hubieras usado un arreglo o lista, tendrías que recorrer todas las materias para encontrar el código, lo que sería más lento.

🔁 6. Comparación rápida con arreglo bidimensional
En tu mente podrías simular un mapa con un arreglo de dos columnas, como:

*/

// String[][] catalogo = { {"101","Matemáticas"}, {"202","Programación"} };

/*

Para buscar el nombre dado un código, necesitarías:

*/

/*

String buscarNombre(String codigo) {
    for (String[] fila : catalogo) {
        if (fila[0].equals(codigo)) return fila[1];
    }
    return "Desconocida";
}

*/

/*

Esto funciona, pero es más lento si hay muchas materias (O(n)). El HashMap lo hace en tiempo casi constante.

💡 Resumen
Map: colección de pares clave-valor, claves únicas.

HashMap: implementación más rápida, sin orden, permite un null en clave.

Internamente: usa un arreglo de cubetas indexado por el hash de la clave; colisiones se resuelven con listas/árboles.

Uso típico: asociar identificadores con datos, como relacionar código de materia con su nombre.

¿Te gustaría que profundice en algún aspecto, como hashCode() y equals(), o el redimensionamiento automático? Solo avísame.

*/