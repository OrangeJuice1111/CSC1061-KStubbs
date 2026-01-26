
public class Radio {
	
	public static final int MAX_Volume = 10;
	private int volume = 0;
	private boolean hasAntenna = false;
	
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		if(volume > MAX_Volume) {
		this.volume = volume;
	}
		else this.volume = 10;
	}
	public boolean hasAntenna() {
		return hasAntenna;
	}
	public void setHasAntenna(boolean hasAntenna) {
		this.hasAntenna = hasAntenna;
	}
	@Override
	public String toString() {
		return "Radio [volume=" + volume + ", hasAntenna=" + hasAntenna + "]";
	}
	
	
}
