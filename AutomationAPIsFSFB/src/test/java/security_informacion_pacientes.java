import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class security_informacion_pacientes {

    private static MessageDigest md;
    private static byte[] buffer;
    private static byte[] digest;
    private static String hash = "";
    public static String pruebaString(String input) {
        // lógica de encriptación aquí
        String encryptedValue=input;
        return encryptedValue;
    }
    public static String encryptMD5(String tipo_documento, String numero_documento, int timestamp, String privateKey) {
 try {
     String input2 = tipo_documento + "~" + numero_documento + "~" + String.valueOf(timestamp) + "~" + privateKey;

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input2.getBytes());
        byte[] digest = md.digest();
        return bytesToHex(digest);
     } catch (NoSuchAlgorithmException e) {
     throw new RuntimeException("Error al encriptar la cadena usando MD5", e);
 }
 }
        public static String bytesToHex(byte[] bytes) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
        sb.append(String.format("%02x", b));

        }
                return encryptSHA1(sb.toString());
        }

    public static String encryptSHA1(String message) throws NoSuchAlgorithmException {
            buffer = message.getBytes();
                md = MessageDigest.getInstance("SHA1");
                md.update(buffer);
                digest = md.digest();

            for(byte aux : digest) {
                int b = aux & 0xff;
                if (Integer.toHexString(b).length() == 1) hash += "0";
                    hash += Integer.toHexString(b);
            }
 return hash;}
}
