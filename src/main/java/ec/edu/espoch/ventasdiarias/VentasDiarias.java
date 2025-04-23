

package ec.edu.espoch.ventasdiarias;

import java.util.Scanner;


public class VentasDiarias {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double[] ventas = new double[7];
        boolean salir = false;

       
        for (int i = 0; i < 7; i++) {
            double monto;
            do {
                System.out.print("Ingrese el monto de ventas para el dia " + (i + 1) + ": ");
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println("El monto debe ser un numero positivo. Intente de nuevo.");
                }
            } while (monto < 0);
            ventas[i] = monto;
        }

        while (!salir) {
            System.out.println("Menu de Opciones:");
            System.out.println("1. Calcular el total de ventas de la semana");
            System.out.println("2. Calcular el dia con ventas mas cercanas al promedio");
            System.out.println("3. Mostrar el dia con la venta mas alta y el dia con la venta mas baja");
            System.out.println("4. Calcular el monto acumulado de ventas durante los primeros tres dias y los ultimos tres dias");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    double total = 0;
                    for (double venta : ventas) {
                        total += venta;
                    }
                    System.out.println("Total de ventas de la semana: " + total);
                    break;

                case 2:
                    double promedio = 0;
                    for (double venta : ventas) {
                        promedio += venta;
                    }
                    promedio /= 7;

                    double diferenciaMinima = Math.abs(ventas[0] - promedio);
                    int diaCercano = 0;
                    for (int i = 1; i < 7; i++) {
                        double diferencia = Math.abs(ventas[i] - promedio);
                        if (diferencia < diferenciaMinima) {
                            diferenciaMinima = diferencia;
                            diaCercano = i;
                        }
                    }
                    System.out.println("Dia con ventas mas cercanas al promedio: Dia " + (diaCercano + 1));
                    break;

                case 3:
                    double ventaMax = ventas[0];
                    double ventaMin = ventas[0];
                    int diaMax = 0;
                    int diaMin = 0;
                    for (int i = 1; i < 7; i++) {
                        if (ventas[i] > ventaMax) {
                            ventaMax = ventas[i];
                            diaMax = i;
                        }
                        if (ventas[i] < ventaMin) {
                            ventaMin = ventas[i];
                            diaMin = i;
                        } 
                    }
                    System.out.println("Dia con la venta mas alta: Dia " + (diaMax + 1));
                    System.out.println("Dia con la venta mas baja: Dia " + (diaMin + 1));
                    break;

                case 4:
                    double totalPrimerosTres = ventas [0] + ventas[1] + ventas[2];
                    double totalUltimosTres = ventas[4] + ventas[5] + ventas[6];
                    System.out.println("el total de venta de  los tres primeros dias : " + totalPrimerosTres);
                    System.out.println("el total de venta de  los tres ultimos dias : " + totalUltimosTres);
            }
        }
    }
}
        

