public class ListaLigada
{
    private Nodo cab;
    private Nodo ultimo;

    public ListaLigada(){
        cab= ultimo= null;
    }

    public boolean estaVacia(){
        return cab == null;
    }
    
    public boolean agregar(Object dato){
        if(estaVacia()){
            return agregarInicio(dato);
        }
        Nodo aux= new Nodo(dato, null);
        ultimo.setSiguiente(aux);
        ultimo= aux;
        return true;
    }
    
    public boolean agregarInicio(Object dato){
        if(estaVacia()){
            return agregarVacia(dato);
        }
        Nodo aux= new Nodo(dato,null);
        aux.setSiguiente(cab);
        cab= aux;
        return true;
    }
     public boolean agregarVacia(Object dato){
        if(estaVacia()){
            cab= new Nodo(dato,null);
            ultimo= cab;
            return true;
        }
        return false;
    


    }


    public Nodo buscar(Object dato){
        if(estaVacia()){
            return null;
        }
        Nodo aux= cab;
        Nodo atras= null;
        while(aux != null && aux.getDato() !=  dato){
            atras= aux;
            aux= aux.getSiguiente();
        }
        return aux;
    }

    public Nodo buscarAtras(Object dato){
        if(estaVacia()){
            return null;
        }
        Nodo aux= cab;
        Nodo atras= null;
        while(aux != null && aux.getDato() !=  dato){
            atras= aux;
            aux= aux.getSiguiente();
        }
        return atras;
    }

   
    

    public boolean agregarAntes(Object dato, Object x){
        if(estaVacia()){
            return agregarInicio(dato);
        }
        Nodo aux= new Nodo(dato, null);
        if(aux== null) return false;
        Nodo atras= buscarAtras(x);
        Nodo otro= atras.getSiguiente();
        aux.setSiguiente(otro);
        atras.setSiguiente(aux);
        return true;
    }

    

    public boolean agregarDespues(Object dato, Object x){
        if(estaVacia()){
            return agregarInicio(dato);
        }
        Nodo aux= new Nodo(dato,null);
        if(aux== null) return false;
        Nodo otro= buscarAtras(x);
        if(otro == null){
            otro= cab.getSiguiente();
            aux.setSiguiente(otro);
            cab.setSiguiente(aux);
            return true;
        }
        
        if(otro.getSiguiente() == ultimo){
            agregar(dato);
        }
        else{
            otro= otro.getSiguiente();
            aux.setSiguiente(otro.getSiguiente());
            otro.setSiguiente(aux);
        }
        return true;
    }

    public boolean agregarEnmedio(Object dato, Object x, Object y){
        if(estaVacia()){
            return agregarInicio(dato);
        }
        Nodo aux= new Nodo(dato, null);
        if(aux== null) return false;
        Nodo anterior= buscarAtras(x);
        Nodo otro= buscarAtras(y);
        if(anterior == null){
            anterior= cab;
        }
        else{
            anterior= anterior.getSiguiente();
        }
        otro= otro.getSiguiente();
        aux.setSiguiente(otro);
        anterior.setSiguiente(aux);
        return true;
    }

    public Nodo buscarPos(int pos){
        if(estaVacia()){
            return null;
        }
        Nodo aux= cab;
        int cont=1;
        while(aux != null && cont < pos){
            aux= aux.getSiguiente();
            cont++;
        }
        return aux;
    }

    public Nodo buscarAnteriorPos(int pos){
        if(estaVacia()){
            return null;
        }
        Nodo aux= cab;
        Nodo atras= null;
        int cont=1;
        while(aux != null && cont < pos){
            atras= aux;
            aux= aux.getSiguiente();
            cont++;
        }
        return atras;
    }    

    public boolean agregarPos(Object dato, int pos){
        if(estaVacia()){
            return agregarInicio(dato);
        }
        Nodo aux= new Nodo(dato, null);
        if(aux== null) return false;
        if(pos == 1) return agregarInicio(dato);
        Nodo atras= buscarAnteriorPos(pos);
        Nodo otro=  atras.getSiguiente();
        aux.setSiguiente(otro);
        atras.setSiguiente(aux);
        return true;
    }

    public Nodo eliminarPos(int pos){
        if(estaVacia()){
            return null;
        }
        Nodo aux= buscarAnteriorPos(pos);
        Nodo otro= null, eliminado= null;
        if(aux== null) return eliminarInicio();
        else{
            eliminado= aux.getSiguiente();
            otro= eliminado.getSiguiente();
            aux.setSiguiente(otro);
        }
        return eliminado;
    }

    public Nodo eliminarInicio(){
        if(estaVacia()) return null;
        Nodo aux= cab;
        cab= aux.getSiguiente();
        aux.setSiguiente(null);
        return aux;
    }

    public Nodo eliminarFinal(){
        if(estaVacia()) return null;
        Nodo aux= cab;
        Nodo atras= null;
        while(aux != null && aux != ultimo){
            atras= aux;
            aux= aux.getSiguiente();
        }
        atras.setSiguiente(null);
        ultimo= atras;
        return aux;
    }

    //Métodos para hacer una Lista Ordenada//

}
