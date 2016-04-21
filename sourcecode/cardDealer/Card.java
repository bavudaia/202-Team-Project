public class Card {

	private Boolean isTrue;
	private Boolean gameIsOn;
	private int num;
	private int back;
	private Boolean face;
	public String resource;
	private String player;
	public Boolean getStatus() {
		return gameIsOn;
	}
	public void setStatus(String gameIsOn) {
		this.gameIsOn= gameIsOn;
	}
	public String getResource() {
		return resource;
	}
	public void setSrc(String src) {
		this.src= src;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int num) {
		this.num = num;
	}
	public int getback() {
		return back;
	}
	public void setback(int back) {
		this.back = back;
	}
	public Boolean getFace() {
		return face;
	}
	public void setFace(Boolean face) {
		this.face = face;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public Card() {
		super();
		setnum(0);
		setback(0);
		setFace(true);
	}
	public void flip(){
		if(!this.face){
		this.face = true;
		}
		else {
		this.face = false;
		}
    }
}
