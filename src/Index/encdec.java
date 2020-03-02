package Index;
import java.io.*;
import java.io.File;
import javax.swing.JOptionPane;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
public class encdec 
{
    private String fullPath;
    public String path;
    public String filename;
    public String extension;
    private String username;
    private String password;
    private String acc_pass;
    
    public encdec(String loc,String u, String p)    // for example location is D:\\filename\\example1.txt
    {
        this.username=u;
        this.password=p;
        this.fullPath = loc;            // for example fullPath is D:\\filename\\example1.txt
        this.path= getpath();               // location = D:\\filename\\
        this.filename = getfilename();      // filename = example1
        this.extension= getextension();        //extension = txt
    }
    
    public encdec(String loc,String u, String p,String acc_pass)    // for example location is D:\\filename\\example1.txt
    {
        this.username=u;
        this.password=p;
        this.fullPath = loc;            // for example fullPath is D:\\filename\\example1.txt
        this.path= getpath();               // location = D:\\filename\\
        this.filename = getfilename();      // filename = example1
        this.extension= getextension();        //extension = txt
        this.acc_pass= acc_pass;
        //JOptionPane.showMessageDialog(null ,this.acc_pass);
    }
    byte[] encrypt(SecretKey myDesKey,byte[] msg)
    {
        //des encryption algorithm
        try{
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = new byte[msg.length];
            textEncrypted = desCipher.doFinal(msg);
            return textEncrypted;
        }catch(NoSuchAlgorithmException e){
                    e.printStackTrace();
        }catch(NoSuchPaddingException e){
                    e.printStackTrace();
        }catch(InvalidKeyException e){
                    e.printStackTrace();
        }catch(IllegalBlockSizeException e){
                    e.printStackTrace();
        }catch(BadPaddingException e){
                    e.printStackTrace();
        } 
        byte[] n = null;
        return n;
    }
    byte[] decrypt(SecretKey myDesKey,byte[] textEncrypted)
    {
        try{
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = new byte[textEncrypted.length];
            textDecrypted = desCipher.doFinal(textEncrypted);
            return textDecrypted;
        }catch(NoSuchAlgorithmException e){
                    e.printStackTrace();
        }catch(NoSuchPaddingException e){
                    e.printStackTrace();
        }catch(InvalidKeyException e){
                    e.printStackTrace();
        }catch(IllegalBlockSizeException e){
                    e.printStackTrace();
        }catch(BadPaddingException e){
                    e.printStackTrace();
        }  
        byte[] textDecrypted = null;
        return textDecrypted;
    }

    private String getfilename() 
    {
        int dot = fullPath.lastIndexOf('.');
        int sep = fullPath.lastIndexOf('\\');
        return fullPath.substring(sep + 1, dot);
    }
    private String getpath() {
        int sep = fullPath.lastIndexOf('\\');
        return fullPath.substring(0, sep);
    }
    private String getextension() {
        int dot = fullPath.lastIndexOf('.');
        return fullPath.substring(dot + 1);
    }
    boolean normaltokkk()
    {
       try
        {
            if(extension.compareTo("kkk")==0)
                throw new Exception();
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();      //DES  key generation
            
            ObjectOutputStream os;  //used to write object
            os = new ObjectOutputStream(new FileOutputStream(path+"\\"+filename+".kkk"));
            
            SmallBinaryFiles binary = new SmallBinaryFiles(); // used to read file in binary
            //ProgressBar p = new ProgressBar();
            //p.pb(binary);
            byte[] filecontents = binary.read(path+"\\"+filename+"."+extension);   //read normal file in binary
            byte[] msg = encrypt(myDesKey,filecontents);        //encrypt contents in des 
            //JOptionPane.showMessageDialog(null ,username);
            kkkFileFormat kkkformat = new kkkFileFormat(username,password,extension,myDesKey,msg,msg.length,acc_pass); // kkkformat object
            os.writeObject(kkkformat);     //write kkkformat object
            os.close();                    //close object writing
            boolean success = (new File(path+"\\"+filename+"."+extension)).delete();  //delete original file
            return success;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"Your file is already encrypted");
            return false;
        } 
    }   
    public boolean kkktonormal()
    {
        try
        {
            ObjectInputStream is= new ObjectInputStream(new FileInputStream(path+"\\"+filename+".kkk"));  //kkkformat object stream
            kkkFileFormat kkkformat=(kkkFileFormat) is.readObject();   //read kkkformat object
            SmallBinaryFiles binary = new SmallBinaryFiles();         //
            //ProgressBar p = new ProgressBar();
            //JOptionPane.showMessageDialog(null ,binary.getbytepointer());
            //p.pb(binary);
            if(kkkformat.content.length!=kkkformat.length)            
                throw new Exception("Length not matching"); 
            byte[] msg = new byte[kkkformat.length+1024*1024];
            msg = decrypt(kkkformat.secretkey,kkkformat.content);            //decrypt the file contents back to original
            binary.write(msg,path+"\\"+filename+"."+kkkformat.ext);   //write in binary the contents
            is.close();                                                 //close input object stream
            boolean success = (new File(path+"\\"+filename+".kkk")).delete();               //delete kkkformat object
            return success;   
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"Your file seems to have been corrupted by someone!\n");
        }
        return false;
    }
    public boolean Ispasswordcorrect() 
    {
        try
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(path+"\\"+filename+".kkk")); //kkkformat object stream
            kkkFileFormat k =(kkkFileFormat) is.readObject();
            //JOptionPane.showMessageDialog(null ,k.acc_password+" \n "+acc_pass);
            MD5Hashing m = new MD5Hashing();
            if(m.md5encryption(acc_pass).compareTo(k.acc_password)==0)
            {
                is.close();
                return true;
            }
            else
            {
                is.close();
                return false;
            }
        }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return false;
    }
    public boolean Isusernamecorrect() 
    {
        try
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(path+"\\"+filename+".kkk")); //kkkformat object stream
            kkkFileFormat k =(kkkFileFormat) is.readObject();
            //JOptionPane.showMessageDialog(null ,k.user+" \n "+username);
            k.printformat();
            if(username.compareTo(k.user)==0)
            {
                is.close();
                return true;
            }
            else
            {
                is.close();
                return false;
            }
        }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return false;
    }
}

class kkkFileFormat implements Serializable
{
    protected String user;
    protected String password;
    protected SecretKey secretkey;
    protected byte[] content;
    protected int length;
    protected final String ext;
    protected final String acc_password;
    
    kkkFileFormat(String user,String pass,String ext,SecretKey secret,byte[] c,int l,String a_password) throws Exception{
        MD5Hashing m = new MD5Hashing();
        this.user=user;
        this.password=m.md5encryption(pass);
        this.ext=ext;
        this.secretkey=secret;
        this.content=c;
        this.length=l;
        this.acc_password=m.md5encryption(a_password);
    }
    public void printformat()
    {
        //JOptionPane.showMessageDialog(null ,user+" \n "+password+"\n"+ext+"\n"+secretkey+"\n"+content+"\n"+length+"\n");
        log(user+" \n "+password+"\n"+ext+"\n"+secretkey+"\n"+Arrays.toString(content)+"\n"+length+"\n");
    }
    private static void log(Object aThing){
    System.out.println(String.valueOf(aThing));
    }
}
class SmallBinaryFiles {
    private int bytepointer=0;
    
    byte[] read(String aInputFileName){
        
        JProgressBar progressBar = new JProgressBar(0,100);
        JFrame frame 		 = new JFrame("Processing...");
        progressBar.setStringPainted(true);	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(progressBar);
	frame.setSize(400,100);
	frame.setVisible(true);
        
    log("Reading in binary file named : " + aInputFileName);
    File file = new File(aInputFileName);
    log("File size: " + file.length());
    byte[] result = new byte[(int)file.length()];
    try {
      InputStream input = null;
      try {
        int totalBytesRead = 0;
        input = new BufferedInputStream(new FileInputStream(file));
        while(totalBytesRead < result.length){
          int bytesRemaining = result.length - totalBytesRead;
          //input.read() returns -1, 0, or more :
          //bytepointer = totalBytesRead*100/result.length; 
          int bytesRead = input.read(result, totalBytesRead, bytesRemaining); 
          progressBar.setValue((int)((bytesRead/result.length)*100));
          if (bytesRead > 0){
            totalBytesRead = totalBytesRead + bytesRead;
          }
        }
        frame.setVisible(false);
        
        log("Num bytes read: " + totalBytesRead);
      }
      finally {
        log("Closing input stream.");
        input.close();
      }
    }
    catch (FileNotFoundException ex) {
      log("File not found.");
    }
    catch (IOException ex) {
      log(ex);
    }
    return result;
  }
  
    
  /**
   Write a byte array to the given file. 
   Writing binary data is significantly simpler than reading it. 
  */
  void write(byte[] aInput, String aOutputFileName){
    log("Writing binary file...");
    try {
      OutputStream output = null;
      try {
        output = new BufferedOutputStream(new FileOutputStream(aOutputFileName));
        output.write(aInput);
      }
      finally {
        output.close();
      }
    }
    catch(FileNotFoundException ex){
      log("File not found.");
    }
    catch(IOException ex){
      log(ex);
    }
  }
  
  /** Read the given binary file, and return its contents as a byte array.*/ 
  byte[] readAlternateImpl(String aInputFileName){
    log("Reading in binary file named : " + aInputFileName);
    File file = new File(aInputFileName);
    log("File size: " + file.length());
    byte[] result = null;
    try {
      InputStream input =  new BufferedInputStream(new FileInputStream(file));
      result = readAndClose(input);
    }
    catch (FileNotFoundException ex){
      log(ex);
    }
    return result;
  }
  
  /**
   Read an input stream, and return it as a byte array.  
   Sometimes the source of bytes is an input stream instead of a file. 
   This implementation closes aInput after it's read.
  */
  byte[] readAndClose(InputStream aInput){
    //carries the data from input to output :    
    byte[] bucket = new byte[32*1024]; 
    ByteArrayOutputStream result = null; 
    try  {
      try {
        //Use buffering? No. Buffering avoids costly access to disk or network;
        //buffering to an in-memory stream makes no sense.
        result = new ByteArrayOutputStream(bucket.length);
        int bytesRead = 0;
        while(bytesRead != -1){
          //aInput.read() returns -1, 0, or more :
          bytesRead = aInput.read(bucket);
          if(bytesRead > 0){
            result.write(bucket, 0, bytesRead);
          }
        }
      }
      finally {
        aInput.close();
        //result.close(); this is a no-operation for ByteArrayOutputStream
      }
    }
    catch (IOException ex){
      log(ex);
    }
    return result.toByteArray();
  }
  
  private static void log(Object aThing){
    System.out.println(String.valueOf(aThing));
  }
  public int getbytepointer()
  {
      return bytepointer;
  }
} 
class MD5Hashing
{
    String md5encryption(String password) throws Exception
    {
        String key = "19KNKir@n1995";
        password = key.concat(password);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return (sb.toString());
    }
}
