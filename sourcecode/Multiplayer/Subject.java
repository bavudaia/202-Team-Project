/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject  
{
   public void notifyObservers();
   public void addObserver(Observer o);
   public void removeObserver(Observer o);
   public State getCurrentState();
   
}
