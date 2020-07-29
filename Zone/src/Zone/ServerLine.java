package Zone;

public class ServerLine {
	private String head = "\t"+ "\t" + "<server>";
	private String end = "</server>" + "\n";
	private String ip = null;
	private int port = 0;
	public ServerLine() {}
	public ServerLine(String ip, int prot){
		this.ip = ip;
		this.port = prot;
	}
	
	public String getServerLine() {
		return  (head + this.ip + "/" + this.port + end );
	}
	
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
}
