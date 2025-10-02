public class ChadQuestRPG {
    public static void main(String[] args) {
        
        //Primera parte:
        
        int[] puntosPorMision = new int[5];
        int total = 0;

        puntosPorMision[0] = 50;
        puntosPorMision[1] = 80;
        puntosPorMision[2] = 60;

        for (int i = 0; i < 3; i++) {
        total += puntosPorMision[i];
        }

        System.out.println("Puntos acumulados hasta ahora: " + total);

        //Segunda parte:
        /*
         * 1. Completar el array y calcular el total de puntos:
            ● Cargar los puntos de la misión 4 y misión 5. Pueden ser valores fijos
            ● Pueden ser valores fijos.
            ● Recorrer todo el array y sumar los puntos.
         */

        puntosPorMision[3] = 70;
        puntosPorMision[4] = 90;
        
        for (int i = 3; i < 5; i++) {
        total += puntosPorMision[i];
        }

        System.out.println("Puntos acumulados hasta ahora: " + total);

        /*
         * 2. Determinar si el jugador es un Chad:
            Si tiene más de 300 puntos, mostrar:
            ● "¡Felicidades! Sos un verdadero Chad del RPG 🎯"
            Si no, mostrar:
            ● "Te falta entrenamiento, joven aprendiz..."
         */

        String mensajeChad = ( total > 300 ) ? "¡Felicidades! Sos un verdadero Chad del RPG" : "Te falta entrenamiento, joven aprendiz...";
        System.out.println(mensajeChad);   

         /*
         * 3. Encontrar la misión con más puntos:
            ● Recorrer el array y detectar cuál es la misión con mayor puntaje.
            ● Imprimir algo como:
                ○ "Tu mejor desempeño fue en la misión 2 con 85 puntos."

         */
        
        int puntajeMayor = puntosPorMision[0];
        int posicionMision = 1;
        
        for (int i = 1; i < puntosPorMision.length; i++) {
            if (puntosPorMision[i] > puntajeMayor) {
                puntajeMayor = puntosPorMision[i];
                posicionMision = i + 1;
            }
        }

        System.out.println("Tu mejor desempeño fue en la misión " + posicionMision + " con " + puntajeMayor + " puntos.");    
        
         /*
         * 4. Verificar si hay alguna misión fallida:
            ● Una misión se considera fallida si obtuvo 0 puntos.
            ● Si hay alguna, mostrar:
                ○ "Fallaste al menos una misión. Que el backend te tenga piedad..."
         */

        for (int i = 0; i < puntosPorMision.length; i++) {
            if (puntosPorMision[i] == 0) {
                System.out.println("Fallaste al menos una misión. Que el backend te tenga piedad...");
                break;
            }
        }

         /*
         * 5. Determinar si fue constante:
            ● Si la diferencia entre la misión con más puntos y la de menor puntaje es menor a 20,
            se considera constante.
            ● Mostrar mensaje:
                ○ "¡Ejecución constante! Sos el sueño de un arquitecto de software."

         */

        int puntajeMenor = puntosPorMision[0];
        int posicionMisionMenor = 1;

        for (int i = 1; i < puntosPorMision.length; i++) {
            if (puntosPorMision[i] < puntajeMenor) {
                puntajeMenor = puntosPorMision[i];
                posicionMisionMenor = i + 1;
            }
        }    

        if( (puntajeMayor - puntajeMenor) < 20 ) {
            System.out.println("¡Ejecución constante! Sos el sueño de un arquitecto de software.");
        }

         /*
         * 6. Casi terminamos:
            ● Contar cuántas misiones superaron los 75 puntos.
            ● Si son al menos 3, mostrar:
                ○ "Nivel desbloqueado: Mini Stone Chad"
         */

        int contadorMisiones = 0;
        for (int i = 0; i < puntosPorMision.length; i++) {
            if (puntosPorMision[i] > 75) {
                contadorMisiones++;
            }
        }
        
        System.out.println("Cantidad de misiones que superaron los 75 puntos: " + contadorMisiones);

        if (contadorMisiones >= 3) {
            System.out.println("Nivel desbloqueado: Mini Stone Chad");
        }

         /*
         * 7. Muestra de resultados (Tabla de puntuación final):
            ● Mostrar un encabezado en donde se listen la misión, el puntaje, el puntaje
            acumulado y luego el total final
         */
        
        System.out.println("\n\t **************************************************** ");
        System.out.println("\n\t TOTALES FINALES ");
        System.out.println("\n\t **************************************************** ");


        System.out.printf("%-40s%-30s%-30s%-30s%n", "MISIÓN", "PUNTAJE", "PUNTAJE ACUMULADO", "TOTAL FINAL");
        int puntajeAcumulado = 0;
        for (int i = 0; i < puntosPorMision.length; i++) {
            puntajeAcumulado = puntajeAcumulado + puntosPorMision[i];
            System.out.printf("%-40d%-30d%-30d%-30s%n", 
            i+1,
            puntosPorMision[i],
            puntajeAcumulado,
            (i == puntosPorMision.length - 1) ? "\t" + total : ""
            );
        }
    } 
}