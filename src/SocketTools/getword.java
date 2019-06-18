package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class getword implements Runnable {
    final static int port1 = 10001;
    public void run(){
        try {
            ServerSocket wordserver = new ServerSocket(port1);
            while(true){
                Socket socket = wordserver.accept();
                Thread subword= new Thread(new TsubwordHandle(socket));
                subword.start();
            }
        }
        catch(IOException e){
        }
    }
}
class TsubwordHandle implements  Runnable{
    Socket Subword;
    private DataInputStream dis;
    private FileOutputStream fos;
    TsubwordHandle(Socket subword){
        this.Subword=subword;
    }
    public void run(){
        try {
            dis = new DataInputStream(Subword.getInputStream());
            // 文件名和长度
            String fileName = dis.readUTF();
            long fileLength = dis.readLong();
            File directory = new File("E:/b");
            if(!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);

            fos = new FileOutputStream(file);
            System.out.println("file。。。。。。。。。。。。。。"+file);
            System.out.println("fileName。。。。。。。。。。。。。。"+fileName);

            System.out.println("======== 开始接收文件 ========");
            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = dis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, length);
                fos.flush();
            }
            System.out.println("======== 文件接收成功 ========");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null)
                    fos.close();
                if(dis != null)
                    dis.close();
                Subword.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}