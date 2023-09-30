import java.util.Scanner;
public class TTTconombres {
    public static void main(String[] args) {
        boolean fin=false;
        int empezar = 0;
        int turno;
        char[][] tabla = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
                };
        Scanner scanner = new Scanner(System.in);
        String jugadorX;
        String jugadorO;
        do {
            System.out.println();
            System.out.println("Hola y bienvenido a Tictactoe!");
            System.out.println("Presiona 1 para jugar al juego");
            System.out.println("Presiona 2 para ver el tutorial");
            System.out.println("Presiona 3 para salir del juego");

            empezar = entrada();

            if (empezar == 1) {
                turno=1;
                fin=false;
                System.out.println("Por favor, esctiba el nombre del jugador n1");
                jugadorX=scanner.nextLine();
                System.out.println("Por favor, esctiba el nombre del jugador n2");
                jugadorO=scanner.nextLine();
                System.out.println("Perfecto, comencemos!");
                System.out.println();
                for (int fila = 0; fila < tabla.length; fila++) {
                    for (int columna = 0; columna < tabla[fila].length; columna++) {
                        tabla[fila][columna] = ' ';
                    }
                }
                while (turno<10 && !fin) {
        
                if (turno==1) {
                System.out.println("Turno de " + jugadorX + "!");
                }

                int n = 0 ;
                n = colocar();
                int pos = n-1;
                int row = pos/tabla.length;
                int col = pos%tabla[0].length;
                
                if (tabla[row][col]==' ') {
                    if (turno%2==0) {
                        tabla[row][col] = 'O';
                    } else {
                        tabla[row][col] = 'X';
                    }
                    procesador(tabla);
                    fin = comrpuebaganar(tabla, col, row, turno, jugadorO, jugadorX);
                    turno++;
                    if (turno==10) {
                        System.out.println();
                        System.out.println("Empate!");
                    }else if (!fin) {
                        if (turno%2==0 && turno<=9) {
                            System.out.println("Turno de " + jugadorO + "!");
                        } else {
                            System.out.println("Turno de " + jugadorX + "!");
                        }
                    }                
                } else {
                    System.out.println("Ese espacio esta cogido, por favor, seleccione otro");
                }
                }
            } else if (empezar == 2) {

                System.out.println();
                System.out.println(" 1 | 2 | 3 ");
                System.out.println("--- --- ---");
                System.out.println(" 4 | 5 | 6 ");
                System.out.println("--- --- ---");
                System.out.println(" 7 | 8 | 9 ");
                System.out.println("Escribe uno de los números para asignar el valor 'X' u 'O' en la tabla");

                System.out.println();
                System.out.println("Para volver al menu principal, presiona 'enter'");
                scanner.nextLine();
                

            }
        } while (empezar != 3);
            
        System.out.println("Has salido del juego!");
        
    }

    static int entrada() {
        int empezar = 0;
        Scanner scanner = new Scanner(System.in);
        boolean empezarcheck = false;

        while (!empezarcheck) {
            if (scanner.hasNextInt()) {
                empezar = scanner.nextInt();
                if (empezar != 1 && empezar != 2 && empezar != 3) {
                    System.out.println("Por favor, escoja una función de las indicadas");
                } else {
                    empezarcheck = true;

                }
            } else {
                System.out.println("Por favor, escoja una función de las indicadas");
                scanner.nextLine();
            }
        }

        return empezar;
    }

    static void procesador (char[][] array2d) {

        System.out.println(" "+array2d [0][0] + " | "+array2d[0][1] + " | " + array2d [0][2] + " ");
        System.out.println("--- --- ---");
        System.out.println(" "+array2d [1][0] + " | "+array2d[1][1] + " | " + array2d [1][2] + " ");
        System.out.println("--- --- ---");
        System.out.println(" "+array2d [2][0] + " | "+array2d[2][1] + " | " + array2d [2][2] + " ");

    }

    static int colocar() {
        int lugar = 0;
        Scanner scanner = new Scanner(System.in);
        boolean checklugar = false;

        while (!checklugar) {
            if (scanner.hasNextInt()) {
                lugar = scanner.nextInt();
                if (lugar >0 && lugar <10) {
                    checklugar = true;
                } else {
                    System.out.println("Por favor, escoja un numero del 1 al 9");
                }
            } else {
                System.out.println("Por favor, escoja un numero del 1 al 9");
                scanner.nextLine();
            }
        }
        return lugar; 
    }

    static boolean comrpuebaganar(char tabla[][], int col, int row, int turno, String jugadorX, String jugadorO) {
        if (turno%2==0) {
            if (tabla[row][0]==tabla[row][1] && tabla[row][2]==tabla[row][1] && tabla[row][0]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorX+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][col]==tabla[1][col] && tabla[2][col]==tabla[1][col] && tabla[0][col]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorX+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][0]==tabla[1][1] && tabla[2][2]==tabla[0][0] && tabla[0][0]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorX+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][2]==tabla[1][1] && tabla[2][0]==tabla[0][2] && tabla[0][2]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorX+", has ganado!");
            System.out.println();
            return true;            
        }
        } else {
            if (tabla[row][0]==tabla[row][1] && tabla[row][2]==tabla[row][1] && tabla[row][0]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorO+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][col]==tabla[1][col] && tabla[2][col]==tabla[1][col] && tabla[0][col]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorO+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][0]==tabla[1][1] && tabla[2][2]==tabla[0][0] && tabla[0][0]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorO+", has ganado!");
            System.out.println();
            return true;
        }
        if (tabla[0][2]==tabla[1][1] && tabla[2][0]==tabla[0][2] && tabla[0][2]!=' ') {
            System.out.println();
            System.out.println("Felicidades "+jugadorO+", has ganado!");
            System.out.println();
            return true;            
        }
        }
        //jugador=turno%2==0?'X':'O';
                
        return false;

    }        

}
