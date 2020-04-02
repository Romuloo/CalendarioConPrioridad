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
/**
 * @author Javier Linares Castrillón
 */

public class Trabajo {

    private String fecha, nombreTarea, nombreAsignatura, urgencia;
    private Urgencia urg;



    public Urgencia getUrg() {
        if(this.urgencia.equalsIgnoreCase("muyAlta"))return  Urgencia.muyAlta;
        if(this.urgencia.equalsIgnoreCase("alta"))return  Urgencia.alta;
        if(this.urgencia.equalsIgnoreCase("medioAlta")) return Urgencia.medioAlta;
        if(this.urgencia.equalsIgnoreCase("media")) return Urgencia.media;
        if(this.urgencia.equalsIgnoreCase("medioBaja"))return Urgencia.medioBaja;
        if(this.urgencia.equalsIgnoreCase("baja")) return Urgencia.baja;
        else return null;
    }

    public Trabajo(String nombreTarea, String nombreAsignatura, String fecha, String urg){
      this.nombreTarea = nombreTarea;
      this.nombreAsignatura = nombreAsignatura;
      this.fecha = fecha;
      this.urgencia = urg;


    }

    public Trabajo(){

    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String toString(){

        return "\nTrabajo: " + nombreTarea + "\nAsignatura: " + nombreAsignatura + "\nFecha: " + fecha;
    }

    public boolean equals(Object o)
    {
        Trabajo t = (Trabajo) o;
        return this.nombreTarea.equals(t.getNombreTarea());
    }
}
