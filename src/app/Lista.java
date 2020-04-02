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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Javier Linares Castrillón
 */

public class Lista{

    private String nombreFichero = "Asignaturas.txt";
    private ArrayList<Trabajo> trabajos = new ArrayList<>();

    public Lista(){
        try {
            File lista = new File(nombreFichero);
            lista.createNewFile();
            Scanner sc = new Scanner(lista);
            while(sc.hasNext()) {
                Trabajo t = new Trabajo();
                t.setNombreTarea(sc.nextLine());
                t.setNombreAsignatura(sc.nextLine());
                t.setFecha(sc.nextLine());
                t.setUrgencia(sc.nextLine());
                trabajos.add(t);
            }
        }catch(IOException ex)	{
            System.err.println(ex);
        }
    }

    public ArrayList<Trabajo> getTrabajos() {
        return trabajos;
    }

    private void volcar() {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            for(Trabajo t : trabajos) {
                fw.write(t.getNombreTarea() + "\n");
                fw.write(t.getNombreAsignatura() + "\n");
                fw.write(t.getFecha() + "\n");
                fw.write(t.getUrgencia() + "\n");
            }
            fw.close();
        }catch(IOException ex) {
            System.err.println(ex);
        }
    }

    public void addTrabajo(Trabajo t)
    {
        trabajos.add(t);
        this.volcar();
    }


    public void borrar(Trabajo t){
        trabajos.remove(t);
        this.volcar();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Trabajo t : trabajos) {
            sb.append(t + "\n");
        }
        return sb.toString();
    }
}
