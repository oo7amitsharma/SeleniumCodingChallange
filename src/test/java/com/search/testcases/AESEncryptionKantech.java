//package com.search.testcases;
//
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.tools.ant.taskdefs.Javadoc.Html;
//
////import android.text.Html;
////import android.util.Base64;
//public class AESEncryptionKantech
//{
//   private Cipher cipher;
//   static int MIN_KEY_SIZE = 16;
//   static int MAX_KEY_SIZE = 24;
//   static int IV_ARRAY_SIZE = 16;
//   
//   public AESEncryptionKantech() throws Exception
//   {
//       cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//	  // AES/ECB/PKCS5PADDING
//   }       
//   public String DoDecrypt(String toEncrypt, String key)
//   {
//      String decryptedText = ""; 
//      
//      try
//      {
//         if(!toEncrypt.equals("") && !key.equals(""))
//         {             
//            toEncrypt = Html.fromHtml((String) toEncrypt).toString();
//            int keyArraySize = getKeyArraySize(key);
//            byte[] keyArray = incrementBytes(key.getBytes("UTF-8"));
//            byte[] byteKey = new byte[keyArraySize];
//            int byteCountToCopy = keyArray.length < keyArraySize ? keyArray.length : keyArraySize;
//            System.arraycopy(keyArray, 0, byteKey, 0, byteCountToCopy);
//            SecretKeySpec aeskey = new SecretKeySpec(byteKey, "AES");
//            byte[] ivArray = new byte[IV_ARRAY_SIZE];
//            System.arraycopy(byteKey, 0, ivArray, 0, IV_ARRAY_SIZE);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivArray);
//            cipher.init(Cipher.DECRYPT_MODE, aeskey, ivParameterSpec);
//            byte[] toDecryptArray = Base64.decodeBase64(toEncrypt);
//            byte[] decrypted = cipher.doFinal(toDecryptArray);
//            decryptedText = new String(decrypted, "UTF-8");
//         }
//      }
//      catch(Exception exp)
//      {
//         exp.printStackTrace();
//      }
//       return decryptedText;
//   }
//   
//   public String DoEncrypt(String toEncrypt, String key)
//   {
//      String encryptedText = ""; 
//       
//      try
//      {
//         if(!toEncrypt.equals("") && !key.equals(""))
//         {
//            int keyArraySize = getKeyArraySize(key);
//            byte[] keyArray = incrementBytes(key.getBytes("UTF-8"));
//            byte[] byteKey = new byte[keyArraySize];
//            int byteCountToCopy = keyArray.length < keyArraySize ? keyArray.length : keyArraySize;
//            System.arraycopy(keyArray, 0, byteKey, 0, byteCountToCopy);
//            SecretKeySpec aeskey = new SecretKeySpec(byteKey, "AES");
//            byte[] ivArray = new byte[IV_ARRAY_SIZE];
//            System.arraycopy(byteKey, 0, ivArray, 0, IV_ARRAY_SIZE);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivArray);
//            cipher.init(Cipher.ENCRYPT_MODE, aeskey, ivParameterSpec);
//            byte[] encrypted = cipher.doFinal(toEncrypt.getBytes("UTF-8"));
//            encryptedText = new String(Base64.encodeBase64String(encrypted));
//         }
//      }
//      catch(Exception exp)
//      {
//         exp.printStackTrace();
//      }
//      
//      return encryptedText;
//   }
//   
//   private int getKeyArraySize(String key)
//   {
//       return key.length() > MIN_KEY_SIZE ? MAX_KEY_SIZE : MIN_KEY_SIZE; 
//   }
//   
//   private byte[] incrementBytes(byte[] source)
//   {
//        byte[] result = new byte[source.length];
//        for (int i = 0; i < source.length; i++)
//        {
//            byte b = source[i];
//            b = (byte)(b + i + 1);
//            result[i] = b;
//        }
//        return result;
//   }
//}