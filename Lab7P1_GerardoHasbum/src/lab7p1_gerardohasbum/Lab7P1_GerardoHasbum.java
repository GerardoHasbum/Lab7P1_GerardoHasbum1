//fila 3 silla 6
package lab7p1_gerardohasbum;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_GerardoHasbum {
    //        |||
    //imports vvv
    static Scanner jhin = new Scanner(System.in);
    static Random ran = new Random();
    //imports ^^^
    //        |||
    
    //        |||
    //metodos vvv
    //Metodos print
    public static void PrintMatChar(char[][] matriz) {//imprime una matriz de caracteres
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static void PrintMatInt(int[][] matriz) {//imprime una matriz de enteros
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    }

    //Metodos para Tres en raya
    public static char[][] generarTablero(char[][] matriz) {//genera un tablero de espacios en blanco para la simplificacion de asignacion de valores
        char[][] temporal = new char[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                temporal[i][j] = ' ';
            }
        }
        return temporal;
    }

    public static boolean verificarPosicionValida(char[][] matriz, int fily, int colx) {//valida si la posicion de un arreglo esta con un valor diferente a vacio
        boolean temporal = false;
        if (matriz[fily][colx] == ' ') {
            temporal = true;
        } else {
            temporal = false;
        }
        return temporal;
    }

    public static boolean verificarVictoria(char[][] matriz, char ver) {//verifica si uno de los caracteres ha hecho una linea de tres seguidas para asignar el gane
        boolean temporal = false;
        if (matriz[0][0] == ver && matriz[0][1] == ver && matriz[0][2] == ver) {//primera fila
            temporal = true;
        } else if (matriz[0][0] == ver && matriz[1][0] == ver && matriz[2][0] == ver) {//primera columna
            temporal = true;
        } else if (matriz[1][0] == ver && matriz[1][1] == ver && matriz[1][2] == ver) {//segunda fila
            temporal = true;
        } else if (matriz[0][1] == ver && matriz[1][1] == ver && matriz[2][1] == ver) {//segunda columna
            temporal = true;
        } else if (matriz[2][0] == ver && matriz[2][1] == ver && matriz[2][2] == ver) {//tercera fila
            temporal = true;
        } else if (matriz[0][2] == ver && matriz[1][2] == ver && matriz[2][2] == ver) {//tercera columna
            temporal = true;
        } else if (matriz[0][0] == ver && matriz[1][1] == ver && matriz[2][2] == ver) {//diagonal normal
            temporal = true;
        } else if (matriz[0][2] == ver && matriz[1][1] == ver && matriz[2][0] == ver) {//diagonal inversa
            temporal = true;
        }
        return temporal;
    }

    //Metodos para Puntos de silla
    public static int[][] generarIntMatrizAleatoria(int fil, int col) {//Genera una matriz aleatoria con los parametros llamados
        int[][] temporal = new int[fil][col];
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal[i].length; j++) {
                temporal[i][j] = ran.nextInt(100);
            }
        }
        return temporal;
    }

    public static void encontrarPuntosSilla(int[][] matriz) {//encuentra los puntos de silla para imprimirlos o decir que no hay
        int cont_ps = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == menor(matriz, i) && matriz[i][j] == mayor(matriz, j)) {//valida que sea un punto de silla comparando que sea el menor de la fila y el mayor de la columna
                    cont_ps++;//sirve para saber si se encontraron puntos de silla o no
                    System.out.println("Se encontro un punto silla en [" + i + "] " + "[" + j + "] " + ": " + matriz[i][j]);
                }
            }
        }
        if (cont_ps == 0) {//si no hay puntos de silla tirara el siguiente mensaje
            System.out.println("No se encontraron puntos de silla en la matriz");
        }
    }

    public static int menor(int[][] mat, int fil) {//encuentra el numero menor de una fila
        int menor = 100;
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[fil][i] < menor) {
                menor = mat[fil][i];
            }
        }
        return menor;
    }

    public static int mayor(int[][] mat, int col) {//encuentra el numero mayor de una columna
        int mayor = -100;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > mayor) {
                mayor = mat[i][col];
            }
        }
        return mayor;
    }

    //metodos ^^^
    //        |||
    //      |||
    //main  vvv
    public static void main(String[] args) {                                        //main
        System.out.println("*****MENU*****");                                     //menu
        System.out.println("1. Tres en raya");
        System.out.println("2. Puntos de silla");
        System.out.println("3. Salir de programa");
        System.out.println("Ingrese su opcion: ");
        int opcion = jhin.nextInt();
        while (opcion > 0 && opcion < 3) {
            switch (opcion) {
                case 1:
                    case1();                                                    //llamar el primer caso de tres en raya
                    break;                                                      

                case 2:
                    case2();                                                    //llamar el segundo caso de puntos de silla
                    break;
            }
            System.out.println("*****MENU*****");                               //menu
            System.out.println("1. Tres en raya");
            System.out.println("2. Puntos de silla");
            System.out.println("3. Salir de programa");
            System.out.println("Ingrese su opcion: ");
            opcion = jhin.nextInt();
        }
    }                                                                               //fin del main
//          ^^^
    //main  |||
    //casos |||
    //      vvv
    public static void case1() {
        System.out.println("*****TRES EN RAYA*****");
        char res_us = 's';
        while (res_us == 's' || res_us == 'S') {
            char[][] matriz = new char[3][3];
            matriz = generarTablero(matriz);
            PrintMatChar(matriz);
            boolean wx = false, //creacion de win conditions
                    w0 = false;
            System.out.println("Es el turno de X: ");
            System.out.print("Ingrese la fila(0,1,2): ");
            int fily = jhin.nextInt();
            System.out.print("Ingrese la columna(0,1,2): ");
            int colx = jhin.nextInt();
            System.out.println();
            boolean ver = verificarPosicionValida(matriz, fily, colx);
            while ((fily < 0 && fily > 2) || (colx < 0 && colx > 2)) {
                System.out.println("Esos valores no son posibles porfavor ingrese valores correctos: ");
                System.out.print("Ingrese la fila(0,1,2): ");
                fily = jhin.nextInt();
                System.out.print("Ingrese la columna(0,1,2): ");
                colx = jhin.nextInt();
            }
            if (ver == true) {
                matriz[fily][colx] = 'X';
                PrintMatChar(matriz);
            } else {
                while (ver == false) {
                    System.out.println("Esos valores no son posibles porfavor ingrese valores correctos: ");
                    System.out.print("Ingrese la fila(0,1,2): ");
                    fily = jhin.nextInt();
                    System.out.print("Ingrese la columna(0,1,2): ");
                    colx = jhin.nextInt();
                }
            }
            System.out.println("Turno de 0: ");
//                    System.out.println("1");
            fily = ran.nextInt(3);
            colx = ran.nextInt(3);
//                    System.out.println(fily + colx);
            ver = verificarPosicionValida(matriz, fily, colx);
            while (ver == false) {
                fily = ran.nextInt(3);
                colx = ran.nextInt(3);
                ver = verificarPosicionValida(matriz, fily, colx);

            }
            System.out.println("La maquina ha elegido las posiciones: " + "[" + fily + "] " + "[" + colx + "] ");
            matriz[fily][colx] = '0';
            PrintMatChar(matriz);
            while (wx == false || w0 == false) {//comienzo del while para continuar el juego
                int cont32 = 0;//contador para verificar si la matriz esta llena o no
                System.out.println("Es el turno de X: ");                       //Asignando la poscicion del jugador
                System.out.print("Ingrese la fila(0,1,2): ");
                fily = jhin.nextInt();
                System.out.print("Ingrese la columna(0,1,2): ");
                colx = jhin.nextInt();
                System.out.println();
                ver = verificarPosicionValida(matriz, fily, colx);              // confirmando que la posicion este dentro de la matriz
                while ((fily < 0 && fily > 3) && (colx < 0 && colx > 3)) {
                    System.out.println("Esos valores no son posibles porfavor ingrese valores correctos: ");
                    System.out.print("Ingrese la fila(0,1,2): ");
                    fily = jhin.nextInt();
                    System.out.print("Ingrese la columna(0,1,2): ");
                    colx = jhin.nextInt();
                    ver = verificarPosicionValida(matriz, fily, colx);
                }
                if (ver == true) {                                              // validando que la posicion este libre
                    matriz[fily][colx] = 'X';
                    PrintMatChar(matriz);
                } else {
                    while (ver == false) {
                        System.out.println("En esa posicion ya existe un valor porfavor ingresar otra: ");
                        System.out.print("Ingrese la fila(0,1,2): ");
                        fily = jhin.nextInt();
                        System.out.print("Ingrese la columna(0,1,2): ");
                        colx = jhin.nextInt();
                        ver = verificarPosicionValida(matriz, fily, colx);          // si la condicion no se cumple pide que ponga una posicion posible
                    }
                    matriz[fily][colx] = 'X';
                    PrintMatChar(matriz);
                }
                wx = verificarVictoria(matriz, 'X');                            // Confirmacion de gane o empate
                w0 = verificarVictoria(matriz, '0');
//                            System.out.println(wx);
//                            System.out.println(w0);
                if (wx == true) {
                    System.out.println("X ha ganado!");
                    break;
                } else if (w0 == true) {
                    System.out.println("0 ha ganado!");
                    break;
                }
                for (int i = 0; i < matriz.length; i++) {                       // validacion de si ya se lleno la matriz o si sigue con espacios en blanco para seguir o llamar un empate
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (matriz[i][j] == ' ') {
                            cont32++;
                        }
                    }
                }
                if (cont32 == 0) {
                    System.out.println("Empate :c");
                    break;
                }
                System.out.println("Turno de 0: ");                             // turno de la maquina
                fily = ran.nextInt(3);                                      //asignacion alazar de las posiciones de 0
                colx = ran.nextInt(3);
                ver = verificarPosicionValida(matriz, fily, colx);
                while (ver == false) {                                              //validacion de posicion
                    fily = ran.nextInt(3);
                    colx = ran.nextInt(3);
                    ver = verificarPosicionValida(matriz, fily, colx);              //repite hasta ser posible

                }
                System.out.println("La maquina ha elegido las posiciones: " + "[" + fily + "] " + "[" + colx + "] ");
                matriz[fily][colx] = '0';
                PrintMatChar(matriz);
                wx = verificarVictoria(matriz, 'X');                          // Confirmacion de gane o empate
                w0 = verificarVictoria(matriz, '0');
                cont32 = 0;
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (matriz[i][j] == ' ') {
                            cont32++;
                        }
                    }
                }
                if (wx == true) {
                    System.out.println("X ha ganado!");
                    break;
                }
                if (w0 == true) {
                    System.out.println("0 ha ganado!");
                    break;
                }
                if (cont32 == 0) {
                    System.out.println("Empate :c");
                    break;
                }
            }
            System.out.println("Desea volver a jugar? [s/n]");                  //validacion si el jugador desea volver a jugar o no
            res_us = jhin.next().charAt(0);
        }
    }

    public static void case2() {
        System.out.println("*****PUNTOS DE SILLA*****");
        System.out.println("Ingrese filas: ");                                  //asignacion de valor para las filas
        int fil = jhin.nextInt();   
        while (fil < 1) {
            System.out.println("El valor de filas no puede ser menor a 1");     //validacion de filas siendo 1 o mayor para poder asignar valores
            System.out.println("Ingrese otro valor: ");
            fil = jhin.nextInt();                                                   //se repetira hasta que el valor sea posible
        }
        System.out.println("Ingrese columnas: ");                               //asignacion de valor para las columnas
        int col = jhin.nextInt();   
        while (col < 1) {                                                       //validacion que las columnas sean 1 o mayor para poder asignar valores
            System.out.println("El valor de col");
        }
        int[][] matriz = generarIntMatrizAleatoria(fil, col);                   //Una vez terminadas las validaciones creara una matriz aleatoria con los valores dados
        PrintMatInt(matriz);                                                    //imprime la matriz

        encontrarPuntosSilla(matriz);                                           //imprime los puntos de sillas encontrados al igual que si no hubieran.
    }
    
    //casos ^^^
    //      |||

}
