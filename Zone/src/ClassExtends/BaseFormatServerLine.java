package ClassExtends;

public abstract class BaseFormatServerLine {
	protected String ip = null;
	protected int port = 0;
	protected char c = 34;
	public BaseFormatServerLine(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	public abstract String getServerInfo();
	public abstract void setEndType(Boolean isLast);
	public String getIp(){
		return this.ip;
	}
	public int getPort(){
		return this.port;
	}

}
