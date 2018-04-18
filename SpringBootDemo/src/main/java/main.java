
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public class main {
    public static void main(String[] args) {
        try {
            String p = "sdl welcome you !".substring(0, "sdl welcome you !".length() - 1).trim().replace(" ", "");

            String ksPath = "/sdl.ks";
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream inputStream = new FileInputStream(ksPath);
            keyStore.load(inputStream, p.toCharArray());
            Key key = keyStore.getKey("www.didichuxing.com", p.toCharArray());
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, key);
            String flag = "506920534F89FA62C1125AABE3462F49073AB9F5C2254895534600A9242B8F18D4E420419534118D8CF9C20D07825C4797AF1A169CA83F934EF508F617C300B04242BEEA14AA4BB0F4887494703F6F50E1873708A0FE4C87AC99153DD02EEF7F9906DE120F5895DA7AD134745E032F15D253F1E4DDD6E4BC67CD0CD2314BA32660AB873B3FF067D1F3FF219C21A8B5A67246D9AE5E9437DBDD4E7FAACBA748F58FC059F662D2554AB6377D581F03E4C85BBD8D67AC6626065E2C950B9E7FBE2AEA3071DC0904455375C66A2A3F8FF4691D0C4D76347083A1E596265080FEB30816C522C6BFEA41262240A71CDBA4C02DB4AFD46C7380E2A19B08231397D099FE";
            byte[] data = cipher.doFinal(flag.getBytes());
            System.out.println(data);
        }
        catch (KeyStoreException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (CertificateException e)
        {
            e.printStackTrace();
        }
        catch (UnrecoverableKeyException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }

    }
}
