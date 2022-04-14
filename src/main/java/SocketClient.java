import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description:
 * @author: zhengyuhui
 * @date: 2022/4/13 16:27
 */
public class SocketClient {
	public static void main(String[] args) throws InterruptedException {
		try {
			// 和服务器创建连接
			Socket socket = new Socket("localhost",6666);
			// 要发送给服务器的信息
			OutputStream os = socket.getOutputStream();
			while(true){
				PrintWriter pw = new PrintWriter(os);
				pw.write("我是客户端：您好server!~");
				pw.flush();
				Thread.sleep(3000L);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
