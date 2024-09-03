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
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Ingresa una opcion:\n"
                    + "1.-  Pedir tres numeros y mostrarlos ordenados de mayor a menor.\n"
                    + "2.-  Pedir un numero entre 0 y 9.999 y decir cuantas cifras tiene.\n"
                    + "3.-  Pedir un numero entre 0 y 9.999 y mostrarlo con las cifras al reves.\n"
                    + "4.-  Pedir un numero entre 0 y 9.999, decir si es capicua.\n"
                    + "5.-  Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien.\n"
                    + "6.-  Leer un numero e indicar si es positivo o negativo, El proceso se repetira hasta que.\n"
                    + "     se introduzca un 0.\n"
                    + "7.-  Leer un numero y mostrar su cuadrado, repetir el proceso hasta que se introduzca un\n"
                    + "     numero negativo.\n"
                    + "8.-  Pedir numeros hasta que se teclee uno negativo, y mostrar cuantos numeros se han\n"
                    + "     introducido.\n"
                    + "9.-  Realizar un juego para adivinar un numero. Para ello, pedir un numero N, y luego ir\n"
                    + "     pidiendo numeros indicando mayor o menor segun sea mayor o menor con respecto a N.\n"
                    + "     El proceso termina cuando el usuario acierta.\n"
                    + "10.- Pedir numeros hasta que se teclee un 0, mostrar la suma de todos los numeros.\n"
                    + "     introducidos.\n"
                    + "11.- Pedir el dia, mes y anio de una fecha e indicar si la fecha es correcta. Suponiendo\n"
                    + "     todos los meses de \n"
                    + "     30 dias.\n"
                    + "12.- Pedir un numero N, y mostrar todos los numeros del 1 al N.\n"
                    + "13.- Escribir todos los números del 100 al 0 de 7 en 7.\n"
                    + "14.- Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000 dolares.\n"
                    + "15.- Ingresa un numero entre 0 y 10 para mostrarte la tabla de multiplicar.\n"
                    + "16.- Dadas 6 notas, escribir la cantidad de alumnos aprobados, condicionados y suspensos.\n"
                    + "17.- Dame un numero de de suldos y te mostrare el maximo.\n"
                    + "18.- Pedir 10 numeros, y mostrar al final si se ha introducido alguno negativo.\n"
                    + "19.- Dame 5 numeros y te dire si alguno es multiplo de 3.\n"
                    + "20.- Dame el radio de una circunferencia y te dare su longitud.\n"
                    + "21.- Salir.\n");
            System.out.println("--------------------------------------------------------------------------------------------");
            opcion = leer.nextInt();
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
                case 11:
                    ejercicio11();
                case 12:
                    ejercicio12();
                    break;
                case 13:
                    ejercicio13();
                    break;
                case 14:
                    ejercicio14();
                    break;
                case 15:
                    ejercicio15();
                    break;
                case 16:
                    ejercicio16();
                    break;
                case 17:
                    ejercicio17();
                    break;
                case 18:
                    ejercicio18();
                    break;
                case 19:
                    ejercicio19();
                case 20:
                    ejercicio20();
                    break;
                case 21:
                    finalizar();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 21);
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
    
    public static void ejercicio11() {
        System.out.print("Ingresa el dia: ");
        int dia = leer.nextInt();
        
        System.out.print("Ingresa el mes: ");
        int mes = leer.nextInt();
        
        System.out.print("Ingresa el año: ");
        int anio = leer.nextInt();
        if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 30) {
            System.out.println("La fecha es correcta.");
        } else {
            System.out.println("La fecha es incorrecta."+anio);
        }
         leer.close();
    }
    
     public static void ejercicio12() {
      int i,num;
        System.out.print("Introduce un numero: ");
        num=leer.nextInt();
        i=1;
        // i es el contador que tomará los valores de 1 a n
        while(i<=num){
            System.out.println(i);
            i++;
        }
     }
     public static void ejercicio13() {
     // Escribir todos los números del 100 al 0 de 7 en 7
      for (int i = 100; i >= 0; i -= 7) {
            System.out.println("tus numeros son: "+i);
        }
     }
     public static void ejercicio14() {
     //Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000€
     int sueldo,suma,mayor_1000;
        suma=0;
        mayor_1000=0;
        for (int i=1;i<10;i++)
        {
            System.out.print("Escribe un sueldo: ");
            sueldo = leer.nextInt();
            if(sueldo>1000)
                mayor_1000++;
            suma=suma+sueldo;
        }
        System.out.println("Mayores de 1000 hay: "+mayor_1000);
        System.out.println("la suma es de: "+suma);
    }
     public static void ejercicio15() {
     //Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número.
      int num;
        do
        {
            System.out.println("Introduce numero (de 0 a 10): ");
            num=leer.nextInt();
        }
        while ( !  (0<=num && num<=10));
        System.out.println("\n\nTabla del " + num);
        
        for (int i=1;i<=10;i++)
        {
            System.out.println(num + " x " + i + " = " + num*i);
           
        }
     }
     public static void ejercicio16() {
     //Dadas 6 notas, escribir la cantidad de alumnos aprobados, condicionados (=4) y suspensos
     int nota,aprobados,suspensos,condicionados;
        aprobados=0;
        suspensos=0;
        condicionados=0;
        for (int i=1;i<=6;i++)
        {
            System.out.println("Introduzca nota entre 0 y 10: ");
            nota=leer.nextInt();
            if(nota == 4)
                condicionados++;
            else
                if(nota >= 5)
                    aprobados++;
                else
                    if(nota < 4) 
                        suspensos++;  
        }
        System.out.println("Aprobados: " +aprobados);
        System.out.println("Suspensos: " +suspensos);
        System.out.println("Condicionados: "+condicionados);
    }
     
     public static void ejercicio17() {
     //Pedir un número N, introducir N sueldos, y mostrar el sueldo máximo.
     int sueldo, sueldo_max;
        int n;
        sueldo_max = 0;
        System.out.print("Numero de sueldos: ");
        n = leer.nextInt();
        for (int i=1;i<=n;i++)
        {
            System.out.print("Introduce sueldo: ");
            sueldo=leer.nextInt();
            if (sueldo > sueldo_max)
                sueldo_max = sueldo;
        }
        System.out.println("\nEl sueldo maximo es: " +sueldo_max);
    }
     
     public static void ejercicio18() {
     //Pedir 10 números, y mostrar al final si se ha introducido alguno negativo
      int num;
        boolean hay_negativo;
        hay_negativo =false;
        for (int i=1;i<=10;i++)
        {
            System.out.print("Introduce numero: ");
            num=leer.nextInt();
            if(num<0)
                hay_negativo =true;
        }
        if(hay_negativo == true)
            System.out.println("Se ha introducido algun numero negativo");
        else
            System.out.println("No hay ningun numero negativo");
    }
     
     public static void ejercicio19() {
     //Pedir 5 números e indicar si alguno es múltiplo de 3.
     int num;
        boolean multiplo_3;
        multiplo_3=false;
        for (int i=0;i<5;i++){
            System.out.print("Introduzca el numero: ");
            num=leer.nextInt();
            if(num %3 == 0)
                multiplo_3=true; 
        }
        if(multiplo_3 == false)
            System.out.println("no existen multiplos de 3");
        else
            System.out.println("En el grupo que pasaste si hay multiplos de 3");
    }
     
     public static void ejercicio20() {
     // Pedir el radio de una circunferencia y calcular su longitud.
      double l,r;
        System.out.print("Introduce el radio de una circunferencia: ");
        r=leer.nextDouble();
        l=2*Math.PI*r;
        
        System.out.println("La longitud de una circunferencia de radio " + r+ " es: " + l);
     }

    public static void finalizar() {
        System.out.println("Fin del proceso....");
        System.out.println(" /\\_/\\ ");
        System.out.println("( o.o )");
        System.out.println(" > ^ <");
    }
}
