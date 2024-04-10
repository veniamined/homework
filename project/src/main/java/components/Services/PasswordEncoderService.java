package components.services;

public interface PasswordEncoderService {

    default String encode(String password) {
        return null;
    }

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
