/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.modelo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alexi
 */
public class MenuEjercicios {

    static Scanner leer = new Scanner(System.in);

    public static void menu() {
        int opcion;
        do {
            System.out.println("Ingresa una opcion:\n"
                    + "1.- Pedir tres numeros y mostrarlos ordenados de mayor a menor\n"
                    + "2.- Pedir un numero entre 0 y 9.999 y decir cuantas cifras tiene\n"
                    + "3.- Pedir un numero entre 0 y 9.999 y mostrarlo con las cifras al reves\n"
                    + "4.- Pedir un numero entre 0 y 9.999, decir si es capicua\n"
                    + "5.- Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien\n"
                    + "6.- Leer un numero e indicar si es positivo o negativo, El proceso se repetira hasta que se introduzca un 0\n"
                    + "7.- Leer un numero y mostrar su cuadrado, repetir el proceso hasta que se introduzca un numero negativo\n"
                    + "8.- Pedir numeros hasta que se teclee uno negativo, y mostrar cuantos numeros se han introducido\n"
                    + "9.- Realizar un juego para adivinar un numero. Para ello, pedir un numero N, y luego ir pidiendo numeros\n"
                    + "indicando mayor o menor segun sea mayor o menor con respecto a N. El proceso termina cuando el usuario acierta\n"
                    + "10.- Pedir numeros hasta que se teclee un 0, mostrar la suma de todos los numeros introducidos\n"
                    + "11.- Salir\n");

            opcion = leer.nextInt();  // Leer la opción del usuario

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    ejercicio4();
                    break;
                case 5:
                    ejercicio5();
                    break;
                case 6:
                    ejercicio6();
                    break;
                case 7:
                    ejercicio7();
                    break;
                case 8:
                    ejercicio8();
                    break;
                case 9:
                    ejercicio9();
                    break;
                case 10:
                    ejercicio10();
                    break;
                case 11:
                    finalizar();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 11);
    }

    public static void ejercicio1() {
        // Pedir tres numeros y mostrarlos ordenados de mayor a menor
        int a, b, c;
        System.out.println("Ingresa primer numero");
        a = leer.nextInt();
        System.out.println("Ingresa segundo numero");
        b = leer.nextInt();
        System.out.println("Ingresa tercer numero");
        c = leer.nextInt();
        if (a >= b && b >= c) {
            System.out.println(a + "," + b + "," + c);
        } else if (a >= c && c >= b) {
            System.out.println(a + "," + c + "," + b);
        } else if (b >= a && a >= c) {
            System.out.println(b + "," + a + "," + c);
        } else if (b >= c && c >= a) {
            System.out.println(b + "," + c + "," + a);
        } else if (c >= a && a >= b) {
            System.out.println(c + "," + a + "," + b);
        } else {
            System.out.println(c + "," + b + "," + a);
        }

    }

    public static void ejercicio2() {
        //Pedir un numero entre 0 y 9.999 y decir cuantas cifras tiene
        int a;
        System.out.println("Ingresa un numero entre 0 y 9999");
        a = leer.nextInt();

        if (a < 0 || a > 99999) {
            System.out.println("El nmero esta fuera de rango");
        } else if (a < 10) {
            System.out.println("El numero tiene 1 cifra");
        } else if (a < 100) {
            System.out.println("El numero tiene 2 cifras");
        } else if (a < 1000) {
            System.out.println("El numero tiene 3 cifra");
        } else {
            System.out.println("El numero tiene 4 cifras");
        }
    }

    public static void ejercicio3() {
        //Pedir un numero entre 0 y 9.999 y mostrarlo con las cifras al reves
        int numero, invertir = 0;
        System.out.println("Ingresa un numero entre 0 y 9,999:");
        numero = leer.nextInt();
        if (numero >= 0 && numero <= 9999) {
            while (numero > 0) {
                int digito = numero % 10;
                invertir = invertir * 10 + digito;
                numero /= 10;
            }
            System.out.println("El numero con las cifras al reves es: " + invertir);
        } else {
            System.out.println("El numero ingresado no esta en el rango permitido.");
        }
    }

    public static void ejercicio4() {
        //Pedir un numero entre 0 y 9.999, decir si es capicua
        int numero, inverso = 0, original;
        System.out.println("Ingresa un numero entre 0 y 9,999:");
        numero = leer.nextInt();
        if (numero >= 0 && numero <= 9999) {
            original = numero;
            while (numero > 0) {
                int digito = numero % 10;
                inverso = inverso * 10 + digito;
                numero /= 10;
            }
            if (original == inverso) {
                System.out.println("El numero " + original + " es capicua.");
            } else {
                System.out.println("El numero " + original + " no es capicua.");
            }
        } else {
            System.out.println("El numero ingresado no esta en el rango permitido.");
        }
    }

    public static void ejercicio5() {
        //Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien
        int nota;
        System.out.println("Ingresa una nota entre 0 y 10:");
        nota = leer.nextInt();
        if (nota >= 0 && nota <= 10) {
            if (nota < 5) {
                System.out.println("Insuficiente");
            } else if (nota >= 5 && nota < 7) {
                System.out.println("Suficiente");
            } else if (nota >= 7 && nota < 8) {
                System.out.println("Bien");
            } else if (nota >= 8) {
                System.out.println("exelente");
            }
        } else {
            System.out.println("La nota ingresada no está en el rango permitido.");
        }
    }

    public static void ejercicio6() {
        //Leer un numero e indicar si es positivo o negaivo. El proceso se repetira hasta que se intriduzca un 0
        int numero;
        do {
            System.out.println("Ingresa un numero (0 para salir):");
            numero = leer.nextInt();

            if (numero > 0) {
                System.out.println("El numero es positivo.");
            } else if (numero < 0) {
                System.out.println("El numero es negativo.");
            } else {
                System.out.println("Programa Finalizado");
            }

        } while (numero != 0);
    }

    public static void ejercicio7() {
        //leer un numero y mostrar su cuadrado, repetir el proceso hasta que se introduzca un numero negativo 
        int numero;
        do {
            System.out.println("Ingresa un numero (numero negativo para salir):");
            numero = leer.nextInt();
            if (numero >= 0) {
                System.out.println("El cuadrado de " + numero + " es " + (numero * numero));
            } else {
                System.out.println("Has ingresado un numero negativo, el programa terminara.");
            }

        } while (numero >= 0);
    }

    public static void ejercicio8() {
        //Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se han introducido.
        int contador = 0;
        int numero;

        do {
            System.out.println("Introduce un numero: ");
            numero = leer.nextInt();
            if (numero >= 0) {
                contador++;
            }
        } while (numero >= 0);

        System.out.println("Se han introducido " + contador + " numeros.");
    }

    public static void ejercicio9() {
        //Realizar un juego para adivinar un número. Para ello pedir un número N, y luego ir pidiendo numeros 
        //indicando "mayor" o "menor" según sea mayor o menor con respecto a N. El proceso termina cuando el usuario acierta   
        int numeroAdivinar;
        int intento;
        Random random = new Random();
        numeroAdivinar = random.nextInt(100) + 1;
        System.out.println("El numero es :" + numeroAdivinar);
        System.out.println("Puedes empezar a adivinar");
        do {
            System.out.println("Introduce tu intento: ");
            intento = leer.nextInt();
            if (intento < numeroAdivinar) {
                System.out.println("El numero es mayor");
            } else if (intento > numeroAdivinar) {
                System.out.println("El numero es menor");
            } else {
                System.out.println("Buen trabajo adivinaste el numero.");
            }
        } while (intento != numeroAdivinar);
    }

    public static void ejercicio10() {
        //Pedir números hasta que se teclee un 0, mostrar la suma de todos los números introducidos.
        int numero;
        int suma = 0;

        do {
            System.out.println("Introduce un numero (0 para terminar): ");
            numero = leer.nextInt();
            suma += numero; // Añade el número a la suma
        } while (numero != 0);

        System.out.println("La suma de todos los numeros es: " + suma);
    }

    public static void finalizar() {
        System.out.println("Fin del proceso....");
        System.out.println(" /\\_/\\ ");
        System.out.println("( o.o )");
        System.out.println(" > ^ <");
    }
}
