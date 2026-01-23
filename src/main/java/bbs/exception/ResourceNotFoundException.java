package bbs.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource,String fieldName, Object value) {
        super("Couldn't find " + resource + " with fieldName " + fieldName+ " of value " + value);

    }
}
