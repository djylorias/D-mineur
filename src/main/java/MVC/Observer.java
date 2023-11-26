package main.java.MVC;

/**
 * Representing a view of a model
 * @since 0.6
 */
public interface Observer {

  public void update(Subject subj);
  public void update(Subject subj, Object data);

}
