package components.CRUDservices;

public interface PasswordEncoderService {
    static String encode() {
        return null;
    }


    default String encode(String password) {
        return null;
    }
}
