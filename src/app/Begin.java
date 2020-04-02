/**
 Copyright [2020] [Javier Linares Castrillon]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package app;

import domain.*;

import java.util.Scanner;
/**
 * @author Javier Linares Castrillón
 */

public class Begin {

    private  static Lista l = new Lista();
    private static ColaEsperaConUrgencia c = new ColaEsperaConUrgencia();

    public static void init(){

        String nt, na, f, u;
        Scanner sc = new Scanner(System.in);
        Scanner si = new Scanner(System.in);
        int x;
        boolean go = true;

        for(Trabajo t : l.getTrabajos()){
            c.nuevoTrabajo(t, t.getUrg());
        }


        do {

            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Elige una opción:");
            System.out.println("1.- Ver tareas.");
            System.out.println("2.- Hacer tarea.");
            System.out.println("3.- Annadir tarea.");
            System.out.println("4.- Eliminar tarea realizada.");
            System.out.println("5.- Salir.");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    c.muestraEstado();
                    break;
                case 2:
                    Trabajo tr = c.hacerTrabajo();
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Proximo Trabajo: " + tr.getNombreTarea());
                    System.out.println("Asignatura: " + tr.getNombreAsignatura());
                    System.out.println("Fecha: " + tr.getFecha());
                    System.out.println("Urgencia: " + tr.getUrgencia());
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println();
                    break;
                case 3:

                    System.out.println("Tarea: ");
                    nt = si.nextLine();
                    System.out.println("Asignatura: ");
                    na = si.nextLine();
                    System.out.println("Fecha: ");
                    f = si.nextLine();
                    System.out.println("Urgencia: ");
                    u = si.nextLine();
                    Trabajo t = new Trabajo(nt, na, f, u);
                    l.addTrabajo(t);
                    c.nuevoTrabajo(t, t.getUrg());
                    break;

                case 4:
                    Trabajo ta = c.hacerTrabajo();
                    l.borrar(ta);
                    System.out.println("El trabajo " + ta.getNombreTarea() + " ha sido terminado.");
                    break;


                case 5: go = false;
                break;

                default: System.out.println("Opcion no valida.");
            }
        } while (go);
    }

}