package User;

public class Info {
    private static  String userName="evyatar cohen";
    private static String email="test125@yahool.com";

    private static String  password="A1b1c1d1e1";
    private static  String confirmPassword=password;

    public static String getUserName() {
        return userName;
    }

    public static String getEmail() {
        return email;
    }


    public static String getPassword() {
        return password;
    }

    public static String getConfirmPassword() {
        return confirmPassword;
    }
}