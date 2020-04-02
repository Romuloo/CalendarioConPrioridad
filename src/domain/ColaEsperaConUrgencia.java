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
package domain;

import java.util.*;

/**
 * @author Javier Linares Castrillón
 */

public class ColaEsperaConUrgencia
{
    private static class DatosTrabajo implements Comparable<DatosTrabajo>
    {

        Trabajo c;
        Urgencia urg;


        DatosTrabajo (Trabajo c, Urgencia urg) {
            this.c=c;
            this.urg=urg;
        }

        public int compareTo(DatosTrabajo otro) {
            return this.urg.compareTo(otro.urg);

        }

    }
    private Queue<DatosTrabajo> colaEspera;

    public ColaEsperaConUrgencia()
    {

        colaEspera = new PriorityQueue<DatosTrabajo>();

    }

    public void nuevoTrabajo(Trabajo c, Urgencia urg)
    {
        DatosTrabajo datos=new DatosTrabajo(c,urg);

        colaEspera.add(datos);
    }


    public Trabajo hacerTrabajo() throws NoSuchElementException
    {
           DatosTrabajo datos = colaEspera.remove();
           return datos.c;
    }


    public void muestraEstado() {

        System.out.println();

        System.out.println("----------------------------–Estado de la cola-------------------------------–");

        System.out.println("No atendidos "+

                colaEspera.size());

        for (DatosTrabajo datos : colaEspera) {
            System.out.println(datos.c + "\nUrgencia: " + datos.urg);
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

    public int numTrabajosEnEspera() {
        return colaEspera.size();
    }

    public Queue<DatosTrabajo> getColaEspera() {
        return colaEspera;
    }
}