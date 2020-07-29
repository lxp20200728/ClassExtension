package ClassExtends;

public abstract class BaseServersPartInfo {
	protected BaseFormatServerLine[] myServerLines = new BaseFormatServerLine[100];
	protected int serverCount = 0;
	public BaseServersPartInfo(BaseFormatServerLine[] serverLines,int count) {
		this.myServerLines = serverLines;
		this.serverCount = count;
	}
	public abstract String getServerPartInfo();
}
