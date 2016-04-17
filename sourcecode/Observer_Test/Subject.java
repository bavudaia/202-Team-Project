/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject  
{
   void notifyObserver();
   void addObserver(Observer o);
   void removeObserver(Observer o);
   
}
