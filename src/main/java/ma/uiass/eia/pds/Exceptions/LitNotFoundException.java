package ma.uiass.eia.pds.Exceptions;

public class LitNotFoundException extends Exception{
    public LitNotFoundException(long id){
        System.out.println("Aucun lit correspond a cet id: " +id);
    }
}
