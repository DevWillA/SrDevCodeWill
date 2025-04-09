package com.willdev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoComparator {

    private class Estudiante implements Comparable<Estudiante> {
        private String nombre;
        private Integer edad;

        public Estudiante(String nombre, Integer edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public Integer getEdad() {
            return edad;
        }

        public int compareTo(Estudiante otro) {
            if (this.edad < otro.edad) {
                return -1;
            } else if (this.edad > otro.edad) {
                return 1;
            }
            return 0;
        }

    }

    private class EstudianteComparator implements Comparator<Estudiante> {
        @Override
        public int compare(Estudiante e1, Estudiante e2) {
            var order = Integer.compare(e1.getEdad(), e2.getEdad());
            if (order == 0) {
                order = e1.getNombre().compareTo(e2.getNombre());
            }
            return 0;
        }
    }


    public void run() {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Rafael", 27));
        estudiantes.add(new Estudiante("Andres", 23));
        estudiantes.add(new Estudiante("Duvan", 18));
        estudiantes.add(new Estudiante("Eyder", 24));
        estudiantes.add(new Estudiante("Juan", 24));

        Collections.sort(estudiantes, new EstudianteComparator());
        estudiantes.forEach(e -> System.out.println(e.getNombre() + " - " + e.getEdad()));

        System.out.println();

        Collections.sort(estudiantes, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        estudiantes.forEach(e -> System.out.println(e.getNombre() + " - " + e.getEdad()));
    }
}
