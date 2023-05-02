import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class security_crear_cita {

    private static MessageDigest md;
    private static byte[] buffer;
    private static byte[] digest;
    private static String hash = "";
    public static String pruebaString(String input) {
        // lógica de encriptación aquí
        String encryptedValue=input;
        return encryptedValue;
    }
    public static String encryptMD5(String id_transaccion,String  cod_servicio,String  rut_profesional,String  fecha,String  hora,String  correl_hora,String  cod_prestacion,String  cod_paciente,String  sedacion,String  cod_centro_atencion,String  cod_clasificacion,String  telemedicina,int timestamp,String  privateKey) {
 try {
     String input2 = id_transaccion + "~" + cod_servicio + "~" + rut_profesional + "~" + fecha + "~" + hora + "~" + correl_hora + "~" + cod_prestacion + "~" + cod_paciente + "~" + sedacion + "~" + cod_centro_atencion + "~" + cod_clasificacion + "~" + telemedicina + "~" + String.valueOf(timestamp) + "~" + privateKey;

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
