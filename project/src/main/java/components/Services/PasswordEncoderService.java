package components.Services;

public interface PasswordEncoderService {
    static String encode() {
        return null;
    }


    default String encode(String password) {
        return null;
    }

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
