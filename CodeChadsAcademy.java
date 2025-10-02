public class CodeChadsAcademy {
    public static void main(String[] args) {
        
        //Primera parte:
        /*
         * El estudiante debe rendir 5 exámenes. Los primeros 3 puntajes ya están disponibles, pero los dos últimos se deben calcular automáticamente:

            Si la nota 2 fue menor a 60, la nota 4 será 100 (porque hizo un trabajo práctico extra). Si fue mayor a 60 entonces la nota 4 será igual a la nota 2.
            Si la suma de las notas 1 y 3 supera 150, la nota 5 será 95, sino 70.

         */

        int[] puntosPorExamen = new int[5];
        int total = 0;

        puntosPorExamen[0] = 50;
        puntosPorExamen[1] = 80;
        puntosPorExamen[2] = 60;
        puntosPorExamen[3] = (puntosPorExamen[1] < 60) ? 100 : puntosPorExamen[1];
        puntosPorExamen[4] = ( (puntosPorExamen[0] + puntosPorExamen[2]) > 150 ) ? 95 : 70;

        //Segunda parte:
        /*
         * Teniendo ya precargados los valores de las primeros 5 examenes, continua el flujo : 
         */

        /*
         * 1. Verificar si aprobó todas:
            Una nota es aprobada si es mayor o igual a 60. Mostrar si el alumno aprobó todas, ninguna o algunas.
                "Resultado: Aprobaste todas. ¡Backend Sensei!"
                "Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!"
                "Resultado: Algunas aprobadas. Sos un refactor en progreso."
         */

        int cantidadAprobadas = 0;
        for (int i = 0; i < puntosPorExamen.length; i++) {
            if (puntosPorExamen[i] >= 60) {
                cantidadAprobadas++;
            }
        }
        String mensajeAprobacion;
        if (cantidadAprobadas == 5) {
            mensajeAprobacion = "Resultado: Aprobaste todas. ¡Backend Sensei!";
        } else if (cantidadAprobadas == 0) {
            mensajeAprobacion = "Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!";
        } else {
            mensajeAprobacion = "Resultado: Algunas aprobadas. Sos un refactor en progreso.";
        }
        
        System.out.println(mensajeAprobacion);   


        /*
         * 2. Prueba mas inconsistente:
            Detectar cuál fue la mayor variación entre dos pruebas consecutivas y en qué lugar ocurrió.
            "Mayor salto fue de 35 puntos entre la prueba 2 y la prueba 3."
         */

        int mayorVariacion = puntosPorExamen[1] - puntosPorExamen[0]; 
        int posicionPrueba = 0;

        for (int i = 1; i < puntosPorExamen.length - 1; i++) {
            int variacionActual = Math.abs(puntosPorExamen[i + 1] - puntosPorExamen[i]);
            if (variacionActual > mayorVariacion) {
                mayorVariacion = variacionActual;
                posicionPrueba = i;
            }
        }
        
        System.out.println("Mayor salto fue de " + mayorVariacion + " puntos entre la prueba " + (posicionPrueba + 1)+ " y la prueba " + (posicionPrueba + 2) + "." );

        /*
         * 3. Bonus por progreso:
             Si el alumno mejora su nota en cada prueba respecto a la anterior, mostrar:
            "¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈"
         */

        boolean esProgresivo = true;
        for (int i = 0; i < puntosPorExamen.length - 1; i++) {
            if (puntosPorExamen[i] >= puntosPorExamen[i + 1]) {
                esProgresivo = false;
                break;
            }
        }
        if (esProgresivo) {
            System.out.println("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈");
        }

        /*
         * 4. Mostrar notas ordenadas (sin usar sort):
            Imprimí las notas ordenadas de mayor a menor sin usar Arrays.sort()
         */

        System.out.print("Notas ordenadas de mayor a menor: ");
        for (int i = 100; i >= 0; i--) {
            for (int j = 0; j < puntosPorExamen.length; j++) {
                if (puntosPorExamen[j] == i) {
                    System.out.print("Nota " + j + ": " + i + ", ") ;
                }
            }
        }

        /*
         * 5. Evaluación final por nivel:
            Según el total acumulado, mostrar un rango personalizado:

            Total < 250 → "Normie total 😢"
            250–349 → "Soft Chad"
            350–449 → "Chad"
            450+ → "Stone Chad definitivo 💪"
         */

        total = 0;
        for (int i = 0; i < puntosPorExamen.length; i++) {
            total += puntosPorExamen[i];
        }

        String mensajeFinal;
        if (total < 250) {
            mensajeFinal = "Normie total 😢";
        } else if (total < 350) {
            mensajeFinal = "Soft Chad";
        } else if (total < 450) {
            mensajeFinal = "Chad";
        } else {
            mensajeFinal = "Stone Chad definitivo 💪";
        }
        
        System.out.println("\nEvaluación final: " + mensajeFinal + " con un total de " + total + " puntos.");
            

        /*
         * 6. (Desafío final) Ranking entre varios alumnos:
            Simulá una clase con 4 estudiantes, cada uno con sus 5 notas. Mostrá:

            Qué estudiante obtuvo el promedio más alto
            Cuál fue el más regular (menor desviación entre notas).
            Quién tuvo el peor rendimiento en la tercera prueba.

         */

        int[][] notasEstudiantes = {
            {50, 80, 60, 100, 70}, // Estudiante 1
            {60, 70, 80, 90, 100}, // Estudiante 2
            {90, 85, 80, 75, 70}, // Estudiante 3
            {40, 50, 65, 70, 80}  // Estudiante 4
        };

        int estudianteMejorPromedio = -1;
        double mejorPromedio = 0;
        int peorPuntajeTerceraPrueba = Integer.MAX_VALUE;
        int menorDiferencia = Integer.MAX_VALUE;
        int estudianteMasRegular = -1;
        int estudiantePeorTerceraPrueba = -1;

        for (int i = 0; i < notasEstudiantes.length; i++) {
            int sumaNotas = 0;
            int notaMax = notasEstudiantes[i][0];
            int notaMin = notasEstudiantes[i][0];
            for (int j = 0; j < notasEstudiantes[i].length; j++) {
                sumaNotas += notasEstudiantes[i][j];
            }

            double promedio = (double) sumaNotas / notasEstudiantes[i].length;
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                estudianteMejorPromedio = i + 1;
            }

            for (int j = 0; j < notasEstudiantes[i].length; j++) {
                sumaNotas += notasEstudiantes[i][j];
                if (notasEstudiantes[i][j] > notaMax) notaMax = notasEstudiantes[i][j];
                if (notasEstudiantes[i][j] < notaMin) notaMin = notasEstudiantes[i][j];
            }
            
            int diferencia = notaMax - notaMin;
            if (diferencia < menorDiferencia) {
                menorDiferencia = diferencia;
                estudianteMasRegular = i + 1;
            }
            
            if (notasEstudiantes[i][2] < peorPuntajeTerceraPrueba) {
                peorPuntajeTerceraPrueba = notasEstudiantes[i][2];
                estudiantePeorTerceraPrueba = i + 1;
            }
        }
        
        System.out.println("El estudiante con mejor promedio es el Estudiante " + estudianteMejorPromedio + " con un promedio de " + mejorPromedio);
        System.out.println("El estudiante más regular es el Estudiante " + estudianteMasRegular + " con una diferencia de " + menorDiferencia + " puntos entre su nota más alta y más baja.");
        System.out.println("El estudiante con peor rendimiento en la tercera prueba es el Estudiante " + estudiantePeorTerceraPrueba + " con una nota de " + peorPuntajeTerceraPrueba + ".");

    }
}

