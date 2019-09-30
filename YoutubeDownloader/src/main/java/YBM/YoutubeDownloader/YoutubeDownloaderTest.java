package YBM.YoutubeDownloader;

import java.io.PrintWriter;

public class YoutubeDownloaderTest {
	public static void main(String[] args) {
		String download_path = "C:\\Users\\Ieyze Sales Dept\\Downloads";
		String url = "https://www.youtube.com/watch?v=7h1s2SojIRw";

		String[] command = { "cmd", "/K", "Start" };
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			
			stdin.println("C:");
			stdin.println("cd \""+download_path+"\"");
            stdin.println("youtube-dl "+url);
			stdin.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main()
}//class