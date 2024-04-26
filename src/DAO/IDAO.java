package DAO;

import java.util.ArrayList;



public interface IDAO<T> {
    
    
    ArrayList<T> read();
    
    boolean insert(T obj);
    
    boolean update(T obj);
    
    boolean delete(T obj);
}
