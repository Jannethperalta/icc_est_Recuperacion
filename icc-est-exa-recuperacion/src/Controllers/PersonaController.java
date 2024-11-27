package Controllers;

import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {
    public void edadSeleccion(Persona[] personas){
        int n = personas.length;
        for (int i = 0; i < n; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (personas[j].getEdad()> personas[minIndex].getEdad()){
                    minIndex = j;
                }
            }
            Persona temp = personas[minIndex];
            personas[minIndex] = personas[i];
            personas[i] = temp;
        }
        
    }
    public void nombreInsertion(Persona[] personas) {
        int num = personas.length;
        for (int i = 1; i < num; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j = j - 1;
            }
            personas[j + 1] = key;
        }
    }
    public int binarioEdad(Persona[] personas, int edad) {
        int left = 0;
        int right = personas.length - 1;
    
        while (left <= right) {
            int mitad = left + (right - left) / 2;
    
            if (personas[mitad].getEdad() == edad) {
                return mitad;
            }
                if (personas[mitad].getEdad() < edad) { 
                right = mitad - 1; 
            } else {
                left = mitad + 1; 
            }
        }
        return -1;
    }
    public int binarioNombre(Persona[] personas, String nombre) {
        int left = 0;
        int right = personas.length - 1;
        
        while (left <= right) {
            int mitad = left + (right - left) / 2; 
            
            int compar = personas[mitad].getNombre().compareToIgnoreCase(nombre);
            if (compar == 0) {
                return mitad;  
            }
            if (compar < 0) {
                left = mitad + 1;
            }
            else {
                right = mitad - 1;
            }
        }
        return -1;  
    }
    
}
